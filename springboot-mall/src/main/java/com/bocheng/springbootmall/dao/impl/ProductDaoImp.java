package com.bocheng.springbootmall.dao.impl;

import com.bocheng.springbootmall.dao.ProductDao;
import com.bocheng.springbootmall.model.Product;
import com.bocheng.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImp implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id, product_name, category, image_url, price," +
                " stock, description, created_date, last_modified_date " +
                "FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        // 用.query() 查詢數據，要傳3個參數。第三個 RowMapper在rowMapper.ProductRowMapper.java
        //productList 接住.query方法的返回值
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        //判斷 productList
        if (productList.size() > 0){
            return productList.get(0);
        }else {
            return null;
        }

    }
}
