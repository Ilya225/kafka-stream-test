package stream.test;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import message.PSensorData;
import message.TSensorData;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.reflect.ReflectData;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.StreamJoined;
import org.junit.Before;
import org.junit.Test;
import stream.test.stream.StreamService;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static stream.test.config.ConfigurationConstants.BROKER_HOST;
import static stream.test.config.ConfigurationConstants.STREAM_WINDOWS_SIZE_SECONDS;

public class StreamTests {

    private Properties streamsConfiguration;
    private static final String pTopic = "P_sensors_data";
    private static final String tTopic = "T_sensors_data";
    private static final String resultTopic = "SO";
    private static final String MOCK_URL = "mock://";

    @Before
    public void setUp() {
        streamsConfiguration = new Properties();
        streamsConfiguration.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream");
        streamsConfiguration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_HOST);
        streamsConfiguration.put(AbstractKafkaAvroSerDeConfig.AUTO_REGISTER_SCHEMAS, true);
        streamsConfiguration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, GenericAvroSerde.class.getName());
        streamsConfiguration.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, MOCK_URL);

    }

    @Test
    public void test_joinStreams_valid() throws Exception {

        List<KeyValue<String, GenericRecord>> pData = Arrays.asList(
                new KeyValue<>("device1", createPDataValue(1000, "device1", 10.2, 10.2)),
                new KeyValue<>("device2", createPDataValue(1001, "device2", 10.2, 10.2)),
                new KeyValue<>("device3", createPDataValue(1002, "device3", 10.2, 10.2)),
                new KeyValue<>("device4", createPDataValue(1003, "device4", 10.2, 10.2))
        );

        List<KeyValue<String, GenericRecord>> tData = Arrays.asList(
                new KeyValue<>("device1", createTDataValue(1000, "device1", 20.1)),
                new KeyValue<>("device2", createTDataValue(1001, "device2", 21.2)),
                new KeyValue<>("device3", createTDataValue(1002, "device3", 23.5))
        );

        final StreamsBuilder builder = new StreamsBuilder();
        final KStream<String, GenericRecord> pStream = builder.stream(pTopic);
        final KStream<String, GenericRecord> tStream = builder.stream(tTopic);

        final Serde<GenericRecord> recordSerDe = new GenericAvroSerde() {{
            this.configure(
                    new HashMap<String, String>() {{
                        this.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, MOCK_URL);
                    }}, false);
        }};

        pStream.join(tStream, StreamService::joinSensors, JoinWindows.of(Duration.ofSeconds(STREAM_WINDOWS_SIZE_SECONDS)),
                StreamJoined.with(Serdes.String(), recordSerDe, recordSerDe))
                .to(resultTopic, Produced.with(Serdes.String(), recordSerDe));

        try (final TopologyTestDriver topologyTestDriver = new TopologyTestDriver(builder.build(), streamsConfiguration)) {

            // Setup input and output topics
            final TestInputTopic<String, GenericRecord> pInput = topologyTestDriver
                    .createInputTopic(pTopic,
                            new StringSerializer(),
                            recordSerDe.serializer());

            final TestInputTopic<String, GenericRecord> tInput = topologyTestDriver
                    .createInputTopic(tTopic,
                            new StringSerializer(),
                            recordSerDe.serializer());

            final TestOutputTopic<String, GenericRecord> output = topologyTestDriver
                    .createOutputTopic(resultTopic, new StringDeserializer(), recordSerDe.deserializer());

            // Publish input data
            pInput.pipeKeyValueList(pData);
            tInput.pipeKeyValueList(tData);


            List<KeyValue<String, GenericRecord>> keyValues = output.readKeyValuesToList();


            assertThat(keyValues.size(), equalTo(3));
            assertThat(keyValues.get(0).key, equalTo("device1"));
            assertThat(keyValues.get(1).key, equalTo("device2"));
            assertThat(keyValues.get(2).key, equalTo("device3"));

        }

    }

    public GenericRecord createPDataValue(long measurementData, String deviceId, double lat, double lon) {
        final Schema schema = ReflectData.get().getSchema(PSensorData.class);
        final GenericData.Record record = new GenericData.Record(schema);

        record.put("measurement_time", measurementData);
        record.put("device_id", deviceId);
        record.put("latitude", lat);
        record.put("longitude", lon);


        return record;
    }

    public GenericRecord createTDataValue(long measurementData, String deviceId, double temp) {
        final Schema schema = ReflectData.get().getSchema(TSensorData.class);
        final GenericData.Record record = new GenericData.Record(schema);

        record.put("measurement_time", measurementData);
        record.put("device_id", deviceId);
        record.put("temperature", temp);

        return record;
    }
}
