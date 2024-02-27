package com.bocheng.springbootmall.rowmapper;

import com.bocheng.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductListRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();

        product.setImageUrl(resultSet.getString("image_url"));
        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));

        return product;
    }
}
