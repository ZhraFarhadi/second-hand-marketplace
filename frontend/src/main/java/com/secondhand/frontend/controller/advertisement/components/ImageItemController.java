package com.secondhand.frontend.controller.advertisement.components;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageItemController {

    @FXML
    private ImageView imageView;

    @FXML
    private Button removeButton;

    private Runnable removeAction;

    public void setImage(Image image){

        imageView.setImage(image);

    }

    public void setRemoveAction(Runnable action){

        removeAction = action;

    }

    @FXML
    private void removeImage(){

        if(removeAction != null){

            removeAction.run();

        }

    }

}