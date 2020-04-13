package stream.test.producer;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import message.PSensorData;
import message.TSensorData;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import static stream.test.config.ConfigurationConstants.*;

/**
 * Class exists just to populate Kafka with messages.
 */
public class Producer {

    private final static int TEST_BATCH_SIZE = 100;
    private final static int TEST_NUMBER_OF_DEVICES = 10;

    public void produce() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_HOST);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY);

        KafkaProducer<String, PSensorData> pProducer = new KafkaProducer<>(props);
        KafkaProducer<String, TSensorData> tProducer = new KafkaProducer<>(props);

        List<String> deviceIds = new ArrayList<>();

        // To make the result more consistent and do not have all random devices, the number of the device is reduced
        for (int i = 0; i < TEST_NUMBER_OF_DEVICES; i++) {
            deviceIds.add(UUID.randomUUID().toString());
        }

        for (int i = 0; i < TEST_BATCH_SIZE; i++) {

            String deviceId = deviceIds.get((int) (9 * Math.random()));

            double temperature = (40.0 * Math.random()) + 10;
            double latitude = (5 * Math.random()) + 50;
            double longitude = (5 * Math.random()) + 30;

            pProducer.send(getPRecordData(deviceId, latitude, longitude));
            tProducer.send(getTRecord(deviceId, temperature));
        }

    }

    /**
     * Generates record for P sensor data.
     *
     * @param deviceId  Device Identifier
     * @param latitude  latitude
     * @param longitude longitude
     * @return next Record for Kafka
     */
    public ProducerRecord<String, PSensorData> getPRecordData(String deviceId, double latitude, double longitude) {
        long measurementTime = System.currentTimeMillis();

        final PSensorData pSensorData =
                PSensorData.newBuilder()
                        .setDeviceId(deviceId)
                        .setMeasurementTime(measurementTime)
                        .setLatitude(latitude)
                        .setLongitude(longitude)
                        .build();

        return new ProducerRecord<>(P_SENSOR_TOPIC,
                deviceId, pSensorData);
    }

    /**
     * Generates record for T sensor data.
     *
     * @param deviceId    Device Identifier
     * @param temperature Temperature
     * @return next Record for Kafka
     */
    public ProducerRecord<String, TSensorData> getTRecord(String deviceId, double temperature) {
        long measurementTime = System.currentTimeMillis();

        final TSensorData tSensorData =
                TSensorData.newBuilder()
                        .setDeviceId(deviceId)
                        .setMeasurementTime(measurementTime)
                        .setTemperature(temperature).build();

        return new ProducerRecord<>(T_SENSOR_TOPIC,
                deviceId, tSensorData);
    }
}
