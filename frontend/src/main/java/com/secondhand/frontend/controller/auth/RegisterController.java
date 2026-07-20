package com.secondhand.frontend.controller.auth;

import com.secondhand.frontend.controller.components.FloatingPasswordFieldController;
import com.secondhand.frontend.controller.components.FloatingTextFieldController;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.util.ValidationUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import com.secondhand.frontend.dto.auth.request.RegisterRequest;
import com.secondhand.frontend.exception.ApiException;
import com.secondhand.frontend.service.AuthenticationService;


public class RegisterController {

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

    private final AuthenticationService authenticationService =
            AuthenticationService.getInstance();

    @FXML
    public void initialize() {

        fullNameComponentController.setLabel("Full Name");
        usernameComponentController.setLabel("Username");
        emailComponentController.setLabel("Email");
        phoneComponentController.setLabel("Phone Number");
        passwordComponentController.setLabel("Password");
        confirmPasswordComponentController.setLabel("Confirm Password");

        clearErrors();

    }

    private void showError(Label label, String message) {

        label.setText(message);
        label.setVisible(true);
        label.setManaged(true);

    }

    private void hideError(Label label) {

        label.setVisible(false);
        label.setManaged(false);

    }

    private void clearErrors() {

        hideError(fullNameErrorLabel);
        hideError(usernameErrorLabel);
        hideError(emailErrorLabel);
        hideError(phoneErrorLabel);
        hideError(passwordErrorLabel);
        hideError(confirmPasswordErrorLabel);

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

        // ---------- Full Name ----------

        if (fullName.isBlank()) {

            showError(fullNameErrorLabel,
                    "Full name is required.");

            valid = false;

        }

        // ---------- Username ----------

        if (username.isBlank()) {

            showError(usernameErrorLabel,
                    "Username is required.");

            valid = false;

        }
        else if (username.length() < 3 || username.length() > 30) {

            showError(usernameErrorLabel,
                    "Username must be between 3 and 30 characters.");

            valid = false;

        }
        else if (!ValidationUtil.isValidUsername(username)) {

            showError(usernameErrorLabel,
                    "Username can only contain letters, numbers, dots and underscores.");

            valid = false;

        }

        // ---------- Email ----------

        if (email.isBlank()) {

            showError(emailErrorLabel,
                    "Email is required.");

            valid = false;

        }
        else if (!ValidationUtil.isValidEmail(email)) {

            showError(emailErrorLabel,
                    "Please enter a valid email address.");

            valid = false;

        }

        // ---------- Phone ----------

        if (phone.isBlank()) {

            showError(phoneErrorLabel,
                    "Phone number is required.");

            valid = false;

        }
        else if (!ValidationUtil.isValidPhone(phone)) {

            showError(phoneErrorLabel,
                    "Phone number must start with 09 and contain 11 digits.");

            valid = false;

        }

        // ---------- Password ----------

        if (password.isBlank()) {

            showError(passwordErrorLabel,
                    "Password is required.");

            valid = false;

        }
        else if (!ValidationUtil.hasValidPasswordLength(password)) {

            showError(passwordErrorLabel,
                    "Password must be between 8 and 64 characters.");

            valid = false;

        }
        else if (!ValidationUtil.hasUppercase(password)) {

            showError(passwordErrorLabel,
                    "Password must contain at least one uppercase letter.");

            valid = false;

        }
        else if (!ValidationUtil.hasLowercase(password)) {

            showError(passwordErrorLabel,
                    "Password must contain at least one lowercase letter.");

            valid = false;

        }
        else if (!ValidationUtil.hasDigit(password)) {

            showError(passwordErrorLabel,
                    "Password must contain at least one number.");

            valid = false;

        }
        else if (!ValidationUtil.hasSpecialCharacter(password)) {

            showError(passwordErrorLabel,
                    "Password must contain at least one special character (@#$%^&+=!).");

            valid = false;

        }

        // ---------- Confirm Password ----------

        if (confirmPassword.isBlank()) {

            showError(confirmPasswordErrorLabel,
                    "Please confirm your password.");

            valid = false;

        }
        else if (!password.equals(confirmPassword)) {

            showError(confirmPasswordErrorLabel,
                    "Passwords do not match.");

            valid = false;

        }

        return valid;

    }

    @FXML
    private void onRegisterClicked() {

        if (!validateInputs()) {
            return;
        }

        try {

            RegisterRequest request =
                    new RegisterRequest();

            request.setFullName(
                    fullNameComponentController.getText().trim()
            );

            request.setUsername(
                    usernameComponentController.getText().trim()
            );

            request.setEmail(
                    emailComponentController.getText().trim()
            );

            request.setPhoneNumber(
                    phoneComponentController.getText().trim()
            );

            request.setPassword(
                    passwordComponentController.getText()
            );

            request.setConfirmPassword(
                    confirmPasswordComponentController.getText()
            );

            authenticationService.register(request);

            Alert alert =
                    new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Registration");

            alert.setHeaderText(null);

            alert.setContentText(
                    "Your account has been created successfully."
            );

            alert.showAndWait();

            NavigationManager.showLogin();

        }

        catch (ApiException ex) {

            handleRegisterError(ex);

        }

        catch (Exception ex) {

            Alert alert =
                    new Alert(Alert.AlertType.ERROR);

            alert.setHeaderText(null);

            alert.setTitle("Connection Error");

            alert.setContentText(
                    "Unable to connect to server."
            );

            alert.showAndWait();

        }

    }

    private void handleRegisterError(ApiException ex) {

        switch (ex.getErrorCode()) {

            case "USERNAME_ALREADY_EXISTS" ->

                    showError(
                            usernameErrorLabel,
                            "This username is already taken."
                    );

            case "EMAIL_ALREADY_EXISTS" ->

                    showError(
                            emailErrorLabel,
                            "This email is already registered."
                    );

            case "PHONE_NUMBER_ALREADY_EXISTS" ->

                    showError(
                            phoneErrorLabel,
                            "This phone number is already registered."
                    );

            default -> {

                Alert alert =
                        new Alert(Alert.AlertType.ERROR);

                alert.setTitle("Registration Failed");

                alert.setHeaderText(null);

                alert.setContentText(ex.getMessage());

                alert.showAndWait();

            }

        }

    }

    @FXML
    private void onBackToLoginClicked() {

        NavigationManager.showLogin();

    }

}