package com.bocheng.springbootmall.dao;

import com.bocheng.springbootmall.dto.ProductQueryParams;
import com.bocheng.springbootmall.dto.ProductRequest;
import com.bocheng.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    List<Product> getProducts();
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

    void updateStock(Integer productId, Integer stock);
}
