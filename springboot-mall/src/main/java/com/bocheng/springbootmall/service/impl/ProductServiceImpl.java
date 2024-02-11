package com.bocheng.springbootmall.service.impl;

import com.bocheng.springbootmall.dao.ProductDao;
import com.bocheng.springbootmall.model.Product;
import com.bocheng.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    // call productDao 的getProductById方法，把productId傳入
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
