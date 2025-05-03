package com.example.carmanagement;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class RegisterController implements Initializable {
    public void goToHomePage(ActionEvent event) throws IOException {
        SceneController.switchTo("homePage.fxml", event, "HomePage", "/loginCSS.css");
    }
    @FXML
    private ComboBox<String> vehicleTypeComboBox;


    public void initialize(URL url, ResourceBundle resourceBundle) {
      vehicleTypeComboBox.setItems(FXCollections.observableArrayList("Car","Truck", "MotorCycle"));
    }
}
