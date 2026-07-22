package com.secondhand.frontend.controller.components;

import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.session.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
public class HeaderController {

    @FXML
    private Button backButton;

    @FXML
    private void logout() {

        SessionManager.logout();

        NavigationManager.showLogin();

    }


    @FXML
    private void showCreateAdvertisement() {

        NavigationManager.showCreateAdvertisement();

    }

    @FXML
    private void showProfile() {

        NavigationManager.showProfile();

    }

    public void setBackVisible(boolean visible) {
        backButton.setVisible(visible);
        backButton.setManaged(visible);
    }

    @FXML
    private void goBack() {

        NavigationManager.showHome();

    }
}