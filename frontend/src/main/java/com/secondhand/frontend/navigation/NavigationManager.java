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


    private static void loadScene(String fxmlPath, String... cssPaths) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    NavigationManager.class.getResource(fxmlPath)
            );

            // ذخیره وضعیت فعلی Stage
            boolean maximized = primaryStage.isMaximized();

            double width = primaryStage.getWidth();
            double height = primaryStage.getHeight();

            Scene scene = new Scene(loader.load(), 900, 650);

            for (String cssPath : cssPaths) {

                if (cssPath != null && !cssPath.isBlank()) {

                    var url = NavigationManager.class.getResource(cssPath);

                    System.out.println("CSS = " + cssPath);
                    System.out.println("URL = " + url);

                    if (url != null) {

                        scene.getStylesheets().add(url.toExternalForm());

                    } else {

                        System.out.println("CSS NOT FOUND!");

                    }
                }
            }

            primaryStage.setScene(scene);

            // برگرداندن اندازه قبلی پنجره
            if (maximized) {

                primaryStage.setMaximized(true);

            } else {

                primaryStage.setWidth(width);
                primaryStage.setHeight(height);

            }

        }

        catch (IOException e) {

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

    public static void showHome() {

        loadScene(
                "/view/home/home.fxml",
                "/css/header.css",
                "/css/home.css",
                "/css/advertisement-card.css"
        );

    }

    public static void showAdvertisementDetails() {

        loadScene(
                "/view/advertisement/advertisement-details.fxml",
                "/css/header.css",
                "/css/advertisementdetail.css"
        );


    }

    public static void showCreateAdvertisement() {

        loadScene(
                "/view/advertisement/create-advertisement.fxml",
                "/css/header.css",
                "/css/create-advertisement.css"
        );

    }


}