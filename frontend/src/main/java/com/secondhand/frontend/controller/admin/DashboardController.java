package com.secondhand.frontend.controller.admin;

import com.secondhand.frontend.dto.admin.response.AdminDashboardResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdminRepository;
import com.secondhand.frontend.session.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML
    private Label totalUsersLabel;

    @FXML
    private Label blockedUsersLabel;

    @FXML
    private Label totalAdvertisementsLabel;

    @FXML
    private Label pendingAdvertisementsLabel;

    @FXML
    private Label activeAdvertisementsLabel;

    @FXML
    private Label soldAdvertisementsLabel;

    @FXML
    private Label totalCategoriesLabel;

    @FXML
    private Label totalCitiesLabel;

    @FXML
    private Label totalProvincesLabel;

    @FXML
    private Label totalRatingsLabel;

    @FXML
    private Label totalConversationsLabel;

    private final AdminRepository repository =
            new AdminRepository();

    @FXML
    public void initialize() {



        loadDashboard();

    }

    private void loadDashboard() {

        try {

            AdminDashboardResponse dashboard =
                    repository.getDashboard();

            totalUsersLabel.setText(
                    dashboard.getTotalUsers().toString()
            );

            blockedUsersLabel.setText(
                    dashboard.getBlockedUsers().toString()
            );

            totalAdvertisementsLabel.setText(
                    dashboard.getTotalAdvertisements().toString()
            );

            pendingAdvertisementsLabel.setText(
                    dashboard.getPendingAdvertisements().toString()
            );

            activeAdvertisementsLabel.setText(
                    dashboard.getActiveAdvertisements().toString()
            );

            soldAdvertisementsLabel.setText(
                    dashboard.getSoldAdvertisements().toString()
            );

            totalCategoriesLabel.setText(
                    dashboard.getTotalCategories().toString()
            );

            totalCitiesLabel.setText(
                    dashboard.getTotalCities().toString()
            );

            totalProvincesLabel.setText(
                    dashboard.getTotalProvinces().toString()
            );

            totalRatingsLabel.setText(
                    dashboard.getTotalRatings().toString()
            );

            totalConversationsLabel.setText(
                    dashboard.getTotalConversations().toString()
            );

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void showUsers() {

        NavigationManager.showUsers();

    }


    @FXML
    private void showCategories() {

        NavigationManager.showCategories();

    }

    @FXML
    private void logout() {

        SessionManager.logout();

        NavigationManager.showLogin();

    }



    @FXML
    private void showPendingAdvertisements() {

        NavigationManager.showAdvertisements();

    }





}