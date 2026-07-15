package com.secondhand.frontend.controller.components;

import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class FloatingTextAreaController {

    @FXML
    private TextArea textArea;

    @FXML
    private Label floatingLabel;

    @FXML
    public void initialize() {

        updateLabel();

        textArea.textProperty().addListener((obs, oldValue, newValue) -> updateLabel());

        textArea.focusedProperty().addListener((obs, oldValue, newValue) -> updateLabel());

    }

    private void updateLabel() {

        if (textArea.isFocused() || !textArea.getText().isEmpty()) {

            if (!floatingLabel.getStyleClass().contains("floating-label-top")) {

                if (!floatingLabel.getStyleClass().contains("floating-textarea-label-top")) {
                    floatingLabel.getStyleClass().add("floating-textarea-label-top");
                }

            }

        } else {

            floatingLabel.getStyleClass().remove("floating-textarea-label-top");

        }

    }

    public void setLabel(String text) {

        floatingLabel.setText(text);

    }

    public String getText() {

        return textArea.getText();

    }

    public void setText(String text) {

        textArea.setText(text);

    }

    public TextArea getTextArea() {

        return textArea;

    }

    public void setRTL(boolean rtl){

        textArea.setNodeOrientation(
                rtl ? NodeOrientation.RIGHT_TO_LEFT
                        : NodeOrientation.LEFT_TO_RIGHT
        );

    }

    public void setError(boolean error) {

        if (error) {

            textArea.setStyle("""
                -fx-border-color:#e53935;
                -fx-border-width:2;
                -fx-border-radius:8;
                """);

        } else {

            textArea.setStyle("");

        }

    }

}