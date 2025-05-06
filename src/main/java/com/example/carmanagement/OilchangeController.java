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


public class OilchangeController {
    @FXML
    private CheckBox filterCheck;

    @FXML
    private CheckBox engineFlushCheck;

    @FXML
    private CheckBox oilChangeCheck;

    @FXML
    public void initialize() {
        // Load saved states when the controller initializes
        if (filterCheck != null) {
            filterCheck.setSelected(
                    StateManager.getCheckboxState("OilchangeController", "filterCheck")
            );
        }

        if (engineFlushCheck != null) {
            engineFlushCheck.setSelected(
                    StateManager.getCheckboxState("OilchangeController", "engineFlushCheck")
            );
        }

        if (oilChangeCheck != null) {
            oilChangeCheck.setSelected(
                    StateManager.getCheckboxState("OilchangeController", "oilChangeCheck")
            );
        }
    }

    public void goToHomePage(ActionEvent event) throws IOException {
        // Save states before navigating away
        saveCheckboxStates();
        SceneController.switchTo("homePage.fxml", event, "HomePage", "/loginCSS.css");
    }

    private void saveCheckboxStates() {
        if (filterCheck != null) {
            StateManager.saveCheckboxState(
                    "OilchangeController",
                    "filterCheck",
                    filterCheck.isSelected()
            );
        }

        if (engineFlushCheck != null) {
            StateManager.saveCheckboxState(
                    "OilchangeController",
                    "engineFlushCheck",
                    engineFlushCheck.isSelected()
            );
        }

        if (oilChangeCheck != null) {
            StateManager.saveCheckboxState(
                    "OilchangeController",
                    "oilChangeCheck",
                    oilChangeCheck.isSelected()
            );
        }
    }
}
