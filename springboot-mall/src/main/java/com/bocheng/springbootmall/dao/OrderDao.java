package com.bocheng.springbootmall.dao;

import com.bocheng.springbootmall.dto.CreateOrderRequest;
import com.bocheng.springbootmall.model.Order;
import com.bocheng.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}