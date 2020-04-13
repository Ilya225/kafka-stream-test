package stream.rest.app.service;

import lombok.RequiredArgsConstructor;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import stream.rest.app.conf.KafkaConf;
import stream.rest.app.dto.SODto;

@Service
@RequiredArgsConstructor
public class SOListener {

    private final static Logger logger = LoggerFactory.getLogger(SOListener.class);

    private final SOService soService;

    @KafkaListener(topics = KafkaConf.SO_SENSOR_TOPIC, groupId = "spring-app")
    public void listen(ConsumerRecord<String, GenericRecord> message) {
        System.out.println(message.key());

        SODto dto = new SODto();
        dto.setPMeasurementTime((long) message.value().get("p_measurement_time"));
        dto.setTMeasurementTime((long) message.value().get("t_measurement_time"));
        dto.setDeviceId((String) message.value().get("device_id"));
        dto.setLatitude((double) message.value().get("latitude"));
        dto.setLongitude((double) message.value().get("longitude"));
        dto.setTemperature((double) message.value().get("temperature"));


        soService.save(message.key(), dto);
        logger.info("saved message from device: [{}]", message.key());
    }
}
