package com.example.carmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.example.carmanagement.DataBase;


public class InsertCar {
    public static void main(String[] args) {
        String sql = "INSERT INTO car(brand, model) VALUES(?, ?)";

        try (Connection conn = DataBase.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Toyota");
            pstmt.setString(2, "Corolla");

            pstmt.executeUpdate();
            System.out.println("Car is added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
