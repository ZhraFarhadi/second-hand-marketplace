package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.navigation.NavigationManager;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class AdvertisementDetailsController {

    @FXML
    private ImageView mainImageView;

    @FXML
    private HBox thumbnailContainer;



    private StackPane selectedThumbnail;

    @FXML
    public void initialize() {

        loadGallery();

    }

    private void loadGallery() {

        thumbnailContainer.getChildren().clear();

        String[] images = {

                "/images/sample1.png",
                "/images/sample2.png",
                "/images/sample3.png"

        };

        for (String path : images) {

            Image image = new Image(
                    getClass().getResourceAsStream(path)
            );

            ImageView thumbnail = new ImageView(image);

            thumbnail.setFitWidth(90);
            thumbnail.setFitHeight(90);
            thumbnail.setPreserveRatio(true);

            StackPane thumbnailPane = new StackPane(thumbnail);

            thumbnailPane.getStyleClass().add("thumbnail");


            thumbnailPane.setOnMouseClicked(event -> {

                mainImageView.setImage(image);

                if (selectedThumbnail != null) {
                    selectedThumbnail.getStyleClass().remove("thumbnail-selected");
                }

                thumbnailPane.getStyleClass().add("thumbnail-selected");

                selectedThumbnail = thumbnailPane;

            });

            thumbnailContainer.getChildren().add(thumbnailPane);

        }

        mainImageView.setImage(
                new Image(
                        getClass().getResourceAsStream(images[0])
                )
        );

        selectedThumbnail =
                (StackPane) thumbnailContainer.getChildren().get(0);

        selectedThumbnail.getStyleClass().add("thumbnail-selected");


    }

    @FXML
    private void onBackClicked() {

        NavigationManager.showHome();

    }

}