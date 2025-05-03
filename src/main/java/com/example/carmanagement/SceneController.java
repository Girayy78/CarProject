package com.example.carmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;



import java.io.IOException;

public class SceneController {

    public static void switchTo(String fxmlFile, ActionEvent event, String title, String cssPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneController.class.getResource(fxmlFile));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);

        if (cssPath != null && !cssPath.isEmpty()) {
            String css = SceneController.class.getResource(cssPath).toExternalForm();
            scene.getStylesheets().add(css);
        }

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
    public static void switchTo(String fxmlFile, MouseEvent event, String title, String cssPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneController.class.getResource(fxmlFile));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 600, 400);

        if (cssPath != null && !cssPath.isEmpty()) {
            String css = SceneController.class.getResource(cssPath).toExternalForm();
            scene.getStylesheets().add(css);
        }

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}