package com.smort.order.order_service.service;

import com.smort.order.order_service.model.Order;
import com.smort.order.order_service.dto.OrderRequest;
import com.smort.order.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smort.order.order_service.model.OrderCreatedEvent;


import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaProducer kafkaProducer;

    public Order createOrder(OrderRequest request) {
        Order order = new Order();
        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());
        order.setPrice(request.getPrice());

        Order saved = orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(
            saved.getId(), saved.getProductName(), saved.getQuantity(), saved.getPrice()
        );

        kafkaProducer.sendOrderCreatedEvent(event);

        return saved;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
