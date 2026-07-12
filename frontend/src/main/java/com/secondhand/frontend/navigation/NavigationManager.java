package com.secondhand.frontend.navigation;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationManager {

    private static Stage primaryStage;

    public static void initialize(Stage stage) {
        primaryStage = stage;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    private static void loadScene(String fxmlPath, String cssPath) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    NavigationManager.class.getResource(fxmlPath)
            );




            Scene scene = new Scene(loader.load(), 900, 650);

           if (cssPath != null && !cssPath.isBlank()) {

                scene.getStylesheets().add(
                        NavigationManager.class
                                .getResource(cssPath)
                                .toExternalForm()
                );

            }

            primaryStage.setScene(scene);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static void showLogin() {

        loadScene(
                "/view/auth/login.fxml",
                "/css/login.css"
        );

    }

    public static void showRegister() {

        loadScene(
                "/view/auth/register.fxml",
                "/css/login.css"
        );

    }

}