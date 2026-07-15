package com.secondhand.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import com.secondhand.frontend.navigation.NavigationManager;

public class FrontendApplication extends Application {


    @Override
    public void start(Stage stage) {

        stage.setTitle("Marketplace");

        NavigationManager.initialize(stage);

      // NavigationManager.showLogin();

       //NavigationManager.showCreateAdvertisement();
        NavigationManager.showHome();

        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
