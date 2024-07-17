package org.example.dao.impl;

import org.example.dao.CustomerDAO;
import org.example.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public List<Customer> getAllCustomers(Connection con) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT id, username, first_name, last_name, email, address FROM customer;";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            String address = rs.getString("address");
            customers.add(new Customer(id, username, firstName, lastName, email, address));
        }
        rs.close();
        stmt.close();
        return customers;
    }

    @Override
    public List<Integer> getCustomerIds(Connection con) throws SQLException {
        List<Customer> allCustomers = getAllCustomers(con);
        return allCustomers.stream()
                .mapToInt(Customer::getId)
                .boxed()
                .toList();
    }
}
