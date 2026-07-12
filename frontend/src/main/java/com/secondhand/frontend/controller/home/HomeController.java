package com.secondhand.frontend.controller.home;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Parent;

public class HomeController {

    @FXML
    private VBox categoryContainer;

    @FXML
    private FlowPane advertisementContainer;


    @FXML
    private Button favoritesButton;

    @FXML
    private Button chatButton;

    @FXML
    public void initialize() {

        addCategory("📱 Electronics");
        addCategory("🚗 Vehicles");
        addCategory("🏠 Home");
        addCategory("👕 Fashion");
        addCategory("⚽ Sports");
        addCategory("💼 Jobs");
        addCategory("🛠 Services");

        loadSampleAdvertisements();
    }

    private void addCategory(String title){

        Button button = new Button(title);

        button.setMaxWidth(Double.MAX_VALUE);

        button.getStyleClass().add("category-button");

        categoryContainer.getChildren().add(button);

    }




    private void loadSampleAdvertisements() {

        try {

            for(int i = 0 ; i < 8 ; i++){

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/view/advertisement/advertisement-card.fxml"
                                )
                        );

                Parent card = loader.load();

                advertisementContainer.getChildren().add(card);

            }

        }

        catch(IOException e){

            e.printStackTrace();

        }

    }
}