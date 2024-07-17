package org.example;

import org.example.dao.CustomerDAO;
import org.example.dao.ProductDAO;
import org.example.dao.impl.CustomerDAOImpl;
import org.example.dao.impl.ProductDAOImpl;
import org.example.service.OrderService;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection con = DatabaseConnection.getConnection()) {
            ProductDAO productDAO = new ProductDAOImpl();
            CustomerDAO customerDAO = new CustomerDAOImpl();
            OrderService orderService = new OrderService(productDAO, customerDAO);

            orderService.createOrders(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
