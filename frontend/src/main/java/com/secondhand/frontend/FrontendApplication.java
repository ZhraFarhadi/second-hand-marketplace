package com.secondhand.frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FrontendApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // اصلاح مسیر: چون فایل در پوشه view است، باید مسیر را به این صورت بنویسید
        FXMLLoader fxmlLoader = new FXMLLoader(
                FrontendApplication.class.getResource("view/hello-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
