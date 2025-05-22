package com.example.carmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.carmanagement.SceneController.switchTo;

public class CarRegisterController {

    @FXML private TextField brandField;
    @FXML private TextField modelField;
    @FXML private TextField plateField;
    @FXML private ComboBox<String> vehicleTypeComboBox;
    @FXML private Label messageLabel;

    @FXML
    public void initialize() {
        vehicleTypeComboBox.getItems().addAll("Car", "Truck", "MotorCycle");

        try (Connection conn = DataBase.connect()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT car_brand, car_model, plate, vehicle_type FROM users WHERE name = ?"
            );
            stmt.setString(1, LoggedUser.getUsername());
            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getString("plate") != null) {
                brandField.setText(rs.getString("car_brand"));
                modelField.setText(rs.getString("car_model"));
                plateField.setText(rs.getString("plate"));
                vehicleTypeComboBox.setValue(rs.getString("vehicle_type"));

                brandField.setDisable(true);
                modelField.setDisable(true);
                plateField.setDisable(true);
                vehicleTypeComboBox.setDisable(true);
                messageLabel.setText("Car already registered.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void registerCar(ActionEvent event) {
        String brand = brandField.getText().trim();
        String model = modelField.getText().trim();
        String plate = plateField.getText().trim();
        String vehicleType = vehicleTypeComboBox.getValue();

        if (brand.isEmpty() || model.isEmpty() || plate.isEmpty() || vehicleType == null) {
            messageLabel.setText("All fields are required.");
            return;
        }

        try (Connection conn = DataBase.connect()) {
            PreparedStatement checkStmt = conn.prepareStatement(
                    "SELECT plate FROM users WHERE name = ?"
            );
            checkStmt.setString(1, LoggedUser.getUsername());
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getString("plate") != null) {
                messageLabel.setText("Car already registered.");
                return;
            }

            PreparedStatement updateStmt = conn.prepareStatement(
                    "UPDATE users SET car_brand = ?, car_model = ?, plate = ?, vehicle_type = ? WHERE name = ?"
            );
            updateStmt.setString(1, brand);
            updateStmt.setString(2, model);
            updateStmt.setString(3, plate);
            updateStmt.setString(4, vehicleType);
            updateStmt.setString(5, LoggedUser.getUsername());

            int affected = updateStmt.executeUpdate();
            if (affected > 0) {
                System.out.println("Car registered.");
                switchTo("serviceSelection.fxml", event, "Car Plate: " + plate, "/loginCSS.css");
            } else {
                messageLabel.setText("Failed to register car.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            messageLabel.setText("Database error.");
        }
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        switchTo("serviceSelection.fxml", event, "Service Selection", "/loginCSS.css");
    }
}