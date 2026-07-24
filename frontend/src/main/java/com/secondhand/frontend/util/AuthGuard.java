package com.secondhand.frontend.util;

import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.session.SessionManager;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AuthGuard {

    private AuthGuard() {
    }

    public static boolean requireLogin() {

        if (SessionManager.isLoggedIn()) {

            return true;

        }

        Alert alert =
                new Alert(
                        Alert.AlertType.CONFIRMATION,
                        "برای انجام این کار باید وارد حساب کاربری خود شوید."
                );

        alert.setHeaderText(null);

        ButtonType loginButton =
                new ButtonType("ورود به حساب");

        ButtonType cancelButton =
                new ButtonType("انصراف", ButtonType.CANCEL.getButtonData());

        alert.getButtonTypes().setAll(
                loginButton,
                cancelButton
        );

        Optional<ButtonType> result =
                alert.showAndWait();

        if (result.isPresent() && result.get() == loginButton) {

            NavigationManager.showLogin();

        }

        return false;

    }

}