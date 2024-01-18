package com.example.monitoring_microservice.configuration;

import com.example.monitoring_microservice.dto.MonitoringDTO;
import org.slf4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Map;
import java.util.UUID;


@Configuration
public class RabbitMQConfiguration {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routing_key;

    @Value("${rabbitmq.queue.json.name}")
    private String jsonQueue;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJson_key;

    @Bean
    Queue queue() {
        return new Queue(queue);
    }

    @Bean
    public Queue jsonQueue(){
        return new Queue(jsonQueue);
    }


    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }


    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(exchange())
                .with(routing_key);
    }

    @Bean
    public Binding jsonBinding(){
        return BindingBuilder
                .bind(jsonQueue())
                .to(exchange())
                .with(routingJson_key);
    }

/*   @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }*/

    @Bean
    public MessageConverter converter() {
        return new MessageConverter() {
            @Override
            public Message toMessage(Object o, MessageProperties messageProperties) throws MessageConversionException {
                return new Message(o.toString().getBytes(), messageProperties);
            }

            @Override
            public Map<String, String> fromMessage(Message message) throws MessageConversionException {
                String messageString = new String(
                        message.getBody(),
                        StandardCharsets.UTF_8);
                 Map<String, String> result = MonitoringUtils.convertStringToMap(messageString);
                 return result;
            }
        };
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

    //RabbitTemplate
    //ConnectionFactory

    //RabbitAdmin
}
