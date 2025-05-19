package com.example.carmanagement;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.Event;
import java.io.IOException;

public class HomepageController {

    public void goToVehicleRegister(Event event) throws IOException {
        SceneController.switchTo("vehicleRegister.fxml", event, "Vehicle Register!", "/loginCSS.css");
    }

    public void goToEssentialMaintenance(Event event) throws IOException {
        SceneController.switchTo("essentialMaintenance.fxml", event, "Essential Maintenance!", "/loginCSS.css");              //All these methods are assigned to buttons and does what it should when pressed
    }

    public void goToOilChange(Event event) throws IOException {
        SceneController.switchTo("oilChange.fxml", event, "Oil Change!", "/loginCSS.css");
    }

    public void goToBrakeServices(Event event) throws IOException {
        SceneController.switchTo("brakeServices.fxml", event, "Brake Services!", "/loginCSS.css");
    }

    public void goToOptionalServices(Event event) throws IOException {
        SceneController.switchTo("optionalServices.fxml", event, "Optional Services!", "/loginCSS.css");
    }

    public void goToServiceHistory(Event event) throws IOException {
        SceneController.switchTo("serviceHistory.fxml", event, "Service History!", "/loginCSS.css");
    }

    public void goToUserRegister(Event event) throws IOException {
        SceneController.switchTo("userRegister.fxml", event, "User Register!", "/loginCSS.css");
    }
}
