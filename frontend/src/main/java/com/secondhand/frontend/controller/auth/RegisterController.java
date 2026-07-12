package com.secondhand.frontend.controller.auth;

import com.secondhand.frontend.controller.components.FloatingPasswordFieldController;
import com.secondhand.frontend.controller.components.FloatingTextFieldController;
import com.secondhand.frontend.navigation.NavigationManager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

import java.util.regex.Pattern;

public class RegisterController {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^09\\d{9}$");

    @FXML
    private FloatingTextFieldController fullNameComponentController;

    @FXML
    private FloatingTextFieldController usernameComponentController;

    @FXML
    private FloatingTextFieldController emailComponentController;

    @FXML
    private FloatingTextFieldController phoneComponentController;

    @FXML
    private FloatingPasswordFieldController passwordComponentController;

    @FXML
    private FloatingPasswordFieldController confirmPasswordComponentController;

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

    @FXML
    public void initialize() {

        fullNameComponentController.setLabel("Full Name");
        usernameComponentController.setLabel("Username");
        emailComponentController.setLabel("Email");
        phoneComponentController.setLabel("Phone Number");
        passwordComponentController.setLabel("Password");
        confirmPasswordComponentController.setLabel("Confirm Password");

    }

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

        String fullName = fullNameComponentController.getText().trim();
        String username = usernameComponentController.getText().trim();
        String email = emailComponentController.getText().trim();
        String phone = phoneComponentController.getText().trim();
        String password = passwordComponentController.getText();
        String confirmPassword = confirmPasswordComponentController.getText();

        if (fullName.isBlank()) {

            fullNameErrorLabel.setText("Full name is required.");
            fullNameErrorLabel.setVisible(true);
            fullNameErrorLabel.setManaged(true);

            valid = false;

        }

        if (username.isBlank()) {

            usernameErrorLabel.setText("Username is required.");
            usernameErrorLabel.setVisible(true);
            usernameErrorLabel.setManaged(true);

            valid = false;

        }

        if (email.isBlank()) {

            emailErrorLabel.setText("Email is required.");
            emailErrorLabel.setVisible(true);
            emailErrorLabel.setManaged(true);

            valid = false;

        } else if (!EMAIL_PATTERN.matcher(email).matches()) {

            emailErrorLabel.setText("Invalid email.");
            emailErrorLabel.setVisible(true);
            emailErrorLabel.setManaged(true);

            valid = false;

        }

        if (phone.isBlank()) {

            phoneErrorLabel.setText("Phone number is required.");
            phoneErrorLabel.setVisible(true);
            phoneErrorLabel.setManaged(true);

            valid = false;

        } else if (!PHONE_PATTERN.matcher(phone).matches()) {

            phoneErrorLabel.setText("Invalid phone number.");
            phoneErrorLabel.setVisible(true);
            phoneErrorLabel.setManaged(true);

            valid = false;

        }

        if (password.isBlank()) {

            passwordErrorLabel.setText("Password is required.");
            passwordErrorLabel.setVisible(true);
            passwordErrorLabel.setManaged(true);

            valid = false;

        }

        if (confirmPassword.isBlank()) {

            confirmPasswordErrorLabel.setText("Confirm password is required.");
            confirmPasswordErrorLabel.setVisible(true);
            confirmPasswordErrorLabel.setManaged(true);

            valid = false;

        } else if (!password.equals(confirmPassword)) {

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

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Registration");
        alert.setHeaderText(null);
        alert.setContentText("Account created successfully.");

        alert.showAndWait();

        NavigationManager.showLogin();

    }

    @FXML
    private void onBackToLoginClicked() {

        NavigationManager.showLogin();

    }

}