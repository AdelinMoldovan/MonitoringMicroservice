package com.example.monitoring_microservice.consumer;

import com.example.monitoring_microservice.dto.MonitoringDTO;
import com.example.monitoring_microservice.models.MonitoredValues;
import com.example.monitoring_microservice.repository.MonitoringRepository;
import com.example.monitoring_microservice.service.MonitoringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Map;

@Service
public class RabbitMQJsonConsumer {

    private final MonitoringService monitoringService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    public RabbitMQJsonConsumer(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.json.name}")
    public void consumeJsonMessage(Map<String, String> map){
       LOGGER.info(String.format("Received JSON message " + map));
       try {
           Integer deviceId = Integer.valueOf(map.get("\"deviceId\""));
           Double measurementValue = Double.valueOf(map.get("\"measurementValue\""));
           String str = map.get("\"timestamp\"");
           Date timestamp = new Date(Long.parseLong(str));

//           System.out.println(deviceId);
//           System.out.println(measurementValue);
//           System.out.println(timestamp);

           MonitoringDTO monitoringDTO = new MonitoringDTO(
                   deviceId,
                   timestamp,
                   measurementValue.floatValue());


           System.out.println(monitoringDTO);
           monitoringService.addMonitoring(monitoringDTO);
       }catch (Exception e){
           System.out.println(e);
       }
    }
}
