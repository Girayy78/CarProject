package com.example.carmanagement;


import javafx.fxml.FXML;

import javafx.event.Event;
import java.io.IOException;

import static com.example.carmanagement.SceneController.switchTo;

public class CustomerDashboardController {

    @FXML
    private void goToServiceSelection(Event event) throws IOException {
        switchTo("serviceSelection.fxml", event, "Service Selection", "/loginCSS.css");
    }

    @FXML
    private void logout(Event event) throws IOException {
        switchTo("roleSelect.fxml", event, "Select Login", "/loginCSS.css");
    }
}
