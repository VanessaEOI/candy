package com.candy.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candy")
public class CandyOrderController {

    @PostMapping("/order")
    public String placeOrder() {
        return "placeOrder";
    }

}