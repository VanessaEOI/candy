package com.candy.controller;

import com.candy.dto.OrderRequest;
import com.candy.entity.CustomerOrder;
import com.candy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candy")
public class CustomerOrderController {

    private final OrderService orderService;

    @Autowired
    public CustomerOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public CustomerOrder placeOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.processOrder(orderRequest);
    }

}