package com.smort.notification.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent {

    @JsonProperty("id")  // tells Jackson to map 'id' field from JSON to 'orderId' in this class
    private String orderId;

    private String productName;
    private int quantity;
    private double price;
}
