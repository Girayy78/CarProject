package com.example.carmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


import java.io.IOException;

import static com.example.carmanagement.SceneController.*;

public class LoginController {
    @FXML
    Label signUpLabel;

    public void goToHomePage(ActionEvent event) throws IOException {
        SceneController.switchTo("homePage.fxml", event, "HomePage", "/loginCSS.css");
    }

    public void goToSignUpPage(MouseEvent event) throws IOException {
       SceneController.switchTo("signUp.fxml", event, "Sign Up!", "/loginCSS.css");
    }

    public void underLineSignUpLabel(){
        signUpLabel.setOnMouseEntered(e -> signUpLabel.setStyle("-fx-underline: true;"));
        signUpLabel.setOnMouseExited(e -> signUpLabel.setStyle("-fx-underline: false;"));
    }


}



