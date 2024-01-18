package com.example.monitoring_microservice.service;

import com.example.monitoring_microservice.dto.MonitoringDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.monitoring_microservice.models.MonitoredValues;


public interface MonitoringService {
    ResponseEntity<MonitoredValues> addMonitoring(MonitoringDTO monitoringDTO);

    ResponseEntity<?> getMonitoredValues(Integer deviceId) throws IllegalAccessException;
}
