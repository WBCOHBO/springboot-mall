package com.bocheng.springbootmall.service;

import com.bocheng.springbootmall.dto.CreateOrderRequest;
import com.bocheng.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
