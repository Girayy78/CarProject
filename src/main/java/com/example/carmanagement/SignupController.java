package com.example.carmanagement;



import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {
    public void goToLogin(ActionEvent event) throws IOException {
        SceneController.switchTo("loginScene.fxml", event, "Login", "/loginCSS.css");
    }
}
