package stream.rest.app.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import stream.rest.app.dto.SODto;
import stream.rest.app.service.SOService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class SOController {

    private final static Logger logger = LoggerFactory.getLogger(SOController.class);

    private final SOService soService;

    @GetMapping("/events/{device_id}")
    public ResponseEntity<List<SODto>> getByDeviceId(@PathVariable(name = "device_id") String deviceId) {
        logger.info("requesting events for device:  [{}]", deviceId);

        return Optional.ofNullable(soService.getById(deviceId)).map((events) ->
                new ResponseEntity<>(events, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @GetMapping("/devices")
    public ResponseEntity<List<String>> getDevices() {

        return Optional.ofNullable(soService.getDevices())
                .map(devices -> new ResponseEntity<>(devices, HttpStatus.OK))
                .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
