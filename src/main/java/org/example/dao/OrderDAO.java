package org.example.dao;

public interface OrderDAO {
    void insertOrders(int amount, ProductDAO productDAO, CustomerDAO customerDAO);
}
