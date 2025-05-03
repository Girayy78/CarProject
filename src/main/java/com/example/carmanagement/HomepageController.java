package com.example.carmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HomepageController {
    public void goToVehicleRegister(ActionEvent event) throws IOException {
        SceneController.switchTo("vehicleRegister.fxml", event, "Vehicle Register!", "/loginCSS.css");
    }
    public void goToEssentialMaintenance(ActionEvent event) throws IOException {
        SceneController.switchTo("essentialMaintenance.fxml", event, "Essential Maintenance!", "/loginCSS.css");
    }
    public void goToOilChange(ActionEvent event) throws IOException {
        SceneController.switchTo("oilChange.fxml", event, "Oil Change!", "/loginCSS.css");
    }
    public void goToBrakeServices(ActionEvent event) throws IOException {
        SceneController.switchTo("brakeServices.fxml", event, "Brake Services!", "/loginCSS.css");
    }
    public void goToOptionalServices(ActionEvent event) throws IOException {
        SceneController.switchTo("optionalServices.fxml", event, "Optional Services!", "/loginCSS.css");
    }
    public void goToServiceHistory(ActionEvent event) throws IOException {
        SceneController.switchTo("serviceHistory.fxml", event, "Service History!", "/loginCSS.css");
    }

}
