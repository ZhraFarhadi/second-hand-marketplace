package com.secondhand.frontend.controller.favorite;

import com.secondhand.frontend.controller.advertisement.AdvertisementCardController;
import com.secondhand.frontend.controller.components.HeaderController;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.frontend.repository.FavoriteRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.FlowPane;

import java.util.List;

public class FavoritesController {

    @FXML
    private FlowPane advertisementContainer;

    private final FavoriteRepository favoriteRepository =
            new FavoriteRepository();



    @FXML
    public void initialize() {

        loadFavorites();

    }

    private void loadFavorites() {

        try {

            List<AdvertisementSummaryResponse> advertisements =
                    favoriteRepository.getFavorites();

            advertisementContainer.getChildren().clear();

            if (advertisements == null || advertisements.isEmpty()) {

                return;

            }

            for (AdvertisementSummaryResponse advertisement : advertisements) {

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/view/advertisement/advertisement-card.fxml"
                                )
                        );

                Node card =
                        loader.load();

                AdvertisementCardController controller =
                        loader.getController();

                controller.setAdvertisement(advertisement);

                controller.setFavorite(true);

                advertisementContainer.getChildren().add(card);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @FXML
    private HeaderController headerController;

    public void setBackVisible(boolean visible) {

        headerController.setBackVisible(visible);

    }

}