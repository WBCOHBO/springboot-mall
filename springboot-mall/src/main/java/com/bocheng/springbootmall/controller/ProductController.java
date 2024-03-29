package com.bocheng.springbootmall.controller;

import com.bocheng.springbootmall.constant.ProductCategory;
import com.bocheng.springbootmall.dto.ProductQueryParams;
import com.bocheng.springbootmall.dto.ProductRequest;
import com.bocheng.springbootmall.model.Product;
import com.bocheng.springbootmall.service.ProductService;
import com.bocheng.springbootmall.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class ProductController {

    //取得商品數據要注入 ProductService的 Bean
    @Autowired
    private ProductService productService;

    //查詢商品列表
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            //使用 ProductCategory enum當作參數類型傳入，
            // SpringBoot會自動將前端傳入的字串，去轉換成 ProductCategory enum。
            // 將category的值傳入 DAO層，用 where來查詢
            @RequestParam(required = false) ProductCategory category,
            //新增關鍵字查詢
            @RequestParam(required = false) String search,
            //排序商品
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,
            //實作分頁功能，對應 sql中 limit and offset的用法。
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit, //取得幾筆數據
            @RequestParam(defaultValue = "0") @Min(0)Integer offset //要跳過幾筆數據
    ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);


        //取得 product list
        List<Product> productList = productService.getProducts(productQueryParams);

        //取得 product總數
        Integer total = productService.countProduct(productQueryParams);

        //分頁
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResult(productList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    //查詢單個商品功能
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

    @PutMapping("/products/{productId}")
    //修改商品功能
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 //接住前端商品修改過後的數據
                                                 @RequestBody @Valid ProductRequest productRequest){
        //查詢並判斷前端給的商品 ID
        Product product = productService.getProductById(productId);

        if (product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //productId : 表示要更新哪個商品。productRequest 修改的值
        productService.updateProduct(productId, productRequest);

        //從DB中取得更新後的數據出來
        Product updatedProduct = productService.getProductById(productId);

        //回傳給前端200，並呈現在 body中
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    //刪除商品的功能
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
