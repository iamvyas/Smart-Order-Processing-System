package com.smort.order.order_service.dto;

public class OrderRequest {
    private String productName;
    private int quantity;
    private double price;

    //Manually added getters
    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // optionally setters (needed for deserialization)
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
