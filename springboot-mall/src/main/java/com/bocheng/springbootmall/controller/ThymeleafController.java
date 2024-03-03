package com.bocheng.springbootmall.controller;

import com.bocheng.springbootmall.model.Product;
import com.bocheng.springbootmall.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ThymeleafController {

    @Autowired
    private ProductService productService;

    //Web 商品列表
    @GetMapping("/index")
    public String getProducts(
            Model model) throws JsonProcessingException {
        List<Product> productList = productService.getProducts();

        model.addAttribute("productList", productList);

        return "index";
    }

    // web 查詢單一商品
    @GetMapping("/searchProduct/{productId}")
    public String getProduct(@PathVariable Integer productId,
                             Model model) throws JsonProcessingException {
        //從 productService.getProductById查詢 productId的商品出來
        Product product = productService.getProductById(productId);

        ObjectMapper objectMapper = new ObjectMapper();

        //Java Object -> Json字串
        String jsonString = objectMapper.writeValueAsString(product);

        //Json字串 -> Java Object
        Product dataObject = objectMapper.readValue(jsonString, Product.class);

        model.addAttribute("jsonString", dataObject);

        return "searchProduct";
    }

}

