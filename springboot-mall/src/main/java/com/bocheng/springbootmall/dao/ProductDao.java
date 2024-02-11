package com.bocheng.springbootmall.dao;

import com.bocheng.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
