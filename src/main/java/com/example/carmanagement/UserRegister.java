package com.example.carmanagement;

import javafx.event.ActionEvent;

import java.io.IOException;

public class UserRegister {
    public void goToHomePage(ActionEvent event) throws IOException {
        SceneController.switchTo("homePage.fxml", event, "HomePage", "/loginCSS.css");
    }
}
