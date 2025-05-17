package com.example.carmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.event.Event;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServiceHistoryController {

    @FXML private TextArea historyArea;

    @FXML
    private void goBack(Event event) throws IOException {
        SceneController.switchTo("serviceSelection.fxml", event, "Service Selection", "/loginCSS.css");
    }

    @FXML
    public void initialize() {
        try (Connection conn = DataBase.connect()) {
            String sql = "SELECT service_name, selected_at FROM service_selections WHERE username = ? AND selected = 1 ORDER BY selected_at DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, LoggedUser.getUsername());
            ResultSet rs = stmt.executeQuery();

            StringBuilder sb = new StringBuilder("Your Selected Services:\n\n");
            while (rs.next()) {
                sb.append("- ").append(rs.getString("service_name"))
                        .append(" (at ").append(rs.getString("selected_at")).append(")\n");
            }

            historyArea.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            historyArea.setText("An error occurred while loading your service history.");
        }
    }
}
