package org.example.dao.impl;

import org.example.DatabaseConnection;
import org.example.MyRuntimeException;
import org.example.dao.CustomerDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public List<Integer> getCustomerIds() {
        List<Integer> customerIds = new ArrayList<>();
        String query = "SELECT id FROM customer";

        Connection con = DatabaseConnection.getConnection();

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                customerIds.add(id);
            }
        } catch (SQLException e){
            throw new MyRuntimeException("Error retrieving customer ids");
        }


        return customerIds;
    }
}
