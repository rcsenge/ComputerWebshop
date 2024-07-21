package org.example;

import org.example.dao.CustomerDAO;
import org.example.dao.OrderDAO;
import org.example.dao.ProductDAO;
import org.example.dao.impl.CustomerDAOImpl;
import org.example.dao.impl.OrderDAOImpl;
import org.example.dao.impl.ProductDAOImpl;


public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAOImpl();
        CustomerDAO customerDAO = new CustomerDAOImpl();
        OrderDAO orderDAO = new OrderDAOImpl();

        orderDAO.insertOrders(20, productDAO, customerDAO);
    }
}
