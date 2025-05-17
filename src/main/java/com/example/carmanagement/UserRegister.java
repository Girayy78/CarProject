package com.example.carmanagement;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.Event;

import javafx.event.Event;
import java.io.IOException;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class UserRegister implements Initializable {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private TextField fullNameTextField;

    @FXML
    private TextField eMailTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Label statusLabel;

    @FXML
    private void registerUser(Event event) {
        String username = usernameTextField.getText();
        String password = passwordField.getText();
        String role = roleComboBox.getValue();
        String fullName = fullNameTextField.getText();
        String email = eMailTextField.getText();
        String phone = phoneNumberTextField.getText();

        String sql = "INSERT INTO users (username, password, role, fullname, email, phone) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DataBase.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, role);
            pstmt.setString(4, fullName);
            pstmt.setString(5, email);
            pstmt.setString(6, phone);

            pstmt.executeUpdate();
            statusLabel.setText("User registered successfully.");

            // Clear fields
            usernameTextField.clear();
            passwordField.clear();
            roleComboBox.getSelectionModel().clearSelection();
            fullNameTextField.clear();
            eMailTextField.clear();
            phoneNumberTextField.clear();

        } catch (Exception e) {
            statusLabel.setText("Registration error: " + e.getMessage());
        }
    }
    public void goToHomePage(Event event) throws IOException {
        SceneController.switchTo("homePage.fxml", event, "HomePage", "/loginCSS.css");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleComboBox.setItems(FXCollections.observableArrayList("Customer", "Admin"));
    }
}
