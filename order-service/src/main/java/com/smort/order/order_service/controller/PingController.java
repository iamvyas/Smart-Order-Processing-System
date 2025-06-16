package com.smort.order.order_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    //checking the basic flow of app
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
