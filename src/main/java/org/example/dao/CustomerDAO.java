package org.example.dao;

import org.example.model.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public interface CustomerDAO {
    List<Customer> getAllCustomers(Connection con) throws SQLException;
    List<Integer> getCustomerIds(Connection con) throws SQLException;
}
