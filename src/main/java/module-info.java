module com.example.dsavizlab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dsavizlab to javafx.fxml;
    exports com.example.dsavizlab;
    exports com.example.dsavizlab.controllers;
    opens com.example.dsavizlab.controllers to javafx.fxml;
}