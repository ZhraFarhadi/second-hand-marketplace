package com.secondhand.frontend.controller.admin;

import com.secondhand.frontend.dto.admin.response.AdminAdvertisementSummaryResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AdvertisementReviewItemController {

    @FXML
    private VBox root;

    @FXML
    private Label titleLabel;

    @FXML
    private Label sellerLabel;

    @FXML
    private Label categoryLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label priceLabel;

    private Long advertisementId;

    public void setData(AdminAdvertisementSummaryResponse advertisement){

        this.advertisementId = advertisement.getId();

        titleLabel.setText(advertisement.getTitle());

        sellerLabel.setText(advertisement.getSellerUsername());

        categoryLabel.setText(advertisement.getCategoryName());

        cityLabel.setText(advertisement.getCityName());

        priceLabel.setText(advertisement.getPrice().toString());

        root.setOnMouseClicked(e ->

                NavigationManager.showAdvertisementReview(advertisementId)

        );

    }

}