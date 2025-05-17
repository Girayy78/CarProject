package com.example.carmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.event.Event;

import javafx.event.Event;
import java.io.IOException;
import java.sql.*;

import static com.example.carmanagement.SceneController.switchTo;

public class OptionalServicesController {

    @FXML private CheckBox carWashCheck, interiorCleaningCheck, polishingCheck;
    @FXML private Button saveButton;

    private boolean selectionsSaved = false;

    @FXML
    public void initialize() {
        try (Connection conn = DataBase.connect()) {
            loadCheckBox(conn, carWashCheck, "Car Wash");
            loadCheckBox(conn, interiorCleaningCheck, "Interior Cleaning");
            loadCheckBox(conn, polishingCheck, "Polishing");

            if (isLocked(conn)) {
                disableAll();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void loadCheckBox(Connection conn, CheckBox cb, String name) throws Exception {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT selected FROM service_selections WHERE username = ? AND service_name = ?"
        );
        stmt.setString(1, LoggedUser.getUsername());
        stmt.setString(2, name);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) cb.setSelected(rs.getInt("selected") == 1);
    }

    @FXML
    private void saveSelections(Event event) {
        if (selectionsSaved) return;

        try (Connection conn = DataBase.connect()) {
            update(conn, "Car Wash", carWashCheck.isSelected());
            update(conn, "Interior Cleaning", interiorCleaningCheck.isSelected());
            update(conn, "Polishing", polishingCheck.isSelected());
            disableAll();
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void update(Connection conn, String name, boolean selected) throws Exception {
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE service_selections SET selected = ?, locked = 1 WHERE username = ? AND service_name = ?"
        );
        stmt.setInt(1, selected ? 1 : 0);
        stmt.setString(2, LoggedUser.getUsername());
        stmt.setString(3, name);
        stmt.executeUpdate();
    }

    private boolean isLocked(Connection conn) throws Exception {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT locked FROM service_selections WHERE username = ? AND service_name = 'Car Wash'"
        );
        stmt.setString(1, LoggedUser.getUsername());
        ResultSet rs = stmt.executeQuery();
        return rs.next() && rs.getInt("locked") == 1;
    }

    private void disableAll() {
        carWashCheck.setDisable(true);
        interiorCleaningCheck.setDisable(true);
        polishingCheck.setDisable(true);
        saveButton.setDisable(true);
        selectionsSaved = true;
    }

    @FXML
    private void goBack(Event event) throws IOException {
        switchTo("serviceSelection.fxml", event, "Service Selection", "/loginCSS.css");
    }
}
