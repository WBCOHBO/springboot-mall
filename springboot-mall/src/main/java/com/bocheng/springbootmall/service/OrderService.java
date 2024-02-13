package com.bocheng.springbootmall.service;

import com.bocheng.springbootmall.dto.CreateOrderRequest;
import com.bocheng.springbootmall.dto.OrderQueryParams;
import com.bocheng.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);
}
