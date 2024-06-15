module com.example.dsavizlab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dsavizlab to javafx.fxml;
    exports com.example.dsavizlab;
}