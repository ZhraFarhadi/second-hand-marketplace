package com.secondhand.frontend.navigation;

import com.secondhand.frontend.controller.admin.AdvertisementReviewController;
import com.secondhand.frontend.controller.admin.UserDetailsController;
import com.secondhand.frontend.controller.advertisement.CreateAdvertisementController;
import com.secondhand.frontend.controller.conversation.ChatController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

            Parent root = loader.load();

            boolean maximized = primaryStage.isMaximized();

            double width = primaryStage.getWidth();
            double height = primaryStage.getHeight();

            Scene scene = new Scene(root, 900, 650);

            for (String cssPath : cssPaths) {

                if (cssPath != null && !cssPath.isBlank()) {

                    var url = NavigationManager.class.getResource(cssPath);

                    System.out.println("CSS = " + cssPath);
                    System.out.println("URL = " + url);

                    if (url != null) {

                        scene.getStylesheets().add(url.toExternalForm());

                    }

                }

            }

            Object controller = loader.getController();

            if (controller instanceof com.secondhand.frontend.controller.home.HomeController home) {

                home.setBackVisible(false);

            }

            if (controller instanceof com.secondhand.frontend.controller.profile.ProfileController profile) {

                profile.setBackVisible(true);

            }

            if (controller instanceof com.secondhand.frontend.controller.favorite.FavoritesController favorites) {

                favorites.setBackVisible(true);

            }

            if (controller instanceof com.secondhand.frontend.controller.advertisement.MyAdvertisementsController myAdvertisements) {

                myAdvertisements.setBackVisible(true);

            }



            primaryStage.setScene(scene);

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

    private static FXMLLoader loadFXML(String fxmlPath){

        try{

            FXMLLoader loader =
                    new FXMLLoader(
                            NavigationManager.class.getResource(fxmlPath)
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
        showConversation(
                conversationId,
                NavigationManager::showConversationList
        );
    }

    public static void showConversation(
            Long conversationId,
            Runnable onBack
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

        controller.setOnBack(
                onBack
        );

        Scene scene =
                new Scene(
                        loader.getRoot()
                );

        var cssUrl =
                NavigationManager.class.getResource(
                        "/css/chat.css"
                );

        if (cssUrl != null) {

            scene.getStylesheets().add(
                    cssUrl.toExternalForm()
            );

        }

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

        showEditAdvertisement(advertisementId, NavigationManager::showHome);

    }

    public static void showEditAdvertisement(
            Long advertisementId,
            Runnable onBack
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

            controller.setOnBack(onBack);

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

    public static void showFavorites() {

        loadScene(
                "/view/favorite/favorites.fxml",
                "/css/header.css",
                "/css/home.css",
                "/css/advertisement-card.css"
        );

    }

    public static void showProfile() {


        System.out.println("NavigationManager class = "
                + NavigationManager.class);

        System.out.println("ClassLoader = "
                + NavigationManager.class.getClassLoader());

        System.out.println("Root = "
                + NavigationManager.class.getResource("/"));

        System.out.println("Profile = "
                + NavigationManager.class.getResource("/view/profile/profile.fxml"));


        loadScene(
                "/view/profile/profile.fxml",
                "/css/header.css",
                "/css/profile.css"
        );

    }


    public static void showAdminDashboard(){

        loadScene(
                "/view/admin/dashboard.fxml",
                "/css/header.css",
                "/css/admin.css"
        );

    }

    public static void showAdminUsers(){

        loadScene(
                "/view/admin/admin-users.fxml",
                "/css/header.css",
                "/css/admin.css"
        );

    }

    public static void showPendingAdvertisements(){

        loadScene(
                "/view/admin/advertisement-review.fxml",
                "/css/header.css",
                "/css/admin.css"
        );

    }



    public static void showDashboard() {

        loadScene(
                "/view/admin/dashboard.fxml",
                "/css/header.css",
                "/css/dashboard.css"
        );

    }

    public static void showUsers() {

        loadScene(
                "/view/admin/users.fxml",
                "/css/header.css",
                "/css/users.css"
        );

    }



    public static void showAdvertisements() {

        loadScene("/view/admin/advertisements.fxml");

    }



    public static void showAdvertisementReview(
            Long advertisementId
    ){

        try{

            FXMLLoader loader =
                    new FXMLLoader(
                            NavigationManager.class.getResource(
                                    "/view/admin/advertisement-review.fxml"
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

            AdvertisementReviewController controller =
                    loader.getController();

            controller.setAdvertisementId(
                    advertisementId
            );

            scene.getStylesheets().add(
                    NavigationManager.class
                            .getResource("/css/header.css")
                            .toExternalForm()
            );

            scene.getStylesheets().add(
                    NavigationManager.class
                            .getResource("/css/advertisementdetail.css")
                            .toExternalForm()
            );

            scene.getStylesheets().add(
                    NavigationManager.class
                            .getResource("/css/admin.css")
                            .toExternalForm()
            );

            primaryStage.setScene(scene);

            if(maximized){

                primaryStage.setMaximized(true);

            }

            else{

                primaryStage.setWidth(width);

                primaryStage.setHeight(height);

            }

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }


    public static void showUserDetails(Long userId){

        try{

            FXMLLoader loader =
                    new FXMLLoader(
                            NavigationManager.class.getResource(
                                    "/view/admin/user-details.fxml"
                            )
                    );

            Scene scene =
                    new Scene(loader.load());

            UserDetailsController controller =
                    loader.getController();

            controller.setUserId(userId);

            primaryStage.setScene(scene);

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }


    public static void showCategories(){

        loadScene(
                "/view/admin/categories.fxml",
                "/css/header.css",
                "/css/admin.css"
        );

    }
    public static void showCreateCategory(){

        loadScene(

                "/view/admin/create-category.fxml",

                "/css/header.css",

                "/css/admin.css"

        );



    }

    public static void showAdvertisementDetailsForDelete(
            Long advertisementId
    ) {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            NavigationManager.class.getResource(
                                    "/view/admin/advertisement-review.fxml"
                            )
                    );

            Scene scene =
                    new Scene(loader.load());

            AdvertisementReviewController controller =
                    loader.getController();

            controller.setAdvertisementIdForDelete(
                    advertisementId
            );

            scene.getStylesheets().add(
                    NavigationManager.class
                            .getResource("/css/header.css")
                            .toExternalForm()
            );

            scene.getStylesheets().add(
                    NavigationManager.class
                            .getResource("/css/advertisementdetail.css")
                            .toExternalForm()
            );

            scene.getStylesheets().add(
                    NavigationManager.class
                            .getResource("/css/admin.css")
                            .toExternalForm()
            );

            primaryStage.setScene(scene);

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static void showAllAdvertisements() {

        loadScene(
                "/view/admin/all-advertisements.fxml",
                "/css/header.css",
                "/css/admin.css"
        );

    }
}