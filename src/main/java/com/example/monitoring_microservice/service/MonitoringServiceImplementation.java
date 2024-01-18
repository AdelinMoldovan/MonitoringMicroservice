package com.example.monitoring_microservice.service;


import com.example.monitoring_microservice.dto.MonitoringDTO;
import com.example.monitoring_microservice.models.MonitoredValues;
import com.example.monitoring_microservice.repository.MonitoringRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class MonitoringServiceImplementation implements MonitoringService{

    private final MonitoringRepository monitoringRepository;


    @Override
    public ResponseEntity<MonitoredValues> addMonitoring(MonitoringDTO monitoringDTO) {
        MonitoredValues monitoredValues = new MonitoredValues();
        monitoredValues.setDeviceId(monitoringDTO.getId());
        monitoredValues.setTimestamp(monitoringDTO.getTimestamp());
        monitoredValues.setConsumtionValue(monitoringDTO.getConsumtionValue());

        monitoredValues = monitoringRepository.save(monitoredValues);

        return ResponseEntity.ok(monitoredValues);
    }


    @Override
    public ResponseEntity<?> getMonitoredValues(Integer deviceId) throws IllegalAccessException {
        List<MonitoredValues> monitoredValuesList = monitoringRepository.findAllByDeviceIdOrderByTimestampDesc(deviceId);
        return ResponseEntity.ok(monitoredValuesList);
    }
}
