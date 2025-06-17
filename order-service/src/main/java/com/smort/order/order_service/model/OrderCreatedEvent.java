package com.smort.order.order_service.model;

import java.io.Serializable;

public class OrderCreatedEvent implements Serializable {

    private String orderId;
    private String productName;
    private int quantity;
    private double price;

    public OrderCreatedEvent() {}  // Jackson needs no-arg constructor

    public OrderCreatedEvent(String orderId, String productName, int quantity, double price) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // GETTERS
    public String getOrderId() { return orderId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    // SETTERS
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }
}
