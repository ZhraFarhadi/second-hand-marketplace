package com.secondhand.frontend.controller.components;

import com.secondhand.frontend.model.Role;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.session.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import com.secondhand.frontend.util.AuthGuard;


public class HeaderController {

    @FXML

    private Button backButton;

    @FXML
    private MenuButton adminMenu;


    @FXML
    public void initialize() {

        if (SessionManager.getRole() == Role.ADMIN) {

            adminMenu.setVisible(true);
            adminMenu.setManaged(true);

        } else {

            adminMenu.setVisible(false);
            adminMenu.setManaged(false);

        }

    }




    @FXML
    private void showCreateAdvertisement() {

        if (!AuthGuard.requireLogin())
            return;

        NavigationManager.showCreateAdvertisement();

    }

    @FXML
    private void showProfile() {

        if (!AuthGuard.requireLogin())
            return;

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

    @FXML
    private void showAdminDashboard() {

        NavigationManager.showAdminDashboard();

    }
}