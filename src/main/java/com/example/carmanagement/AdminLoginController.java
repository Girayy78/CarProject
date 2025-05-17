package com.example.carmanagement;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.event.Event;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.carmanagement.SceneController.switchTo;

public class AdminLoginController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private void goBack(Event event) throws IOException {
        switchTo("roleSelect.fxml", event, "Select Login", "/loginCSS.css");
    }

    @FXML
    private void login(Event event) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please fill in all fields.");
            return;
        }

        if (!checkLogin(username, password)) {
            errorLabel.setText("Invalid credentials. Please try again.");
            return;
        }

        errorLabel.setText("");
        try {
            switchTo("adminDashboard.fxml", event, "Admin Dashboard", "/loginCSS.css");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkLogin(String username, String password) {
        String sql = "SELECT * FROM users WHERE name = ? AND password = ? AND LOWER(role) = 'admin'";

        try (Connection conn = DataBase.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            System.out.println("SQL Query: " + pstmt);
            ResultSet rs = pstmt.executeQuery();

            boolean match = rs.next();
            System.out.println(match ? "\u2713 Matching admin found." : "\u2717 No matching admin found.");
            return match;

        } catch (Exception e) {
            System.out.println("Error during admin login: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }
}
