package com.secondhand.frontend.controller.components;

import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.util.Locale;

public class FloatingPriceFieldController {

    @FXML
    private TextField textField;

    @FXML
    private Label floatingLabel;

    @FXML
    private Label currencyLabel;

    private boolean formatting = false;

    @FXML
    public void initialize() {


        textField.setNodeOrientation(javafx.geometry.NodeOrientation.LEFT_TO_RIGHT);
        textField.setStyle("-fx-alignment: CENTER_LEFT;");

        updateLabel();

        textField.textProperty().addListener((obs, oldValue, newValue) -> {

            if (formatting)
                return;

            formatNumber();

            updateLabel();

        });

        textField.focusedProperty().addListener((obs, oldValue, newValue) -> updateLabel());

    }

    private void updateLabel() {

        if (textField.isFocused() || !textField.getText().isEmpty()) {

            floatingLabel.getStyleClass().add("floating-label-down");

        }

        else {

            floatingLabel.getStyleClass().remove("floating-label-down");

        }

    }

    private void formatNumber() {

        formatting = true;

        String digits = textField.getText().replaceAll("[^0-9]", "");

        if (digits.isEmpty()) {

            textField.clear();

            formatting = false;

            return;

        }

        long value = Long.parseLong(digits);

        NumberFormat formatter = NumberFormat.getInstance(Locale.US);

        textField.setText(formatter.format(value));

        textField.positionCaret(textField.getText().length());

        formatting = false;

    }

    public void setLabel(String text) {

        floatingLabel.setText(text);


    }

    public long getValue() {

        String digits = textField.getText().replaceAll("[^0-9]", "");

        if (digits.isEmpty())
            return 0;

        return Long.parseLong(digits);

    }

    public void setValue(long value) {

        NumberFormat formatter = NumberFormat.getInstance(Locale.US);

        textField.setText(formatter.format(value));

    }

    public TextField getTextField() {

        return textField;

    }

    public void setError(boolean error) {

        if (error) {

            textField.setStyle("""
                -fx-border-color:#e53935;
                -fx-border-width:2;
                -fx-border-radius:8;
                -fx-alignment:CENTER_LEFT;
                """);

        } else {

            textField.setStyle("-fx-alignment:CENTER_LEFT;");

        }

    }

}