module com.example.carmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.example.carmanagement to javafx.fxml;
    exports com.example.carmanagement;
}