package com.bocheng.springbootmall.dao;

import com.bocheng.springbootmall.constant.ProductCategory;
import com.bocheng.springbootmall.dto.ProductRequest;
import com.bocheng.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
