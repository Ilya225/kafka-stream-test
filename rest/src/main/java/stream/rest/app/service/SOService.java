package stream.rest.app.service;


import org.springframework.stereotype.Service;
import stream.rest.app.dto.SODto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * Service class for storing events read from kafka, it's an implementation for test purposes, it uses
 * ${@link ConcurrentHashMap} for storing events, but in prod it's better to use
 * some db (Cassandra, DynamoDB, BigTable, etc.)
 */
@Service
public class SOService {

    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<SODto>> cache = new ConcurrentHashMap<>();

    public void save(String deviceId, SODto record) {
        if (cache.get(deviceId) != null) {
            ConcurrentLinkedQueue<SODto> soDtos = cache.get(deviceId);
            soDtos.add(record);
        } else {
            ConcurrentLinkedQueue<SODto> messages = new ConcurrentLinkedQueue<>();
            messages.add(record);
            cache.put(deviceId, messages);
        }
    }

    public List<SODto> getById(String deviceId) {
        if (cache.get(deviceId) != null ) {
            return new ArrayList<>(cache.get(deviceId));
        } else {
            return null;
        }
    }

    public List<String> getDevices() {
        return Collections.list(cache.keys());
    }
}
