package org.example.dao.impl;

import org.example.DatabaseConnection;
import org.example.MyRuntimeException;
import org.example.dao.ProductDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public List<Integer> getProductIds() {
        List<Integer> productIds = new ArrayList<>();
        String query = "SELECT id FROM product;";
        Connection con = DatabaseConnection.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                productIds.add(id);
            }

        } catch (SQLException e) {
            throw new MyRuntimeException("Error retrieving all products from database");
        }
        return productIds;
    }

    @Override
    public double getProductPrice(int productId) {
        String query = "SELECT price FROM product WHERE id = ?";
        Connection con = DatabaseConnection.getConnection();

        try (PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, productId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("price");
                } else {
                    throw new MyRuntimeException("Product not found");
                }
            }
        } catch (SQLException e) {
            throw new MyRuntimeException("Error retrieving product price from database");
        }
    }
}
