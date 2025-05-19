package com.example.carmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.Event;
import javafx.event.Event; // ✅ Doğru MouseEvent import'u

import java.io.IOException;

import static com.example.carmanagement.SceneController.switchTo;

public class RoleSelectController {

    @FXML
    private Label signUpLabel;

    @FXML
    private void goAdminLogin(Event event) throws IOException {
        switchTo("adminLogin.fxml", event, "Admin Login", "/loginCSS.css");
    }

    @FXML
    private void goCustomerLogin(Event event) throws IOException {
        switchTo("customerLogin.fxml", event, "Customer Login", "/loginCSS.css");
    }

    @FXML
    private void goToSignUpPage(Event event) throws IOException {
        switchTo("signup.fxml", event, "Sign Up", "/loginCSS.css");
    }

    @FXML
    private void underLineSignUpLabel(Event event) {
        signUpLabel.setUnderline(true);
    }              //Makes it easier for customers to understand that Sign Up is clickable

    @FXML
    private void removeUnderLineSignUpLabel(Event event) {
        signUpLabel.setUnderline(false);
    }
}
