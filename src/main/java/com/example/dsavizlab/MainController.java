package com.example.dsavizlab;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MainController {

    @FXML
    protected void onGetStartedButtonClick(ActionEvent event) throws IOException {
        loadPageOnSameWindow(event, "data-structures-view.fxml");
    }

    protected void loadPageOnSameWindow(ActionEvent event, String xmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(xmlFileName));
        Parent newRoot = fxmlLoader.load();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }
}