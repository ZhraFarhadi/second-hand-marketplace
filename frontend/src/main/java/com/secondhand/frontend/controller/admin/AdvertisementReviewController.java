package com.secondhand.frontend.controller.admin;


import com.secondhand.frontend.dto.admin.response.AdminAdvertisementDetailsResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdminRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementImageResponse;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.Priority;

import com.secondhand.frontend.dto.advertisement.response.AdvertisementAttributeResponse;

public class AdvertisementReviewController {

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

    @FXML
    private TextArea descriptionArea;

    @FXML
    private FlowPane imagesPane;

    @FXML
    private VBox attributesBox;

    @FXML
    private TextArea rejectReasonField;

    private Long advertisementId;

    private final AdminRepository repository =
            new AdminRepository();


    public void setAdvertisementId(Long id){

        this.advertisementId = id;

        loadAdvertisement();

    }

    private void loadAdvertisement(){

        try{

            AdminAdvertisementDetailsResponse advertisement =
                    repository.getAdvertisementDetails(
                            advertisementId
                    );

            titleLabel.setText(
                    advertisement.getTitle()
            );

            sellerLabel.setText(
                    advertisement.getSellerUsername()
            );

            categoryLabel.setText(
                    advertisement.getCategoryName()
            );

            cityLabel.setText(
                    advertisement.getCityName()
            );

            priceLabel.setText(
                    advertisement.getPrice().toString()
            );

            descriptionArea.setText(
                    advertisement.getDescription()
            );

            loadImages(advertisement);

            loadAttributes(advertisement);

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }




    @FXML
    private void approveAdvertisement() {

        try {

            repository.approveAdvertisement(advertisementId);

            showSuccess("Advertisement approved successfully.");

            NavigationManager.showPendingAdvertisements();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }
    @FXML
    private void rejectAdvertisement() {

        try {

            if(rejectReasonField.getText().isBlank()){

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

            showSuccess("Advertisement rejected successfully.");

            NavigationManager.showPendingAdvertisements();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }
    @FXML
    private void back() {

        NavigationManager.showPendingAdvertisements();

    }

    private void showSuccess(String message){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();

    }


    private void loadImages(
            AdminAdvertisementDetailsResponse advertisement
    ){

        imagesPane.getChildren().clear();

        if(advertisement.getImages()==null
                || advertisement.getImages().isEmpty())
            return;

        for(AdvertisementImageResponse imageResponse
                : advertisement.getImages()){

            Image image =
                    new Image(
                            imageResponse.getImageUrl(),
                            true
                    );

            ImageView imageView =
                    new ImageView(image);

            imageView.setFitWidth(120);
            imageView.setFitHeight(120);

            imageView.setPreserveRatio(true);

            imagesPane.getChildren().add(imageView);

        }

    }

    private void loadAttributes(
            AdminAdvertisementDetailsResponse advertisement
    ){

        attributesBox.getChildren().clear();

        if(advertisement.getAttributes()==null)
            return;

        for(AdvertisementAttributeResponse attribute
                : advertisement.getAttributes()){

            HBox row = new HBox(15);

            Label key =
                    new Label(
                            attribute.getAttributeName()
                    );

            Label value =
                    new Label(
                            attribute.getValue()
                    );

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

            attributesBox.getChildren().add(row);

        }

    }
}
