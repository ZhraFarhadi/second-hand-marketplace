package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.dto.advertisement.response.MyAdvertisementSummaryResponse;
import com.secondhand.frontend.model.AdvertisementStatus;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdvertisementRepository;
import com.secondhand.frontend.util.RelativeTimeUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import com.secondhand.frontend.repository.AdvertisementRepository;
public class MyAdvertisementCardController {

    @FXML
    private VBox root;

    @FXML
    private Label titleLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private HBox actionsBox;

    @FXML
    private Button editButton;

    @FXML
    private Button soldButton;

    @FXML
    private Button deleteButton;

    private MyAdvertisementSummaryResponse advertisement;

    @FXML
    public void initialize() {

        root.setOnMouseClicked(event -> {

            if (advertisement != null) {

                NavigationManager.showAdvertisementDetails(
                        advertisement.getId()
                );

            }

        });

        editButton.setOnAction(event -> {

            event.consume();

            NavigationManager.showEditAdvertisement(
                    advertisement.getId()
            );

        });

        soldButton.setOnAction(event -> {

            event.consume();

            if (advertisement.getStatus() == AdvertisementStatus.SOLD) {

                Alert info = new Alert(Alert.AlertType.INFORMATION);

                info.setTitle("Advertisement");

                info.setHeaderText(null);

                info.setContentText("This advertisement is already marked as sold.");

                info.show();

                return;

            }

            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);

            confirm.setTitle("Mark As Sold");

            confirm.setHeaderText(null);

            confirm.setContentText(
                    "Do you want to mark this advertisement as sold?"
            );

            confirm.showAndWait().ifPresent(result -> {

                if (result == ButtonType.OK) {

                    try {

                        AdvertisementRepository repository =
                                AdvertisementRepository.getInstance();

                        repository.markAsSold(
                                advertisement.getId()
                        );

                        NavigationManager.showMyAdvertisements();

                    }

                    catch (Exception e) {

                        Alert error = new Alert(Alert.AlertType.ERROR);

                        error.setTitle("Error");

                        error.setHeaderText(null);

                        error.setContentText(
                                "Failed to mark advertisement as sold."
                        );

                        error.show();

                        e.printStackTrace();

                    }

                }

            });

        });

        deleteButton.setOnAction(event -> {

            event.consume();

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            alert.setTitle("Delete Advertisement");

            alert.setHeaderText(null);

            alert.setContentText(
                    "Are you sure you want to delete this advertisement?"
            );

            alert.showAndWait().ifPresent(result -> {

                if (result == ButtonType.OK) {

                    try {

                        AdvertisementRepository repository =
                                AdvertisementRepository.getInstance();

                        repository.deleteAdvertisement(
                                advertisement.getId()
                        );

                        NavigationManager.showMyAdvertisements();

                    }

                    catch (Exception e) {

                        Alert error = new Alert(Alert.AlertType.ERROR);

                        error.setTitle("Error");

                        error.setHeaderText(null);

                        error.setContentText(
                                "Failed to delete advertisement."
                        );

                        error.show();

                        e.printStackTrace();

                    }

                }

            });

        });

    }

    public void setAdvertisement(
            MyAdvertisementSummaryResponse advertisement
    ) {

        this.advertisement = advertisement;

        titleLabel.setText(
                advertisement.getTitle()
        );

        priceLabel.setText(
                advertisement.getPrice().toPlainString()
        );

        statusLabel.setText(
                advertisement.getStatus().name()
        );

        if (advertisement.getStatus() == AdvertisementStatus.SOLD) {

            soldButton.setDisable(true);

            soldButton.setText("Sold");

        }
        else {

            soldButton.setDisable(false);

            soldButton.setText("Mark Sold");

        }

        timeLabel.setText(
                RelativeTimeUtil.format(
                        advertisement.getCreatedAt()
                )
        );


        switch (advertisement.getStatus()) {

            case ACTIVE ->

                    statusLabel.setStyle(
                            "-fx-text-fill: green; -fx-font-weight: bold;"
                    );

            case PENDING ->

                    statusLabel.setStyle(
                            "-fx-text-fill: orange; -fx-font-weight: bold;"
                    );

            case REJECTED ->

                    statusLabel.setStyle(
                            "-fx-text-fill: red; -fx-font-weight: bold;"
                    );

            case SOLD ->

                    statusLabel.setStyle(
                            "-fx-text-fill: gray; -fx-font-weight: bold;"
                    );

        }
    }

}