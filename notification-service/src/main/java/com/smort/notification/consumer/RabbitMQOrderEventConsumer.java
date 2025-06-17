package com.smort.notification.consumer;

import com.smort.notification.model.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQOrderEventConsumer {

    @RabbitListener(queues = "order.queue")
    public void consume(OrderCreatedEvent event) {
        System.out.println("[RabbitMQ] Received order from RabbitMQ: " + event);
    }
}
