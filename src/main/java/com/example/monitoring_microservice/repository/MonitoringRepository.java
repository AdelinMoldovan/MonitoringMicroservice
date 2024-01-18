package com.example.monitoring_microservice.repository;


import com.example.monitoring_microservice.models.MonitoredValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MonitoringRepository extends JpaRepository<MonitoredValues, Integer> {

    Optional<MonitoredValues> findById(@Param("monitoring_id") Integer monitoringId);
    List<MonitoredValues> findAllByDeviceIdOrderByTimestampDesc(Integer deviceId);
}
