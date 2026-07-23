package com.secondhand.frontend.model;

import javafx.scene.image.Image;

import java.io.File;

public class SelectedImage {

    private final File file;

    private final Image image;

    public SelectedImage(File file) {

        this.file = file;

        this.image = new Image(file.toURI().toString());

    }

    public File getFile() {

        return file;

    }

    public Image getImage() {

        return image;

    }

}