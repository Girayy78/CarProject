package com.example.carmanagement;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.event.Event;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.example.carmanagement.SceneController.switchTo;

public class AdminDashboardController {

    @FXML
    private TextArea customerListArea;

    @FXML
    private void logout(Event event) throws IOException {
        switchTo("roleSelect.fxml", event, "Select Login", "/loginCSS.css");
    }

    @FXML
    public void initialize() {
        try (Connection conn = DataBase.connect()) {
            String sql = """
                SELECT u.name, u.car_brand, u.car_model, u.plate, u.vehicle_type, s.service_name, s.selected_at
                FROM users u
                JOIN service_selections s ON u.name = s.username
                WHERE s.selected = 1 AND LOWER(u.role) != 'admin'
                ORDER BY u.name, s.selected_at DESC
            """;

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            StringBuilder sb = new StringBuilder("Registered Customers and Services\n");
            sb.append("--------------------------------------------------\n\n");

            String lastUser = "";
            int counter = 1;

            while (rs.next()) {
                String user = rs.getString("name");
                String brand = rs.getString("car_brand");
                String model = rs.getString("car_model");
                String plate = rs.getString("plate");
                String vehicleType = rs.getString("vehicle_type");
                String service = rs.getString("service_name");
                String time = rs.getString("selected_at");

                if (!user.equals(lastUser)) {
                    if (!lastUser.isEmpty()) sb.append("\n");
                    sb.append(counter++).append(". User: ").append(user).append("\n");
                    sb.append("   Car: ").append(brand).append(" ").append(model)
                            .append(" | Plate: ").append(plate).append("\n");
                    sb.append("   Services:\n");
                    lastUser = user;
                }

                sb.append("     • ").append(service)
                        .append(" (").append(time).append(")\n");
            }

            customerListArea.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            customerListArea.setText("Failed to load customer data.");
        }
    }
}




