package com.smort.order.order_service.producer;

import com.smort.order.order_service.model.OrderCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderCreatedEvent(OrderCreatedEvent event) {
        kafkaTemplate.send("order-events", event);
        System.out.println("Sent Kafka message => " + event);
    }
}
