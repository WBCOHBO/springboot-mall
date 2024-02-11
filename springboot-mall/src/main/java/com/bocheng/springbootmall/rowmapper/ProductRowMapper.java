package com.bocheng.springbootmall.rowmapper;

import com.bocheng.springbootmall.constant.ProductCategory;
import com.bocheng.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    //從 resultSet參數中來取得資料庫查詢出來的數據，然後儲存在 product變數中。
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));

        //使用 enum的 valueof，根據傳進去的字串去找尋對應ProductCategory的變數值
        // 然後存放到category的變數中。
        //最後將 category變數加到 set方法中。
        String categoryStr = resultSet.getString("category");
        ProductCategory category = ProductCategory.valueOf(categoryStr);
        product.setCategory(category);
        //進階寫法
        //product.setCategory(ProductCategory.valueOf(resultSet.getString(category)));


        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreateDate(resultSet.getTimestamp("created_date"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return product;
    }
}
