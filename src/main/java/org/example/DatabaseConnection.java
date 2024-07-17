package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = ConfigManager.getProperty("db.url");
        String user = ConfigManager.getProperty("db.user");
        String password = ConfigManager.getProperty("db.password");
        return DriverManager.getConnection(url, user, password);
    }
}
