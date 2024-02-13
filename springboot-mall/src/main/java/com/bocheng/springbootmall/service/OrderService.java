package com.bocheng.springbootmall.service;

import com.bocheng.springbootmall.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
