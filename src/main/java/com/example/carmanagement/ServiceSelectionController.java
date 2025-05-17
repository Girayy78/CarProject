package com.example.carmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.Event;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.carmanagement.SceneController.switchTo;

public class ServiceSelectionController {

    @FXML private Label welcomeLabel;

    @FXML
    public void initialize() {
        try (Connection conn = DataBase.connect()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT plate FROM users WHERE name = ?");
            stmt.setString(1, LoggedUser.getUsername());
            ResultSet rs = stmt.executeQuery();

            String plate = rs.next() ? rs.getString("plate") : "Unknown";
            welcomeLabel.setText("Car Plate: " + plate);
        } catch (Exception e) {
            e.printStackTrace();
            welcomeLabel.setText("Car Plate: Unknown");
        }
    }

    @FXML
    private void goEssentialMaintenance(Event event) throws IOException {
        switchTo("essentialMaintenance.fxml", event, "Essential Maintenance", "/loginCSS.css");
    }

    @FXML
    private void goOilChange(Event event) throws IOException {
        switchTo("oilChange.fxml", event, "Oil Change", "/loginCSS.css");
    }

    @FXML
    private void goBrakeServices(Event event) throws IOException {
        switchTo("brakeServices.fxml", event, "Brake Services", "/loginCSS.css");
    }

    @FXML
    private void goOptionalServices(Event event) throws IOException {
        switchTo("optionalServices.fxml", event, "Optional Services", "/loginCSS.css");
    }

    @FXML
    private void goServiceHistory(Event event) throws IOException {
        switchTo("serviceHistory.fxml", event, "Service History", "/loginCSS.css");
    }

    @FXML
    private void goRegisterCar(Event event) throws IOException {
        switchTo("carRegister.fxml", event, "Register Your Car", "/loginCSS.css");
    }

    @FXML
    private void goBack(Event event) throws IOException {
        switchTo("customerDashboard.fxml", event, "Customer Dashboard", "/loginCSS.css");
    }
}
