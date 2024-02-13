package com.bocheng.springbootmall.controller;

import com.bocheng.springbootmall.dto.CreateOrderRequest;
import com.bocheng.springbootmall.model.Order;
import com.bocheng.springbootmall.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         //接住前端傳過來的 Json參數
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest){
        //資料庫插入數據
        Integer orderId = orderService.createOrder(userId, createOrderRequest);

        //數據傳給前端
        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
