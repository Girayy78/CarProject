package com.example.carmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.Statement;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Tablo kontrol ve oluşturma
        createTablesIfNotExist();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("roleSelect.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("carIcon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Car Service Management");
        scene.getStylesheets().add(getClass().getResource("/loginCSS.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }

    private void createTablesIfNotExist() {
        try (Connection conn = DataBase.connect(); Statement stmt = conn.createStatement()) {
            String createUsersTable = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL,
                    car_brand TEXT,
                    car_model TEXT,
                    plate TEXT,
                    vehicle_type TEXT
                );
            """;

            String createServicesTable = """
                CREATE TABLE IF NOT EXISTS service_selections (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT NOT NULL,
                    service_name TEXT NOT NULL,
                    selected INTEGER DEFAULT 0,
                    locked INTEGER DEFAULT 0,
                    selected_at TEXT
                );
            """;

            stmt.execute(createUsersTable);
            stmt.execute(createServicesTable);
            System.out.println("✔ Tables checked/created.");
        } catch (Exception e) {
            System.out.println("⚠ Error creating tables: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }                     //Launches the GUI
}
