package com.example.carmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.event.Event;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.example.carmanagement.SceneController.switchTo;

public class EssentialMaintenanceController {

    @FXML private CheckBox tireCheck;
    @FXML private CheckBox fluidsCheck;
    @FXML private CheckBox airFilterCheck;
    @FXML private CheckBox beltCheck;
    @FXML private CheckBox lightSignalCheck;
    @FXML private CheckBox wiperCheck;
    @FXML private Button saveButton;

    private boolean selectionsSaved = false;

    @FXML
    public void initialize() {
        try (Connection conn = DataBase.connect()) {
            loadCheckBoxState(conn, tireCheck, "Tire Maintenance");
            loadCheckBoxState(conn, fluidsCheck, "Fluids Maintenance");
            loadCheckBoxState(conn, airFilterCheck, "Air Filter Cleaning");
            loadCheckBoxState(conn, beltCheck, "Belt Maintenance");
            loadCheckBoxState(conn, lightSignalCheck, "Lighting And Signal Maintenance");
            loadCheckBoxState(conn, wiperCheck, "Wiper Blades And Windshield Maintenance");

            if (areSelectionsFinal(conn)) {
                disableAllCheckboxes();
                saveButton.setDisable(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCheckBoxState(Connection conn, CheckBox cb, String name) throws Exception {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT selected, locked FROM service_selections WHERE username = ? AND service_name = ?"
        );
        stmt.setString(1, LoggedUser.getUsername());
        stmt.setString(2, name);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            cb.setSelected(rs.getInt("selected") == 1);
            if (rs.getInt("locked") == 1) {
                cb.setDisable(true);
                selectionsSaved = true;
            }
        }
    }

    @FXML
    private void saveSelections(Event event) {
        if (selectionsSaved) return;

        try (Connection conn = DataBase.connect()) {
            updateService(conn, "Tire Maintenance", tireCheck.isSelected());
            updateService(conn, "Fluids Maintenance", fluidsCheck.isSelected());
            updateService(conn, "Air Filter Cleaning", airFilterCheck.isSelected());
            updateService(conn, "Belt Maintenance", beltCheck.isSelected());
            updateService(conn, "Lighting And Signal Maintenance", lightSignalCheck.isSelected());
            updateService(conn, "Wiper Blades And Windshield Maintenance", wiperCheck.isSelected());

            disableAllCheckboxes();
            saveButton.setDisable(true);
            selectionsSaved = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateService(Connection conn, String name, boolean selected) throws Exception {
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE service_selections SET selected = ?, locked = 1, selected_at = ? WHERE username = ? AND service_name = ?"
        );
        stmt.setInt(1, selected ? 1 : 0);
        stmt.setString(2, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        stmt.setString(3, LoggedUser.getUsername());
        stmt.setString(4, name);
        stmt.executeUpdate();
    }

    private boolean areSelectionsFinal(Connection conn) throws Exception {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT locked FROM service_selections WHERE username = ? AND service_name = 'Tire Maintenance'"
        );
        stmt.setString(1, LoggedUser.getUsername());
        ResultSet rs = stmt.executeQuery();
        return rs.next() && rs.getInt("locked") == 1;
    }

    private void disableAllCheckboxes() {
        tireCheck.setDisable(true);
        fluidsCheck.setDisable(true);
        airFilterCheck.setDisable(true);
        beltCheck.setDisable(true);
        lightSignalCheck.setDisable(true);
        wiperCheck.setDisable(true);
    }

    @FXML
    private void goBack(Event event) throws IOException {
        switchTo("serviceSelection.fxml", event, "Service Selection", "/loginCSS.css");
    }
}
