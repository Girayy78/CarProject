package com.example.carmanagement;

import java.sql.Connection;
import java.sql.Statement;

public class CreateTable {
    public static void createIfNotExists() {
        String userTable = """
            CREATE TABLE IF NOT EXISTS users (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                password TEXT NOT NULL,
                role TEXT NOT NULL
            );
        """;

        String serviceTable = """
            CREATE TABLE IF NOT EXISTS service_selections (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL,
                service_name TEXT NOT NULL,
                selected INTEGER DEFAULT 0,
                locked INTEGER DEFAULT 0,
                selected_at TEXT DEFAULT CURRENT_TIMESTAMP
            );
        """;

        String carTable = """
            CREATE TABLE IF NOT EXISTS car (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                username TEXT NOT NULL,
                brand TEXT NOT NULL,
                model TEXT NOT NULL,
                plate TEXT NOT NULL
            );
        """;

        try (Connection conn = DataBase.connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(userTable);
            stmt.execute(serviceTable);
            stmt.execute(carTable);
            System.out.println("Tables checked/created.");
        } catch (Exception e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }
}
