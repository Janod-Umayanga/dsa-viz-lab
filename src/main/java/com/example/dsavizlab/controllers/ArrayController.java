package com.example.dsavizlab.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Random;

public class ArrayController extends MainController{

    @FXML
    private TextField UserInputArrayLength;

    @FXML
    private HBox ArrayView;

    @FXML
    public void initialize() {
        // Add an event filter to allow only numeric inputs
        UserInputArrayLength.addEventFilter(javafx.scene.input.KeyEvent.KEY_TYPED, keyEvent -> {
            // Consume any non-numeric input
            if (!keyEvent.getCharacter().matches("\\d")) {
                keyEvent.consume();
            }
        });
    }

    @FXML
    protected void OnGenerateArrayClicked(ActionEvent event) throws IOException {
        String UserInput = UserInputArrayLength.getText();
        int ArrayLength = Integer.parseInt(UserInput);

        int[] Array = GenerateRandomIntegerArray(ArrayLength);

        VisualizeArray(Array);
    }

    private int[] GenerateRandomIntegerArray(int ArrayLength) {
        int[] Array = new int[ArrayLength];

        Random RNG = new Random(); // Random Number Generator

        for (int i = 0; i < ArrayLength; i++) {
            Array[i] = RNG.nextInt(100);
        }
        return Array;
    }

    private void VisualizeArray (int[] Array) {
        ArrayView.getChildren().clear();

        for (int Element : Array) {
            Label ElementContainer = new Label(String.valueOf(Element));
            ElementContainer.setStyle("-fx-border-color: black; -fx-padding: 5px;");
            ArrayView.getChildren().add(ElementContainer);
        }
    }
}
