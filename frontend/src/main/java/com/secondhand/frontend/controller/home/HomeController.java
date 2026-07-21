package com.secondhand.frontend.controller.home;


import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdvertisementRepository;
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

    private final AdvertisementRepository advertisementRepository =
            AdvertisementRepository.getInstance();


    private final CategoryRepository categoryRepository =
            CategoryRepository.getInstance();


    @FXML
    public void initialize() {

        categoryContainer.getChildren().clear();

        try {

            var categories =
                    categoryRepository.getCategories();

            for (CategoryDetailsResponse category : categories) {

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/view/home/components/category-item.fxml"
                                )
                        );

                VBox item = loader.load();

                CategoryItemController controller =
                        loader.getController();

                controller.setCategory(category);

                categoryContainer.getChildren().add(item);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        chatButton.setOnAction(event -> {

            NavigationManager.showConversationList();

        });

        myAdvertisementsButton.setOnAction(event -> {

            NavigationManager.showMyAdvertisements();

        });



        loadAdvertisements();

    }

    private void loadAdvertisements() {

        advertisementContainer.getChildren().clear();

        try {

            var advertisements =
                    advertisementRepository.getAdvertisements(0,20);

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
}