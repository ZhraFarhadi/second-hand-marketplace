package com.secondhand.frontend.controller.home;


import com.secondhand.frontend.controller.components.HeaderController;
import com.secondhand.frontend.dto.admin.response.AdminDashboardResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdvertisementRepository;
import com.secondhand.frontend.session.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Parent;
import com.secondhand.frontend.model.Category;
import com.secondhand.frontend.controller.advertisement.AdvertisementCardController;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.frontend.repository.CategoryRepository;
import com.secondhand.frontend.dto.category.response.CategoryDetailsResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;
import com.secondhand.frontend.util.AuthGuard;
import com.secondhand.frontend.model.Role;
import com.secondhand.frontend.repository.AdminRepository;
import javafx.scene.control.Label;

public class HomeController {

    @FXML
    private VBox categoryContainer;

    @FXML
    private FlowPane advertisementContainer;


    @FXML
    private Button favoritesButton;

    @FXML
    private Button chatButton;

    @FXML
    private Button myAdvertisementsButton;

    @FXML
    private VBox quickAccessSection;

    @FXML
    private Label statsTotalUsersLabel;

    @FXML
    private Label statsBlockedUsersLabel;

    @FXML
    private Label statsTotalAdsLabel;

    @FXML
    private Label statsPendingAdsLabel;

    @FXML
    private Label statsActiveAdsLabel;

    @FXML
    private Label statsSoldAdsLabel;

    @FXML
    private Label statsTotalCategoriesLabel;

    @FXML
    private Label statsTotalCitiesLabel;

    @FXML
    private Label statsTotalProvincesLabel;

    @FXML
    private Label statsTotalConversationsLabel;

    private final AdvertisementRepository advertisementRepository =
            AdvertisementRepository.getInstance();


    private final CategoryRepository categoryRepository =
            CategoryRepository.getInstance();


    @FXML
    private HeaderController headerController;

    private Long selectedCategoryId = null;

    private Button selectedSubcategoryButton = null;

    @FXML
    private VBox adminSection;

    @FXML
    private Button reviewAdvertisementsButton;

    @FXML
    private Button allAdvertisementsButton;

    @FXML
    private Button usersButton;

    @FXML
    private Button categoriesButton;

    private final AdminRepository adminRepository =
            new AdminRepository();

    @FXML
    public void initialize() {

        categoryContainer.getChildren().clear();

        try {

            var categories =
                    categoryRepository.getRootCategories();

            for (CategorySummaryResponse category : categories) {

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/view/home/components/category-item.fxml"
                                )
                        );

                VBox item = loader.load();

                CategoryItemController controller =
                        loader.getController();

                controller.setCategory(category, this::onSubcategorySelected);

                categoryContainer.getChildren().add(item);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        chatButton.setOnAction(event -> {

            if (!AuthGuard.requireLogin())
                return;

            NavigationManager.showConversationList();

        });

        myAdvertisementsButton.setOnAction(event -> {

            if (!AuthGuard.requireLogin())
                return;

            NavigationManager.showMyAdvertisements();

        });

        favoritesButton.setOnAction(event -> {

            NavigationManager.showFavorites();

        });

        setupAdminSection();

        loadAdvertisements();

    }

    private void onSubcategorySelected(Long categoryId, Button button) {

        if (selectedSubcategoryButton != null) {
            selectedSubcategoryButton.getStyleClass()
                    .remove("subcategory-button-selected");
        }

        boolean isSameCategoryClickedAgain =
                categoryId.equals(selectedCategoryId);

        if (isSameCategoryClickedAgain) {

            selectedCategoryId = null;
            selectedSubcategoryButton = null;

            loadAdvertisements();

        } else {

            selectedCategoryId = categoryId;
            selectedSubcategoryButton = button;

            button.getStyleClass().add("subcategory-button-selected");

            loadAdvertisements();

        }

    }

    private void loadAdvertisements() {

        advertisementContainer.getChildren().clear();

        try {

            var advertisements =
                    (selectedCategoryId == null)
                            ? advertisementRepository.getAdvertisements(0, 20)
                            : advertisementRepository.getAdvertisementsByCategory(
                            selectedCategoryId, 0, 20
                    );

            for (AdvertisementSummaryResponse advertisement : advertisements) {

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/view/advertisement/advertisement-card.fxml"
                                )
                        );

                Parent card = loader.load();

                AdvertisementCardController controller =
                        loader.getController();

                controller.setAdvertisement(advertisement);

                advertisementContainer.getChildren().add(card);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void setBackVisible(boolean visible){

        headerController.setBackVisible(visible);

    }

    private void setupAdminSection() {

        boolean isAdmin =
                SessionManager.getRole() == Role.ADMIN;

        adminSection.setVisible(isAdmin);
        adminSection.setManaged(isAdmin);

        quickAccessSection.setVisible(!isAdmin);
        quickAccessSection.setManaged(!isAdmin);

        if (!isAdmin) {
            return;
        }

        reviewAdvertisementsButton.setOnAction(event ->
                NavigationManager.showAdvertisements()
        );

        allAdvertisementsButton.setOnAction(event ->
                NavigationManager.showAllAdvertisements()
        );

        usersButton.setOnAction(event ->
                NavigationManager.showUsers()
        );

        categoriesButton.setOnAction(event ->
                NavigationManager.showCategories()
        );

        loadAdminStats();

    }

    private void loadAdminStats() {

        try {

            AdminDashboardResponse dashboard =
                    adminRepository.getDashboard();

            statsTotalUsersLabel.setText(
                    dashboard.getTotalUsers().toString()
            );

            statsBlockedUsersLabel.setText(
                    dashboard.getBlockedUsers().toString()
            );

            statsTotalAdsLabel.setText(
                    dashboard.getTotalAdvertisements().toString()
            );

            statsPendingAdsLabel.setText(
                    dashboard.getPendingAdvertisements().toString()
            );

            statsActiveAdsLabel.setText(
                    dashboard.getActiveAdvertisements().toString()
            );

            statsSoldAdsLabel.setText(
                    dashboard.getSoldAdvertisements().toString()
            );

            statsTotalCategoriesLabel.setText(
                    dashboard.getTotalCategories().toString()
            );

            statsTotalCitiesLabel.setText(
                    dashboard.getTotalCities().toString()
            );

            statsTotalProvincesLabel.setText(
                    dashboard.getTotalProvinces().toString()
            );


            statsTotalConversationsLabel.setText(
                    dashboard.getTotalConversations().toString()
            );

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }
}