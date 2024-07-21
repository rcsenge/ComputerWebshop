package org.example.dao.impl;

import org.example.DatabaseConnection;
import org.example.MyRuntimeException;
import org.example.dao.CustomerDAO;
import org.example.dao.OrderDAO;
import org.example.dao.ProductDAO;
import org.example.model.Order;
import org.example.service.OrderService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class OrderDAOImpl implements OrderDAO {
    public void insertOrders(int amount, ProductDAO productDAO, CustomerDAO customerDAO) {
        String insertOrderQuery = """
                INSERT INTO `order`(customer_id, product_id, quantity, order_date, order_completed_at, 
                is_personal_pickup, total_final_price, invoice_number)
                VALUES(?, ?, ?, ?, ?, ?, ?, ?);
                """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(insertOrderQuery)) {
            for (int i = 0; i < amount; i++) {
                OrderService orderService = new OrderService(new Random());
                Order order = orderService.createOrder(productDAO, customerDAO);
                pstmt.setInt(1, order.customerId());
                pstmt.setInt(2, order.productId());
                pstmt.setInt(3, order.quantity());
                pstmt.setDate(4, Date.valueOf(order.orderDate()));
                pstmt.setDate(5, Date.valueOf(order.orderCompletedAt()));
                pstmt.setString(6, order.isPersonalPickup());
                pstmt.setDouble(7, order.totalFinalPrice());
                pstmt.setString(8, order.invoiceNumber());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch (SQLException e) {
            throw new MyRuntimeException("Error occurred during inserting into order table");
        }

    }
}



