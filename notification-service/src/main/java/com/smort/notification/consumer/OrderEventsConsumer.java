package com.smort.notification.consumer;

import com.smort.notification.model.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventsConsumer {

    @KafkaListener(topics = "order-events", groupId = "notification-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(OrderCreatedEvent event) {
        System.out.println("📩 New Order Notification:");
        System.out.printf("➡ Order ID: %s | Product: %s | Qty: %d | Price: ₹%.2f%n",
                event.getOrderId(), event.getProductName(), event.getQuantity(), event.getPrice());
    }
}
