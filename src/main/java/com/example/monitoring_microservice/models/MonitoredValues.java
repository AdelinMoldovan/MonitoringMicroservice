package com.example.monitoring_microservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name ="monitored_values")
public class MonitoredValues {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "device_id")
    private Integer deviceId;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "consumtionValue")
    private Float consumtionValue;

    public MonitoredValues(){}
    public MonitoredValues(Integer deviceId, Date timestamp, Float consumtionValue) {
        this.deviceId = deviceId;
        this.timestamp = timestamp;
        this.consumtionValue = consumtionValue;
    }
}