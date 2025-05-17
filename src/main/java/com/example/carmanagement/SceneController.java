package com.example.carmanagement;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.Event;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Objects;

public class SceneController {

    public static void switchTo(String fxmlFile, Event event, String title, String cssPath) throws IOException {
        Stage stage;
        if (event != null) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        } else {
            stage = (Stage) Window.getWindows().filtered(Window::isShowing).get(0);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource("/com/example/carmanagement/" + fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());
        if (cssPath != null && !cssPath.isEmpty()) {
            scene.getStylesheets().add(Objects.requireNonNull(SceneController.class.getResource(cssPath)).toExternalForm());
        }

        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
