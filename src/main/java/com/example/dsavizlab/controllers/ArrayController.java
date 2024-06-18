package com.example.dsavizlab.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Random;

public class ArrayController extends MainController{

    private int[] Array;

    @FXML
    private TextField UserInputArrayLength;

    @FXML
    private HBox ArrayView;

    @FXML
    private HBox ArraySortingSection;

    @FXML
    private HBox SortedArrayView;

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

        Array = GenerateRandomIntegerArray(ArrayLength);

        VisualizeArray(Array, ArrayView);

        // Display sorting algorithm section if there is an array
        ArraySortingSection.setVisible(Array.length > 0);
    }

    @FXML
    protected void OnSelectionSortClicked() {
        int[] SortedArray = SelectionSortArray(Array);

        VisualizeArray(SortedArray, SortedArrayView);
    }

    private int[] GenerateRandomIntegerArray(int ArrayLength) {
        int[] Array = new int[ArrayLength];

        Random RNG = new Random(); // Random Number Generator

        for (int i = 0; i < ArrayLength; i++) {
            Array[i] = RNG.nextInt(100);
        }
        return Array;
    }

    private void VisualizeArray (int[] Array, HBox ArrayView) {
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

    // Array Sorting Algorithms
    private int[] SelectionSortArray (int[] Array) {
        int[] SortedArray;
        SortedArray = Array;

        int ArrayLength = Array.length;

        for (int i = 0; i < ArrayLength - 1; i++) { // Incrementing the index of unsorted part of the array
            // Finding the index of the minimum value of the unsorted part of the array
            int IndexOfMinValue = i;

            for (int j = i +1; j < ArrayLength; j++) {
                if (SortedArray[j] < SortedArray[IndexOfMinValue]) {
                    IndexOfMinValue = j;
                }
            }

            // Swap the minimum value of the unsorted part with the first position of the unsorted part
            int Temp = SortedArray[i];
            SortedArray[i] = SortedArray[IndexOfMinValue];
            SortedArray[IndexOfMinValue] = Temp;
        }

        return SortedArray;
    }

}
