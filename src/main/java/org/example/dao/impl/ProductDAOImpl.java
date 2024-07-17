package org.example.dao.impl;

import org.example.dao.ProductDAO;
import org.example.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Product> getAllProducts(Connection con) throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT id, name, description, price, in_stock, brand, product_type, category FROM product;";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            double price = rs.getDouble("price");
            int inStock = rs.getInt("in_stock");
            String brand = rs.getString("brand");
            String productType = rs.getString("product_type");
            String category = rs.getString("category");
            products.add(new Product(id, name, description, price, inStock, brand, productType, category));
        }
        rs.close();
        stmt.close();
        return products;
    }

    @Override
    public float getProductPrice(Connection con, int productId) throws SQLException {
        String query = "SELECT price FROM product WHERE id = ?";

        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, productId);

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            rs.close();
            pstmt.close();
            return rs.getFloat("price");
        } else {
            throw new SQLException("Product not found");
        }
    }

    @Override
    public List<Integer> getProductIds(Connection con) throws SQLException {
        List<Product> allProducts = getAllProducts(con);
        return allProducts.stream()
                .mapToInt(Product::getId)
                .boxed()
                .toList();
    }


}
