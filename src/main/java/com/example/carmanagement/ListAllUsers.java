package com.example.carmanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListAllUsers {
    public static void main(String[] args) {
        try (Connection conn = DataBase.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Password: " + rs.getString("password") +
                        ", Role: " + rs.getString("role") +
                        ", Plate: " + rs.getString("plate"));
            }

        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }
    }
}
