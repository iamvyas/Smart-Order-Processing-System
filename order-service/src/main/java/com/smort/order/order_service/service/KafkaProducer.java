package com.smort.order.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final String TOPIC = "order-events";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendOrderCreatedEvent(Object event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
