package com.secondhand.frontend.navigation;

import com.secondhand.frontend.controller.advertisement.CreateAdvertisementController;
import com.secondhand.frontend.controller.conversation.ChatController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.secondhand.frontend.controller.advertisement.AdvertisementDetailsController;
import com.secondhand.frontend.controller.advertisement.CreateAdvertisementController;
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


    private static void loadSceneWithController(
            String fxmlPath,
            Long advertisementId,
            String... cssPaths
    ) {

        try {

            FXMLLoader loader = new FXMLLoader(
                    NavigationManager.class.getResource(fxmlPath)
            );

            boolean maximized = primaryStage.isMaximized();

            double width = primaryStage.getWidth();
            double height = primaryStage.getHeight();

            Scene scene = new Scene(loader.load(), 900, 650);

            AdvertisementDetailsController controller =
                    loader.getController();

            controller.loadAdvertisement(advertisementId);

            for (String cssPath : cssPaths) {

                if (cssPath != null && !cssPath.isBlank()) {

                    var url = NavigationManager.class.getResource(cssPath);

                    if (url != null) {

                        scene.getStylesheets().add(
                                url.toExternalForm()
                        );

                    }

                }

            }

            primaryStage.setScene(scene);

            if (maximized) {

                primaryStage.setMaximized(true);

            }
            else {

                primaryStage.setWidth(width);
                primaryStage.setHeight(height);

            }

        }

        catch (IOException e) {

            e.printStackTrace();

        }

    }

    private static FXMLLoader loadFXML(
            String fxmlPath
    ){

        try{

            FXMLLoader loader =
                    new FXMLLoader(
                            NavigationManager.class.getResource(
                                    fxmlPath
                            )
                    );

            loader.load();

            return loader;

        }

        catch (Exception e){

            throw new RuntimeException(e);

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

    public static void showAdvertisementDetails(Long advertisementId) {

        loadSceneWithController(

                "/view/advertisement/advertisement-details.fxml",

                advertisementId,

                "/css/header.css",
                "/css/advertisementdetail.css"

        );

    }

    public static void showCreateAdvertisement() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            NavigationManager.class.getResource(
                                    "/view/advertisement/create-advertisement.fxml"
                            )
                    );

            Scene scene =
                    new Scene(loader.load());

            scene.getStylesheets().add(
                    NavigationManager.class.getResource(
                            "/css/header.css"
                    ).toExternalForm()
            );

            scene.getStylesheets().add(
                    NavigationManager.class.getResource(
                            "/css/create-advertisement.css"
                    ).toExternalForm()
            );

            primaryStage.setScene(scene);

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }




    public static void showConversation(
            Long conversationId
    ){

        FXMLLoader loader =
                loadFXML(
                        "/view/conversation/chat.fxml"
                );

        ChatController controller =
                loader.getController();

        controller.setConversationId(
                conversationId
        );

        Scene scene =
                new Scene(
                        loader.getRoot()
                );

        primaryStage.setScene(scene);

    }

    public static void showConversationList() {

        loadScene(
                "/view/conversation/conversation-list.fxml",
                "/css/conversation.css"
        );

    }

    public static void showMyAdvertisements() {

        loadScene(
                "/view/advertisement/my-advertisements.fxml",
                "/css/header.css",
                "/css/my-advertisements.css"
        );

    }


    public static void showEditAdvertisement(
            Long advertisementId
    ) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            NavigationManager.class.getResource(
                                    "/view/advertisement/create-advertisement.fxml"
                            )
                    );

            boolean maximized =
                    primaryStage.isMaximized();

            double width =
                    primaryStage.getWidth();

            double height =
                    primaryStage.getHeight();

            Scene scene =
                    new Scene(loader.load());

            scene.getStylesheets().add(
                    NavigationManager.class
                            .getResource("/css/header.css")
                            .toExternalForm()
            );

            scene.getStylesheets().add(
                    NavigationManager.class
                            .getResource("/css/create-advertisement.css")
                            .toExternalForm()
            );

            CreateAdvertisementController controller =
                    loader.getController();

            controller.loadAdvertisementForEdit(
                    advertisementId
            );

            primaryStage.setScene(scene);

            if (maximized) {

                primaryStage.setMaximized(true);

            } else {

                primaryStage.setWidth(width);

                primaryStage.setHeight(height);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }



}