package com.bocheng.springbootmall.service;

import com.bocheng.springbootmall.dto.ProductRequest;
import com.bocheng.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
