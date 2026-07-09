package com.secondhand.frontend.controller.auth;

import com.secondhand.frontend.navigation.NavigationManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;




public class RegisterController {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^09\\d{9}$");


    @FXML
    private TextField fullNameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;



    @FXML
    private Label fullNameErrorLabel;

    @FXML
    private Label usernameErrorLabel;

    @FXML
    private Label emailErrorLabel;

    @FXML
    private Label phoneErrorLabel;

    @FXML
    private Label passwordErrorLabel;

    @FXML
    private Label confirmPasswordErrorLabel;



    private void clearErrors() {

        fullNameErrorLabel.setVisible(false);
        fullNameErrorLabel.setManaged(false);

        usernameErrorLabel.setVisible(false);
        usernameErrorLabel.setManaged(false);

        emailErrorLabel.setVisible(false);
        emailErrorLabel.setManaged(false);

        phoneErrorLabel.setVisible(false);
        phoneErrorLabel.setManaged(false);

        passwordErrorLabel.setVisible(false);
        passwordErrorLabel.setManaged(false);

        confirmPasswordErrorLabel.setVisible(false);
        confirmPasswordErrorLabel.setManaged(false);

    }



    private boolean validateInputs() {

        clearErrors();

        boolean valid = true;

        if (fullNameField.getText().isBlank()) {

            fullNameErrorLabel.setText("Full name is required.");
            fullNameErrorLabel.setVisible(true);
            fullNameErrorLabel.setManaged(true);

            valid = false;

        }

        if (usernameField.getText().isBlank()) {

            usernameErrorLabel.setText("Username is required.");
            usernameErrorLabel.setVisible(true);
            usernameErrorLabel.setManaged(true);

            valid = false;

        }

        if (emailField.getText().isBlank()) {

            emailErrorLabel.setText("Email is required.");
            emailErrorLabel.setVisible(true);
            emailErrorLabel.setManaged(true);

            valid = false;

        }
        else if (!EMAIL_PATTERN.matcher(emailField.getText()).matches()) {

            emailErrorLabel.setText("Invalid email.");
            emailErrorLabel.setVisible(true);
            emailErrorLabel.setManaged(true);

            valid = false;

        }

        if (phoneField.getText().isBlank()) {

            phoneErrorLabel.setText("Phone number is required.");
            phoneErrorLabel.setVisible(true);
            phoneErrorLabel.setManaged(true);

            valid = false;

        }
        else if (!PHONE_PATTERN.matcher(phoneField.getText()).matches()) {

            phoneErrorLabel.setText("Invalid phone number.");
            phoneErrorLabel.setVisible(true);
            phoneErrorLabel.setManaged(true);

            valid = false;

        }

        if (passwordField.getText().isBlank()) {

            passwordErrorLabel.setText("Password is required.");
            passwordErrorLabel.setVisible(true);
            passwordErrorLabel.setManaged(true);

            valid = false;

        }

        if (confirmPasswordField.getText().isBlank()) {

            confirmPasswordErrorLabel.setText("Confirm password is required.");
            confirmPasswordErrorLabel.setVisible(true);
            confirmPasswordErrorLabel.setManaged(true);

            valid = false;

        }
        else if (!passwordField.getText().equals(confirmPasswordField.getText())) {

            confirmPasswordErrorLabel.setText("Passwords do not match.");
            confirmPasswordErrorLabel.setVisible(true);
            confirmPasswordErrorLabel.setManaged(true);

            valid = false;

        }

        return valid;

    }



    @FXML
    private void onRegisterClicked() {

        if (!validateInputs()) {
            return;
        }

        System.out.println("Registration Successful");

    }



    @FXML
    private void onBackToLoginClicked() {

        NavigationManager.showLogin();

    }

}