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


    private Runnable onBackAction = NavigationManager::showHome;







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

        onBackAction.run();

    }

    public void setOnBack(Runnable onBackAction) {

        this.onBackAction = onBackAction != null
                ? onBackAction
                : NavigationManager::showHome;

    }


}