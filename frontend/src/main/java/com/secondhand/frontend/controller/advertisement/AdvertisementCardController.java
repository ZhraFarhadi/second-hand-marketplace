package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class AdvertisementCardController {

    @FXML
    private VBox root;

    @FXML
    private Label titleLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label timeLabel;

    private Long advertisementId;

    @FXML
    public void initialize() {

        root.setOnMouseClicked(event -> {

            if (advertisementId != null) {

                NavigationManager.showAdvertisementDetails(
                        advertisementId
                );

            }

        });

    }

    public void setAdvertisement(
            AdvertisementSummaryResponse advertisement
    ) {

        this.advertisementId = advertisement.getId();

        titleLabel.setText(
                advertisement.getTitle()
        );

        priceLabel.setText(
                advertisement.getPrice().toPlainString()
        );

        cityLabel.setText(
                advertisement.getCity().getName()
        );

        timeLabel.setText("Recently");

    }

}