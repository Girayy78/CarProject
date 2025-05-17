package com.example.carmanagement;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.event.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {
    public void goToHomePage(Event event) throws IOException {
        SceneController.switchTo("homePage.fxml", event, "HomePage", "/loginCSS.css");
    }
    @FXML
    private ComboBox<String> vehicleTypeComboBox;

    @FXML
    private TextField licensePlateTextField;

    @FXML
    private TextField modelTextField;

    @FXML
    private TextField yearOfManufactureTextField;

    @FXML
    private TextField fuelTypeTextField;

    @FXML
    private Label statusLabel;

    @FXML
    private void registerVehicle() {
        String licensePlate = licensePlateTextField.getText();
        String model = modelTextField.getText();
        String year = yearOfManufactureTextField.getText();
        String fuel = fuelTypeTextField.getText();
        String type = vehicleTypeComboBox.getValue();

        String sql = "INSERT INTO car(brand, model) VALUES(?, ?)";

        try (Connection conn = DataBase.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, type);
            pstmt.setString(2, model);

            pstmt.executeUpdate();
            statusLabel.setText("Car is added successfully.");

            // Alanları temizle
            licensePlateTextField.clear();
            modelTextField.clear();
            yearOfManufactureTextField.clear();
            fuelTypeTextField.clear();
            vehicleTypeComboBox.getSelectionModel().clearSelection();

        } catch (Exception e) {
            statusLabel.setText("Registiration error: " + e.getMessage());
        }
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
      vehicleTypeComboBox.setItems(FXCollections.observableArrayList("Car","Truck", "Motorcycle"));

    }
}
