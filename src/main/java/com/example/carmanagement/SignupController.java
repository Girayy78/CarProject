package com.example.carmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.carmanagement.SceneController.switchTo;

public class SignupController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private ComboBox<String> roleComboBox;
    @FXML private Label messageLabel;

    @FXML
    public void initialize() {
        roleComboBox.getItems().clear();
        roleComboBox.getItems().addAll("Customer", "Admin");
    }

    @FXML
    private void signUp(ActionEvent event) {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
        String role = roleComboBox.getValue();

        if (username.isEmpty() || password.isEmpty() || role == null) {
            messageLabel.setText("Please fill all fields.");
            return;
        }

        if (username.contains(" ")) {
            messageLabel.setText("Username cannot contain spaces.");
            return;
        }

        try (Connection conn = DataBase.connect()) {
            PreparedStatement check = conn.prepareStatement("SELECT * FROM users WHERE name = ?");
            check.setString(1, username);
            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                messageLabel.setText("Username already exists.");
                return;
            }

            PreparedStatement insert = conn.prepareStatement(
                    "INSERT INTO users(name, password, role) VALUES(?, ?, ?)"
            );
            insert.setString(1, username);
            insert.setString(2, password);
            insert.setString(3, role);
            insert.executeUpdate();

            showStyledSuccessAlert();
            switchTo("roleSelect.fxml", event, "Select Login", "/loginCSS.css");

        } catch (Exception e) {
            e.printStackTrace();
            messageLabel.setText("Database error.");
        }
    }

    @FXML
    private void goBack(Event event) throws IOException {
        switchTo("roleSelect.fxml", event, "Select Login", "/loginCSS.css");
    }

    private void showStyledSuccessAlert() {                   //Registration succesfull popup
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Registration Successful");
        alert.setHeaderText(null);
        alert.setContentText("Your account has been created successfully!");

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #d8d4cb, #f0ebe3); " +
                        "-fx-font-family: 'Segoe UI'; -fx-font-size: 14px; -fx-text-fill: #5a5449;"
        );

        dialogPane.lookupButton(ButtonType.OK).setStyle(
                "-fx-background-color: #a69f8e; -fx-text-fill: white; -fx-background-radius: 8;"
        );

        Label content = (Label) dialogPane.lookup(".content.label");
        if (content != null) {
            content.setStyle("-fx-text-fill: #5a5449;");
        }

        alert.showAndWait();
    }
}
