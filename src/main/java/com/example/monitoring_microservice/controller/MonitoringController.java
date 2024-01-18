package com.example.monitoring_microservice.controller;

import com.example.monitoring_microservice.service.MonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/monitoring")
@CrossOrigin(origins = "*")
public class MonitoringController {


    @Autowired
    MonitoringService monitoringService;

    @GetMapping("/getmonitoring")
    public ResponseEntity<?> getMonitoringValues(@RequestParam("device_id") Integer deviceId) throws IllegalAccessException {
        return monitoringService.getMonitoredValues(deviceId);

    }
}
