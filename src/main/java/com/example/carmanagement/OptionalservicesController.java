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


public class OptionalservicesController {
    @FXML
    private CheckBox interiorExteriorCleaningCheck;

    @FXML
    private CheckBox tireRotationCheck;

    @FXML
    private CheckBox acCleaningCheck;

    @FXML
    private CheckBox wheelAlignmentCheck;

    @FXML
    public void initialize() {

        if (interiorExteriorCleaningCheck != null) {
            interiorExteriorCleaningCheck.setSelected(
                    StateManager.getCheckboxState("EssentialMaintenanceController", "interiorExteriorCleaningCheck")
            );
        }

        if (tireRotationCheck != null) {
            tireRotationCheck.setSelected(
                    StateManager.getCheckboxState("EssentialMaintenanceController", "tireRotationCheck")
            );
        }

        if (acCleaningCheck != null) {
            acCleaningCheck.setSelected(
                    StateManager.getCheckboxState("EssentialMaintenanceController", "acCleaningCheck")
            );
        }

        if (wheelAlignmentCheck != null) {
            wheelAlignmentCheck.setSelected(
                    StateManager.getCheckboxState("EssentialMaintenanceController", "wheelAlignmentCheck")
            );
        }
    }

    public void goToHomePage(ActionEvent event) throws IOException {

        saveCheckboxStates();
        SceneController.switchTo("homePage.fxml", event, "HomePage", "/loginCSS.css");
    }

    private void saveCheckboxStates() {
        if (interiorExteriorCleaningCheck != null) {
            StateManager.saveCheckboxState(
                    "EssentialMaintenanceController",
                    "interiorExteriorCleaningCheck",
                    interiorExteriorCleaningCheck.isSelected()
            );
        }

        if (tireRotationCheck != null) {
            StateManager.saveCheckboxState(
                    "EssentialMaintenanceController",
                    "tireRotationCheck",
                    tireRotationCheck.isSelected()
            );
        }

        if (acCleaningCheck != null) {
            StateManager.saveCheckboxState(
                    "EssentialMaintenanceController",
                    "acCleaningCheck",
                    acCleaningCheck.isSelected()
            );
        }

        if (wheelAlignmentCheck != null) {
            StateManager.saveCheckboxState(
                    "EssentialMaintenanceController",
                    "wheelAlignmentCheck",
                    wheelAlignmentCheck.isSelected()
            );
        }
    }
}