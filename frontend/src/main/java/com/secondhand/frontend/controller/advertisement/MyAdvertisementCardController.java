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
import com.secondhand.frontend.dto.auth.response.UserSummaryResponse;
import javafx.scene.control.ChoiceDialog;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView advertisementImageView;

    @FXML
    private Button reasonButton;

    @FXML
    private Label cityLabel;

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
                    advertisement.getId(),
                    NavigationManager::showMyAdvertisements
            );

        });

        reasonButton.setOnAction(event -> {

            event.consume();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("دلیل رد آگهی");

            alert.setHeaderText(null);

            alert.setContentText(
                    advertisement.getRejectionReason() != null
                            ? advertisement.getRejectionReason()
                            : "دلیلی ثبت نشده است."
            );

            alert.show();

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

            try {

                AdvertisementRepository repository =
                        AdvertisementRepository.getInstance();

                List<UserSummaryResponse> participants =
                        repository.getChatParticipants(
                                advertisement.getId()
                        );

                if (participants.isEmpty()) {

                    Alert noBuyers = new Alert(Alert.AlertType.INFORMATION);
                    noBuyers.setTitle("Mark As Sold");
                    noBuyers.setHeaderText(null);
                    noBuyers.setContentText(
                            "No one has chatted with you about this advertisement yet. " +
                                    "A buyer must contact you before you can mark it as sold."
                    );
                    noBuyers.show();

                    return;

                }

                ChoiceDialog<UserSummaryResponse> dialog =
                        new ChoiceDialog<>(
                                participants.get(0),
                                participants
                        );

                dialog.setTitle("Mark As Sold");
                dialog.setHeaderText("Select the buyer");
                dialog.setContentText("Buyer:");

                dialog.getItems().setAll(participants);

                dialog.showAndWait().ifPresent(selectedBuyer -> {

                    try {

                        repository.markAsSold(
                                advertisement.getId(),
                                selectedBuyer.getId()
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

                });

            }

            catch (Exception e) {

                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Error");
                error.setHeaderText(null);
                error.setContentText(
                        "Failed to load buyers for this advertisement."
                );
                error.show();

                e.printStackTrace();

            }

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

        if (advertisement.getPrimaryImageUrl() != null) {

            advertisementImageView.setImage(
                    new Image(
                            advertisement.getPrimaryImageUrl(),
                            true
                    )
            );

        }

        priceLabel.setText(
                advertisement.getPrice().toPlainString() + " تومان"
        );

        statusLabel.setText(
                advertisement.getStatus().name()
        );
        if (advertisement.getStatus() == AdvertisementStatus.SOLD) {

            soldButton.setDisable(true);

            soldButton.setText("Sold");

            editButton.setDisable(true);

        }
        else {

            soldButton.setDisable(false);

            soldButton.setText("Mark Sold");

            editButton.setDisable(false);

        }

        if (advertisement.getStatus() == AdvertisementStatus.REJECTED) {

            soldButton.setVisible(false);
            soldButton.setManaged(false);

            reasonButton.setVisible(true);
            reasonButton.setManaged(true);

        }
        else {

            soldButton.setVisible(true);
            soldButton.setManaged(true);

            reasonButton.setVisible(false);
            reasonButton.setManaged(false);

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

        System.out.println("Title = " + advertisement.getTitle());
        System.out.println("Price = " + advertisement.getPrice());
        System.out.println("Status = " + advertisement.getStatus());
        System.out.println("Created = " + advertisement.getCreatedAt());
    }



}