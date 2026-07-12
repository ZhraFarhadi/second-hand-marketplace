package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.navigation.NavigationManager;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class AdvertisementCardController {

    @FXML
    private VBox root;

    @FXML
    public void initialize(){

        root.setOnMouseClicked(event -> {

            System.out.println("Card clicked");


            NavigationManager.showAdvertisementDetails();

        });

    }

}