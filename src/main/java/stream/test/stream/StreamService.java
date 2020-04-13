package stream.test.stream;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import message.SOSensorData;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.reflect.ReflectData;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.JoinWindows;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import static stream.test.config.ConfigurationConstants.*;

/**
 * Main class that performs stream join and writes result data to provided topic.
 */
public class StreamService {

    public StreamService() {
    }

    private final static Logger logger = LoggerFactory.getLogger(StreamService.class);

    private final Serde<GenericRecord> recordSerDe = new GenericAvroSerde() {{
        this.configure(
                new HashMap<String, String>() {{
                    this.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY);
                }}, false);
    }};

    private final Serde<String> keySerDe = Serdes.String();

    public void start() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "stream");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_HOST);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, GenericAvroSerde.class.getName());
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY);

        StreamsBuilder builder = new StreamsBuilder();

        KStream<String, GenericRecord> pStream = builder.stream(P_SENSOR_TOPIC, Consumed.with(keySerDe, recordSerDe));

        KStream<String, GenericRecord> tStream = builder.stream(T_SENSOR_TOPIC, Consumed.with(keySerDe, recordSerDe));

        // since all data is stored in separate topics, the joined topic contains only inner join data.
        pStream.join(tStream, StreamService::joinSensors, JoinWindows.of(Duration.ofSeconds(STREAM_WINDOWS_SIZE_SECONDS)))
                .to(SO_SENSOR_TOPIC, Produced.with(keySerDe, recordSerDe));


        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();

    }


    public static GenericRecord joinSensors(GenericRecord pSensorValue, GenericRecord tSensorValue) {

        final Schema schema = ReflectData.get().getSchema(SOSensorData.class);
        final GenericData.Record record = new GenericData.Record(schema);

        if (pSensorValue != null && tSensorValue != null) {
            logger.info("pValue: [{}], tValue: [{}]", pSensorValue.get("device_id"), tSensorValue.get("device_id"));
        }

        if (pSensorValue != null) {
            record.put("device_id", pSensorValue.get("device_id"));
            record.put("p_measurement_time", pSensorValue.get("measurement_time"));
            record.put("latitude", pSensorValue.get("latitude"));
            record.put("longitude", pSensorValue.get("longitude"));
        }

        if (tSensorValue != null ) {
            record.put("device_id", tSensorValue.get("device_id"));
            record.put("temperature", tSensorValue.get("temperature"));
            record.put("t_measurement_time", tSensorValue.get("measurement_time"));
        }

        return record;

    }
}
