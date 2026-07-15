package com.secondhand.frontend.controller.components;

import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.session.SessionManager;
import javafx.fxml.FXML;

public class HeaderController {

    @FXML
    private void logout() {

        SessionManager.logout();

        NavigationManager.showLogin();

    }


    @FXML
    private void showCreateAdvertisement() {

        NavigationManager.showCreateAdvertisement();

    }
}