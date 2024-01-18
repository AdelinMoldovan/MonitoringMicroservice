package com.example.monitoring_microservice.dto;



import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.util.Date;

@Data
public class MonitoringDTO {
    private Integer id;
    private Date timestamp;
    private Float consumtionValue;

    public MonitoringDTO(Integer id, Date timestamp, Float consumtionValue) {
        this.id = id;
        this.timestamp = timestamp;
        this.consumtionValue = consumtionValue;
    }
}
