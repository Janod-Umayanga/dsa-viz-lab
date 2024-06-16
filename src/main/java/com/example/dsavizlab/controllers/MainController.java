package com.example.dsavizlab.controllers;

import com.example.dsavizlab.MainApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MainController {

    @FXML
    protected void OnGetStartedButtonClicked(ActionEvent event) throws IOException {
        LoadPageOnSameWindow(event, "data-structures-view.fxml");
    }

    @FXML
    protected void OnBackButtonClicked(ActionEvent event) throws IOException {
        LoadPageOnSameWindow(event, "data-structures-view.fxml");
    }

    @FXML
    protected void OnArraysButtonClicked(ActionEvent event) throws IOException {
        LoadPageOnSameWindow(event, "arrays-view.fxml");
    }

    protected void LoadPageOnSameWindow(ActionEvent event, String xmlFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(xmlFileName));
        Parent newRoot = fxmlLoader.load();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.getScene().setRoot(newRoot);
    }
}