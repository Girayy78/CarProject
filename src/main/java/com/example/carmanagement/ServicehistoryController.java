package com.example.carmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ServicehistoryController {
    public void goToHomePage(ActionEvent event) throws IOException {
        SceneController.switchTo("homePage.fxml", event, "HomePage", "/loginCSS.css");
    }
}
