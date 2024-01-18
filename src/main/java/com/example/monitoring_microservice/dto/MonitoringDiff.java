package com.example.monitoring_microservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MonitoringDiff {
    private Date timestamp;
    private double diff;

    public MonitoringDiff(Date timestamp, double diff) {
        this.timestamp = timestamp;
        this.diff = diff;
    }
}
