package com.secondhand.frontend.controller.auth;

import com.secondhand.frontend.exception.ApiException;
import com.secondhand.frontend.model.Role;
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
import com.secondhand.frontend.dto.auth.request.LoginRequest;
import com.secondhand.frontend.dto.auth.response.LoginResponse;
import com.secondhand.frontend.service.AuthenticationService;

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

    private final AuthenticationService authenticationService =
            AuthenticationService.getInstance();

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

        try {

            LoginRequest request = new LoginRequest();

            request.setUsername(username);
            request.setPassword(password);

            LoginResponse response =
                    authenticationService.login(request);

            Role role = Role.valueOf(response.getRole());

            SessionManager.login(
                    response.getUserId(),
                    response.getUsername(),
                    role,
                    response.getToken()
            );

            NavigationManager.showHome();

        }

        catch (ApiException ex) {

            handleLoginError(ex);

        }

        catch (Exception ex) {

            showGeneralError(
                    "Unable to connect to server."
            );

        }

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


    private void handleLoginError(ApiException ex) {

        switch (ex.getErrorCode()) {

            case "INVALID_CREDENTIALS" ->

                    showPasswordError(
                            "Username or password is incorrect."
                    );

            case "USER_BLOCKED" ->

                    showGeneralError(
                            "Your account has been blocked."
                    );

            default ->

                    showGeneralError(
                            ex.getMessage()
                    );

        }




    }

    private void showGeneralError(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Login");

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();

    }

}