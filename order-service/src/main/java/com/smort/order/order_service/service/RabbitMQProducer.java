package com.smort.order.order_service.service;

import com.smort.order.order_service.model.OrderCreatedEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrderCreatedEvent(OrderCreatedEvent event) {
        rabbitTemplate.convertAndSend(exchange, routingKey, event);
        System.out.println("📨 [RabbitMQ] Order event sent: " + event.getOrderId());
    }
}
