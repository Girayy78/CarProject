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

public class CustomerLoginController {

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
    private void login(Event event) throws IOException {
        String username = usernameTextField.getText().trim();
        String password = passwordTextField.getText().trim();

        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please fill in all fields.");
            return;
        }

        try {
            if (checkLogin(username, password)) {
                LoggedUser.setUsername(username);
                ensureServiceSelectionRows(username);
                switchTo("serviceSelection.fxml", event, "Service Selection", "/loginCSS.css");
            } else {
                errorLabel.setText("Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            errorLabel.setText("An error occurred: " + e.getMessage());
        }
    }

    private boolean checkLogin(String username, String password) {
        try (Connection conn = DataBase.connect()) {
            String sql = "SELECT * FROM users WHERE TRIM(LOWER(name)) = TRIM(LOWER(?)) AND TRIM(password) = ? AND TRIM(LOWER(role)) = 'customer'";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void ensureServiceSelectionRows(String username) {
        String[] services = {
                "Tire Maintenance",
                "Fluids Maintenance",
                "Air Filter Cleaning",
                "Belt Maintenance",
                "Lighting And Signal Maintenance",
                "Wiper Blades And Windshield Maintenance",
                "Engine Oil Replacement",
                "Oil Filter Replacement",
                "Check Oil Quality",
                "Brake Pad Replacement",
                "Brake Disc Maintenance",
                "Brake Fluid Check",
                "Car Wash",
                "Interior Cleaning",
                "Polishing"
        };

        try (Connection conn = DataBase.connect()) {
            for (String service : services) {
                PreparedStatement checkStmt = conn.prepareStatement("SELECT * FROM service_selections WHERE username = ? AND service_name = ?");
                checkStmt.setString(1, username);
                checkStmt.setString(2, service);
                ResultSet rs = checkStmt.executeQuery();
                if (!rs.next()) {
                    PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO service_selections (username, service_name, selected) VALUES (?, ?, 0)");
                    insertStmt.setString(1, username);
                    insertStmt.setString(2, service);
                    insertStmt.executeUpdate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
