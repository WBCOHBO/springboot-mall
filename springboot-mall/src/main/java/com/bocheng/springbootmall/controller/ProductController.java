package com.bocheng.springbootmall.controller;

import com.bocheng.springbootmall.dto.ProductRequest;
import com.bocheng.springbootmall.model.Product;
import com.bocheng.springbootmall.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    //取得商品數據要注入 ProductService的 Bean
    @Autowired
    private ProductService productService;

    //查詢商品功能
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

    //新增商品功能
    //創建新的 class，專門接住前段傳回來的 Json參數。放在 dto.ProductRequest
    //@RequestBody 接住前段傳過來的 request。要記得加上@Valid
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
        Integer productId = productService.createProduct(productRequest);

        //使用 productID來查詢商品數據
        Product product = productService.getProductById(productId);

        //把商品數據傳給前端 body，並回傳201
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
