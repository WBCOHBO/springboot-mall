package com.bocheng.springbootmall.service;

import com.bocheng.springbootmall.dto.ProductQueryParams;
import com.bocheng.springbootmall.dto.ProductRequest;
import com.bocheng.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    //傳兩個參數進去會很難維護，若傳入10幾個會很麻煩
    //可以創建新的 class，在裡面存放參數的值，再一口氣傳遞。
    // class路徑名稱 : ~/dto.ProductQueryParams
    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
