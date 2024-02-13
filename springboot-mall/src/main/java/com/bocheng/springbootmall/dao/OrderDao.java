package com.bocheng.springbootmall.dao;

import com.bocheng.springbootmall.dto.CreateOrderRequest;
import com.bocheng.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
