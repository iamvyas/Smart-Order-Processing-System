package com.smort.notification.consumer;

import com.smort.notification.model.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    @RabbitListener(queues = "order.queue")
    public void consume(OrderCreatedEvent event) {
        System.out.println("📥 Received OrderCreatedEvent in Notification Service:");
        System.out.println(event);
    }
}
