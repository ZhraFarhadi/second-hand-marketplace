package com.secondhand.frontend.controller.admin;

import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.admin.request.CreateAdminReviewRequest;
import com.secondhand.frontend.dto.admin.response.AdminAdvertisementDetailsResponse;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementAttributeResponse;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementImageResponse;
import com.secondhand.frontend.model.ReviewStatus;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdminRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class AdvertisementReviewController {

    @FXML
    private Label titleLabel;

    @FXML
    private Label sellerNameLabel;

    @FXML
    private Label sellerRateLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private VBox attributesContainer;

    @FXML
    private HBox thumbnailContainer;

    @FXML
    private ImageView mainImageView;

    @FXML
    private TextArea rejectReasonField;

    private Long advertisementId;

    private final AdminRepository repository = new AdminRepository();

    public void setAdvertisementId(Long id) {
        this.advertisementId = id;
        loadAdvertisement();
    }

    private void loadAdvertisement() {

        try {

            AdminAdvertisementDetailsResponse advertisement =
                    repository.getAdvertisementDetails(advertisementId);

            titleLabel.setText(advertisement.getTitle());

            sellerNameLabel.setText(advertisement.getSellerUsername());

            sellerRateLabel.setText(
                    advertisement.getSellerFullName()
            );

            cityLabel.setText(advertisement.getCityName());

            priceLabel.setText(
                    advertisement.getPrice().toString()
            );

            descriptionLabel.setText(
                    advertisement.getDescription()
            );

            if (advertisement.getCreatedAt() != null) {
                timeLabel.setText(
                        advertisement.getCreatedAt()
                                .toLocalDate()
                                .toString()
                );
            }

            loadImages(advertisement);

            loadAttributes(advertisement);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void loadImages(AdminAdvertisementDetailsResponse advertisement) {

        thumbnailContainer.getChildren().clear();

        if (advertisement.getImages() == null ||
                advertisement.getImages().isEmpty()) {
            return;
        }

        boolean first = true;

        for (AdvertisementImageResponse imageResponse : advertisement.getImages()) {

            Image image = new Image(imageResponse.getImageUrl(), true);

            if (first) {
                mainImageView.setImage(image);
                first = false;
            }

            ImageView thumb = new ImageView(image);

            thumb.setFitWidth(90);
            thumb.setFitHeight(90);
            thumb.setPreserveRatio(true);

            thumb.setOnMouseClicked(e ->
                    mainImageView.setImage(image));

            thumbnailContainer.getChildren().add(thumb);
        }
    }

    private void loadAttributes(AdminAdvertisementDetailsResponse advertisement) {

        attributesContainer.getChildren().clear();

        if (advertisement.getAttributes() == null)
            return;

        for (AdvertisementAttributeResponse attribute : advertisement.getAttributes()) {

            HBox row = new HBox(15);

            Label key = new Label(attribute.getAttributeName());

            Label value = new Label(attribute.getValue());

            Region spacer = new Region();
            HBox.setHgrow(spacer, Priority.ALWAYS);

            row.getChildren().addAll(
                    key,
                    spacer,
                    value
            );

            attributesContainer.getChildren().add(row);
        }
    }

    @FXML
    private void approveAdvertisement() {

        try {

            repository.approveAdvertisement(advertisementId);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Advertisement approved successfully.");
            alert.showAndWait();

            NavigationManager.showAdvertisements();

        } catch (Exception e) {

            e.printStackTrace();

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Failed to approve advertisement.");
            alert.showAndWait();

        }

    }

    @FXML
    private void rejectAdvertisement() {

        try {

            if (rejectReasonField.getText().isBlank()) {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText(null);
                alert.setContentText("Please enter reject reason.");
                alert.showAndWait();
                return;
            }

            repository.rejectAdvertisement(
                    advertisementId,
                    rejectReasonField.getText()
            );

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Advertisement rejected successfully.");
            alert.showAndWait();

            NavigationManager.showAdvertisements();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void back() {
        NavigationManager.showAdvertisements();
    }

}