package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.dto.advertisement.response.AdvertisementAttributeResponse;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementDetailsResponse;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementImageResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdvertisementRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import com.secondhand.frontend.util.RelativeTimeUtil;
import com.secondhand.frontend.repository.FavoriteRepository;

public class AdvertisementDetailsController {

    @FXML
    private ImageView mainImageView;

    @FXML
    private HBox thumbnailContainer;

    @FXML
    private VBox attributesContainer;

    @FXML
    private Label titleLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label sellerNameLabel;

    @FXML
    private Label sellerRateLabel;

    private Long advertisementId;

    @FXML
    private Label favoriteButton;


    private StackPane selectedThumbnail;

    private final FavoriteRepository favoriteRepository =
            new FavoriteRepository();

    @FXML
    public void initialize() {


        favoriteButton.setOnMouseClicked(e -> {

            favoriteClicked();

        });
        // منتظر loadAdvertisement می‌مانیم
    }

    @FXML
    private void onBackClicked() {
        NavigationManager.showHome();
    }

    public void loadAdvertisement(Long advertisementId) {

        this.advertisementId = advertisementId;

        try {

            AdvertisementDetailsResponse advertisement =
                    AdvertisementRepository
                            .getInstance()
                            .getAdvertisement(advertisementId);

            showAdvertisement(advertisement);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    private void showAdvertisement(
            AdvertisementDetailsResponse advertisement
    ) {

        titleLabel.setText(advertisement.getTitle());

        priceLabel.setText(
                advertisement.getPrice().toPlainString()
        );

        cityLabel.setText(
                advertisement.getCity().getName()
        );

        descriptionLabel.setText(
                advertisement.getDescription()
        );

        sellerNameLabel.setText(
                advertisement.getSeller().getFullName()
        );

        sellerRateLabel.setText("Seller");

        timeLabel.setText(
                RelativeTimeUtil.format(
                        advertisement.getCreatedAt()
                )
        );
        favorite = advertisement.isFavorite();

        updateFavoriteIcon();

        if (advertisement.isOwner()) {

            favoriteButton.setVisible(false);
            favoriteButton.setManaged(false);

        }
        else {

            favoriteButton.setVisible(true);
            favoriteButton.setManaged(true);

        }


        loadImages(advertisement);

        loadAttributes(advertisement);

    }

    private void loadImages(
            AdvertisementDetailsResponse advertisement
    ) {

        thumbnailContainer.getChildren().clear();

        if (advertisement.getImages() == null
                || advertisement.getImages().isEmpty()) {

            mainImageView.setImage(null);
            return;

        }

        AdvertisementImageResponse primaryImage =
                advertisement.getImages()
                        .stream()
                        .filter(AdvertisementImageResponse::isPrimary)
                        .findFirst()
                        .orElse(advertisement.getImages().get(0));

        Image mainImage =
                new Image(primaryImage.getImageUrl(), true);

        mainImageView.setImage(mainImage);

        for (AdvertisementImageResponse imageResponse
                : advertisement.getImages()) {

            Image image =
                    new Image(imageResponse.getImageUrl(), true);

            ImageView thumbnail =
                    new ImageView(image);

            thumbnail.setFitWidth(90);
            thumbnail.setFitHeight(90);
            thumbnail.setPreserveRatio(true);

            StackPane pane =
                    new StackPane(thumbnail);

            pane.getStyleClass().add("thumbnail");

            pane.setOnMouseClicked(event -> {

                mainImageView.setImage(image);

                if (selectedThumbnail != null) {

                    selectedThumbnail.getStyleClass()
                            .remove("thumbnail-selected");

                }

                pane.getStyleClass()
                        .add("thumbnail-selected");

                selectedThumbnail = pane;

            });

            thumbnailContainer.getChildren().add(pane);

        }

        selectedThumbnail =
                (StackPane) thumbnailContainer.getChildren().get(0);

        selectedThumbnail.getStyleClass()
                .add("thumbnail-selected");

    }

    private void loadAttributes(
            AdvertisementDetailsResponse advertisement
    ) {

        attributesContainer.getChildren().clear();

        if (advertisement.getAttributes() == null) {
            return;
        }

        for (AdvertisementAttributeResponse attribute
                : advertisement.getAttributes()) {

            HBox row = new HBox(15);

            Label key =
                    new Label(attribute.getAttributeName());

            key.getStyleClass().add("attribute-name");

            Label value =
                    new Label(attribute.getValue());

            value.getStyleClass().add("attribute-value");

            Region spacer = new Region();

            HBox.setHgrow(
                    spacer,
                    Priority.ALWAYS
            );

            row.getChildren().addAll(
                    key,
                    spacer,
                    value
            );

            attributesContainer.getChildren().add(row);

        }

    }

    private boolean favorite;

    private void updateFavoriteIcon() {

        if (favorite) {

            favoriteButton.setText("♥");

            favoriteButton.getStyleClass().add(
                    "favorite-heart-active"
            );

        } else {

            favoriteButton.setText("♡");

            favoriteButton.getStyleClass().remove(
                    "favorite-heart-active"
            );

        }

    }

    @FXML
    private void favoriteClicked() {

        if (advertisementId == null)
            return;

        try {

            favoriteRepository.toggleFavorite(
                    advertisementId
            );

            favorite = !favorite;

            updateFavoriteIcon();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

}