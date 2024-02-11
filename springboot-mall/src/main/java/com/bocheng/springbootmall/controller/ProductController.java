package com.bocheng.springbootmall.controller;

import com.bocheng.springbootmall.model.Product;
import com.bocheng.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    //取得商品數據要注入 ProductService的 Bean
    @Autowired
    private ProductService productService;

    //ResponseEntity 自定義回傳的 http response的細節
    //返回 Product類型的 ResponseEntity
    //取得商品數據用 Get請求
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        //從 productService.getProductById查詢 productId的商品出來
        Product product = productService.getProductById(productId);

        //判斷 product值
        if (product != null){
            //回傳200與 product給前端的 body
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            // 回傳 404給前端
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
