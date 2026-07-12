package com.secondhand.frontend.controller.auth;

import com.secondhand.frontend.session.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import com.secondhand.frontend.navigation.NavigationManager;
import javafx.scene.control.Hyperlink;
import com.secondhand.frontend.controller.components.FloatingTextFieldController;
import com.secondhand.frontend.controller.components.FloatingPasswordFieldController;

public class LoginController {

    @FXML
    private FloatingTextFieldController usernameComponentController;

    @FXML
    private FloatingPasswordFieldController passwordComponentController;

    @FXML
    private Button loginButton;

    @FXML
    private Label usernameErrorLabel;

    @FXML
    private Label passwordErrorLabel;

    @FXML
    private Hyperlink registerLink;

    @FXML
    public void initialize() {

        usernameComponentController.setLabel("Username");
        passwordComponentController.setLabel("Password");

        System.out.println("LoginController Initialized");

    }

    @FXML
    private void handleLogin() {

        hideErrors();

        String username = usernameComponentController.getText().trim();
        String password = passwordComponentController.getText();

        boolean hasError = false;

        if (username.isEmpty()) {

            showUsernameError("Username is required.");

            hasError = true;

        }

        if (password.isEmpty()) {

            showPasswordError("Password is required.");

            hasError = true;

        }

        if (hasError) {

            return;

        }

        System.out.println("Username: " + username);

        System.out.println("Password: " + password);

        SessionManager.login();

        NavigationManager.showHome();
    }



    private void hideErrors() {

        usernameErrorLabel.setVisible(false);
        usernameErrorLabel.setManaged(false);

        passwordErrorLabel.setVisible(false);
        passwordErrorLabel.setManaged(false);

    }

    private void showUsernameError(String message) {

        usernameErrorLabel.setText(message);

        usernameErrorLabel.setVisible(true);

        usernameErrorLabel.setManaged(true);

    }

    private void showPasswordError(String message) {

        passwordErrorLabel.setText(message);

        passwordErrorLabel.setVisible(true);

        passwordErrorLabel.setManaged(true);

    }

    @FXML
    private void onRegisterClicked() {

        NavigationManager.showRegister();

    }

}