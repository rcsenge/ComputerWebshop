package org.example.dao;

import org.example.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts(Connection con) throws SQLException;
    float getProductPrice(Connection con, int productId) throws SQLException;
    List<Integer> getProductIds(Connection con) throws SQLException;
}
