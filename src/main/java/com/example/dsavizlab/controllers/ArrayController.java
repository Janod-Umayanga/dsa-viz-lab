package com.example.dsavizlab.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    protected void OnGenerateArrayClicked() {
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

        int Index = 0;

        for (int Element : Array) {
            VBox ElementContainer = new VBox();

            Label ElementValue = new Label(String.valueOf(Element));
            Label ElementIndex = new Label(String.valueOf(Index));

            ElementValue.setStyle("-fx-border-color: black; -fx-padding: 5px;");

            ElementContainer.getChildren().add(ElementValue);
            ElementContainer.getChildren().add(ElementIndex);
            ElementContainer.setAlignment(Pos.valueOf("CENTER"));
            ElementContainer.setSpacing(5.0);

            ArrayView.getChildren().add(ElementContainer);

            Index++;
        }
    }
}
