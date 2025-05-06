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


public class BrakeservicesController {
    @FXML
    private CheckBox brakePadReplacementCheck;

    @FXML
    private CheckBox brakeRotorReplacementCheck;

    @FXML
    private CheckBox brakeFluidFlushCheck;

    @FXML
    public void initialize() {
        // Load saved states when the controller initializes
        if (brakePadReplacementCheck != null) {
            brakePadReplacementCheck.setSelected(
                    StateManager.getCheckboxState("BrakeservicesController", "brakePadReplacementCheck")
            );
        }

        if (brakeRotorReplacementCheck != null) {
            brakeRotorReplacementCheck.setSelected(
                    StateManager.getCheckboxState("BrakeservicesController", "brakeRotorReplacementCheck")
            );
        }

        if (brakeFluidFlushCheck != null) {
            brakeFluidFlushCheck.setSelected(
                    StateManager.getCheckboxState("BrakeservicesController", "brakeFluidFlushCheck")
            );
        }
    }

    public void goToHomePage(ActionEvent event) throws IOException {
        // Save states before navigating away
        saveCheckboxStates();
        SceneController.switchTo("homePage.fxml", event, "HomePage", "/loginCSS.css");
    }

    private void saveCheckboxStates() {
        if (brakePadReplacementCheck != null) {
            StateManager.saveCheckboxState(
                    "BrakeservicesController",
                    "brakePadReplacementCheck",
                    brakePadReplacementCheck.isSelected()
            );
        }

        if (brakeRotorReplacementCheck != null) {
            StateManager.saveCheckboxState(
                    "BrakeservicesController",
                    "brakeRotorReplacementCheck",
                    brakeRotorReplacementCheck.isSelected()
            );
        }

        if (brakeFluidFlushCheck != null) {
            StateManager.saveCheckboxState(
                    "BrakeservicesController",
                    "brakeFluidFlushCheck",
                    brakeFluidFlushCheck.isSelected()
            );
        }
    }
}
