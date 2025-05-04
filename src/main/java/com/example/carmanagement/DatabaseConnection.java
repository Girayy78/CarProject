package com.example.carmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String connectionUrl = "jdbc:sqlserver://SERVER_NAME:1433;"
                + "database=DATABASE_NAME;"
                + "user=USERNAME;"
                + "password=PASSWORD;"
                + "encrypt=true;"
                + "trustServerCertificate=true;";

        return DriverManager.getConnection(connectionUrl);
    }
}
