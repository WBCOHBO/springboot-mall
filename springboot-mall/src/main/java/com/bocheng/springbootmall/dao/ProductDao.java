package com.bocheng.springbootmall.dao;

import com.bocheng.springbootmall.dto.ProductRequest;
import com.bocheng.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
