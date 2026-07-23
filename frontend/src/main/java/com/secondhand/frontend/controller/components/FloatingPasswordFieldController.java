package com.secondhand.frontend.controller.components;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class FloatingPasswordFieldController {

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label floatingLabel;

    @FXML
    public void initialize() {

        updateLabel();

        passwordField.textProperty().addListener((obs, oldValue, newValue) -> updateLabel());

        passwordField.focusedProperty().addListener((obs, oldValue, newValue) -> updateLabel());

    }

    private void updateLabel() {

        if (passwordField.isFocused() || !passwordField.getText().isEmpty()) {

            floatingLabel.getStyleClass().add("floating-label-top");

        } else {

            floatingLabel.getStyleClass().remove("floating-label-top");

        }

    }

    public void setLabel(String text) {

        floatingLabel.setText(text);

    }

    public String getText() {

        return passwordField.getText();

    }

    public void setText(String text) {

        passwordField.setText(text);

    }

    public PasswordField getPasswordField() {

        return passwordField;

    }

}