package com.secondhand.frontend.controller.components;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FloatingTextFieldController {

    @FXML
    private TextField textField;

    @FXML
    private Label floatingLabel;

    @FXML
    public void initialize() {

        updateLabel();

        textField.textProperty().addListener((obs, oldValue, newValue) -> updateLabel());

        textField.focusedProperty().addListener((obs, oldValue, newValue) -> updateLabel());

    }

    private void updateLabel() {

        if (textField.isFocused() || !textField.getText().isEmpty()) {

            floatingLabel.getStyleClass().add("floating-label-top");

        } else {

            floatingLabel.getStyleClass().remove("floating-label-top");

        }

    }

    public void setLabel(String text) {

        floatingLabel.setText(text);

    }

    public String getText() {

        return textField.getText();

    }

    public void setText(String text) {

        textField.setText(text);

    }

    public TextField getTextField() {

        return textField;

    }

}