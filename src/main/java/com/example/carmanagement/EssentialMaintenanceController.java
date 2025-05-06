package com.example.carmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;


public class EssentialMaintenanceController {
    @FXML
    private CheckBox tireMaintenanceCheck;

    @FXML
    private CheckBox fluidsMaintenanceCheck;

    @FXML
    private CheckBox airFilterCleaningCheck;

    @FXML
    private CheckBox beltMaintenanceCheck;

    @FXML
    private CheckBox lightningAndSignalMaintenanceCheck;

    @FXML
    private CheckBox wiperBladeAndWindshieldMaintenanceCheck;

    @FXML
    public void initialize() {
        // Load saved states when the controller initializes
        if (tireMaintenanceCheck != null) {
            tireMaintenanceCheck.setSelected(
                    StateManager.getCheckboxState("OptionalservicesController", "tireMaintenanceCheck")
            );
        }

        if (fluidsMaintenanceCheck != null) {
            fluidsMaintenanceCheck.setSelected(
                    StateManager.getCheckboxState("OptionalservicesController", "fluidsMaintenanceCheck")
            );
        }

        if (airFilterCleaningCheck != null) {
            airFilterCleaningCheck.setSelected(
                    StateManager.getCheckboxState("OptionalservicesController", "airFilterCleaningCheck")
            );
        }

        if (beltMaintenanceCheck != null) {
            beltMaintenanceCheck.setSelected(
                    StateManager.getCheckboxState("OptionalservicesController", "beltMaintenanceCheck")
            );
        }

        if (lightningAndSignalMaintenanceCheck != null) {
            lightningAndSignalMaintenanceCheck.setSelected(
                    StateManager.getCheckboxState("OptionalservicesController", "lightningAndSignalMaintenanceCheck")
            );
        }

        if (wiperBladeAndWindshieldMaintenanceCheck != null) {
            wiperBladeAndWindshieldMaintenanceCheck.setSelected(
                    StateManager.getCheckboxState("OptionalservicesController", "wiperBladeAndWindshieldMaintenanceCheck")
            );
        }
    }

    public void goToHomePage(ActionEvent event) throws IOException {
        // Save states before navigating away
        saveCheckboxStates();
        SceneController.switchTo("homePage.fxml", event, "HomePage", "/loginCSS.css");
    }

    private void saveCheckboxStates() {
        if (tireMaintenanceCheck != null) {
            StateManager.saveCheckboxState(
                    "OptionalservicesController",
                    "tireMaintenanceCheck",
                    tireMaintenanceCheck.isSelected()
            );
        }

        if (fluidsMaintenanceCheck != null) {
            StateManager.saveCheckboxState(
                    "OptionalservicesController",
                    "fluidsMaintenanceCheck",
                    fluidsMaintenanceCheck.isSelected()
            );
        }

        if (airFilterCleaningCheck != null) {
            StateManager.saveCheckboxState(
                    "OptionalservicesController",
                    "airFilterCleaningCheck",
                    airFilterCleaningCheck.isSelected()
            );
        }

        if (beltMaintenanceCheck != null) {
            StateManager.saveCheckboxState(
                    "OptionalservicesController",
                    "beltMaintenanceCheck",
                    beltMaintenanceCheck.isSelected()
            );
        }

        if (lightningAndSignalMaintenanceCheck != null) {
            StateManager.saveCheckboxState(
                    "OptionalservicesController",
                    "lightningAndSignalMaintenanceCheck",
                    lightningAndSignalMaintenanceCheck.isSelected()
            );
        }

        if (wiperBladeAndWindshieldMaintenanceCheck != null) {
            StateManager.saveCheckboxState(
                    "OptionalservicesController",
                    "wiperBladeAndWindshieldMaintenanceCheck",
                    wiperBladeAndWindshieldMaintenanceCheck.isSelected()
            );
        }
    }
}