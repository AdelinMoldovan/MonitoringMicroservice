package com.example.monitoring_microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitoringReq {
    private Integer id;
    private Integer deviceId;
    private Date timestamp;
    private Float consumtionValue;
}

