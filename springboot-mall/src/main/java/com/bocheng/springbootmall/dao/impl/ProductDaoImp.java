package com.bocheng.springbootmall.dao.impl;

import com.bocheng.springbootmall.dao.ProductDao;
import com.bocheng.springbootmall.dto.ProductQueryParams;
import com.bocheng.springbootmall.dto.ProductRequest;
import com.bocheng.springbootmall.model.Product;
import com.bocheng.springbootmall.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImp implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
        String sql = "SELECT count(*) FROM product WHERE 1=1";

        Map<String, Object> map = new HashMap<>();

        //查詢條件
        if (productQueryParams.getCategory() != null){
            sql = sql + " AND category = :category";
            //用.name()轉成字串
            map.put("category", productQueryParams.getCategory().name());
        }

        if (productQueryParams.getSearch() != null){
            // sql的模糊查詢 LIKE %不能寫在 sql語句中。
            //一定要寫在 arrayList中，這是JDBC的限制
            sql = sql + " AND product_name LIKE :search";
            map.put("search", "%" + productQueryParams.getSearch() + "%");
        }

        Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);

        return total;
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description," +
                "created_date, last_modified_date " +
                "FROM product WHERE 1=1";
        // WHERE 1=1的用途 : 為了要讓下面的 if enum能判斷是否為 null，並執行 sql的 string 拼接
        Map<String, Object> map = new HashMap<>();

        //查詢條件
        if (productQueryParams.getCategory() != null){
            sql = sql + " AND category = :category";
            //用.name()轉成字串
            map.put("category", productQueryParams.getCategory().name());
        }

        if (productQueryParams.getSearch() != null){
           // sql的模糊查詢 LIKE %不能寫在 sql語句中。
            //一定要寫在 arrayList中，這是JDBC的限制
            sql = sql + " AND product_name LIKE :search";
           map.put("search", "%" + productQueryParams.getSearch() + "%");
        }

        //排序
        //sql 排序語法只能以字串拼接的方式實作。
        //因為 Controller的參數有設定@RequestParam的default value，所以不用另外判斷是否為 null
        sql = sql + " ORDER BY " + productQueryParams.getOrderBy() + " " + productQueryParams.getSort();

        //分頁
        sql = sql + " LIMIt :limit OFFSET :offset";

        map.put("limit", productQueryParams.getLimit());
        map.put("offset", productQueryParams.getOffset());

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return productList;
    }

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

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product (product_name, category, image_url, " +
                "price, stock, description, created_date, last_modified_date) " +
                "VALUES (:productName, :category, :imageUrl, :price, :stock, " +
                ":description, :createDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now = new Date();
        map.put("createDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        //更新資料庫，建立新商品
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        //將新商品的 productId存取
        int productId = keyHolder.getKey().intValue();

        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE product SET product_name = :productName, category = :category, image_Url = :imageUrl," +
                "price = :price, stock = :stock, description = :description, last_Modified_date = :lastModifiedDate" +
                " WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());
        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql,map);
    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql,map);
    }
}
