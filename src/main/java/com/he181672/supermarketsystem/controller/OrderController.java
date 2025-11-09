package com.he181672.supermarketsystem.controller;

import com.he181672.supermarketsystem.dto.OrderDTO;
import com.he181672.supermarketsystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class OrderController {
    private final OrderService orderService;
    @PostMapping("/order/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO) {
        System.out.println(orderDTO);
        orderService.createOrder(orderDTO);
        return ResponseEntity.ok("Order Created Successfully");
    }
}
