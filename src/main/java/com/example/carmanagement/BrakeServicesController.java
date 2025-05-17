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

public class BrakeServicesController {

    @FXML private CheckBox brakePadCheck, brakeDiscCheck, brakeFluidCheck;
    @FXML private Button saveButton;

    private boolean selectionsSaved = false;

    @FXML
    public void initialize() {
        try (Connection conn = DataBase.connect()) {
            loadCheckBox(conn, brakePadCheck, "Brake Pad Replacement");
            loadCheckBox(conn, brakeDiscCheck, "Brake Disc Maintenance");
            loadCheckBox(conn, brakeFluidCheck, "Brake Fluid Check");

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
            update(conn, "Brake Pad Replacement", brakePadCheck.isSelected());
            update(conn, "Brake Disc Maintenance", brakeDiscCheck.isSelected());
            update(conn, "Brake Fluid Check", brakeFluidCheck.isSelected());
            disableAll();
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void update(Connection conn, String name, boolean selected) throws Exception {
        PreparedStatement stmt = conn.prepareStatement(
                "UPDATE service_selections SET selected = ?, locked = 1, selected_at = ? WHERE username = ? AND service_name = ?"
        );
        stmt.setInt(1, selected ? 1 : 0);
        stmt.setString(2, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        stmt.setString(3, LoggedUser.getUsername());
        stmt.setString(4, name);
        stmt.executeUpdate();
    }

    private boolean isLocked(Connection conn) throws Exception {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT locked FROM service_selections WHERE username = ? AND service_name = 'Brake Pad Replacement'"
        );
        stmt.setString(1, LoggedUser.getUsername());
        ResultSet rs = stmt.executeQuery();
        return rs.next() && rs.getInt("locked") == 1;
    }

    private void disableAll() {
        brakePadCheck.setDisable(true);
        brakeDiscCheck.setDisable(true);
        brakeFluidCheck.setDisable(true);
        saveButton.setDisable(true);
        selectionsSaved = true;
    }

    @FXML
    private void goBack(Event event) throws IOException {
        switchTo("serviceSelection.fxml", event, "Service Selection", "/loginCSS.css");
    }
}
