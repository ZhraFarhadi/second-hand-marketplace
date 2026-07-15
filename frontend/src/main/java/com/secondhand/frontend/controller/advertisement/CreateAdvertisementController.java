package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.controller.advertisement.components.CategorySelectorController;
import com.secondhand.frontend.controller.components.FloatingPriceFieldController;
import com.secondhand.frontend.controller.components.FloatingTextAreaController;
import com.secondhand.frontend.controller.components.FloatingTextFieldController;
import com.secondhand.frontend.mock.SpecificationData;
import com.secondhand.frontend.model.AttributeType;
import com.secondhand.frontend.model.SpecificationField;
import com.secondhand.frontend.model.Subcategory;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Control;
import com.secondhand.frontend.controller.advertisement.components.ImageItemController;

public class CreateAdvertisementController {

    private final List<Control> specificationInputs = new ArrayList<>();

    @FXML
    private FloatingTextFieldController titleComponentController;

    @FXML
    private FloatingPriceFieldController priceComponentController;

    @FXML
    private FloatingTextFieldController cityComponentController;

    @FXML
    private FloatingTextAreaController descriptionComponentController;

    @FXML
    private TextArea descriptionArea;

    @FXML
    private VBox specificationsContainer;

    @FXML
    private CategorySelectorController categorySelectorController;

    @FXML
    private Label errorLabel;

    @FXML
    private FlowPane imageContainer;

    private final List<File> selectedImages = new ArrayList<>();

    @FXML
    public void initialize() {

        titleComponentController.setLabel("Title");
        priceComponentController.setLabel("Price");
        cityComponentController.setLabel("City");

        titleComponentController.getTextField().setPrefWidth(550);
        priceComponentController.getTextField().setPrefWidth(220);
        cityComponentController.getTextField().setPrefWidth(220);

        descriptionComponentController.setLabel("Description");
        descriptionComponentController.setRTL(true);

        categorySelectorController.setOnSubcategorySelected(this::loadSpecifications);

        System.out.println("Create Advertisement Loaded");
    }

    private void loadSpecifications(Subcategory subcategory) {

        specificationsContainer.getChildren().clear();

        specificationInputs.clear();

        if (subcategory == null)
            return;

        var fields = SpecificationData.getFields(subcategory.getName());

        HBox currentRow = null;
        int column = 0;

        for (SpecificationField field : fields) {

            if (column == 0) {

                 currentRow = new HBox(18);
                currentRow.setFillHeight(true);
                specificationsContainer.getChildren().add(currentRow);

            }

            VBox fieldBox = new VBox(6);

            Label label = new Label(field.getLabel());

            Node input;

            switch (field.getType()) {

                case TEXT -> {

                    TextField tf = new TextField();

                    specificationInputs.add(tf);

                    tf.setPromptText(field.getLabel());

                    tf.setPrefHeight(44);

                    tf.setStyle("""
    -fx-font-size:15px;
    -fx-alignment:CENTER_LEFT;
""");

                    tf.setMaxWidth(Double.MAX_VALUE);

                    input = tf;

                }

                case NUMBER -> {

                    TextField tf = new TextField();

                    specificationInputs.add(tf);

                    tf.setPromptText(field.getLabel());

                    tf.setPrefHeight(44);

                    tf.setStyle("""
    -fx-font-size:15px;
    -fx-alignment:CENTER_LEFT;
""");

                    tf.setMaxWidth(Double.MAX_VALUE);

                    input = tf;

                }

                case DROPDOWN -> {

                    ComboBox<String> combo = new ComboBox<>();

                    specificationInputs.add(combo);

                    combo.getItems().addAll(field.getOptions());

                    combo.setPromptText(field.getLabel());

                    combo.setPrefHeight(44);

                    combo.setStyle("""
    -fx-font-size:15px;
""");

                    combo.setMaxWidth(Double.MAX_VALUE);

                    input = combo;

                }

                default -> {

                    TextField tf = new TextField();
                    tf.setPromptText(field.getLabel());

                    input = tf;

                }

            }

            VBox.setVgrow(fieldBox, Priority.NEVER);
            HBox.setHgrow(fieldBox, Priority.ALWAYS);
            fieldBox.setPrefWidth(260);
            fieldBox.setMaxWidth(Double.MAX_VALUE);

            fieldBox.getChildren().addAll(label, input);

            currentRow.getChildren().add(fieldBox);
            

            column++;

            if (column == 3)
                column = 0;
        }
    }


    private boolean validateForm() {

        boolean valid = true;

        errorLabel.setVisible(false);

        titleComponentController.setError(false);
        priceComponentController.setError(false);
        cityComponentController.setError(false);
        descriptionComponentController.setError(false);

        categorySelectorController.setCategoryError(false);
        categorySelectorController.setSubcategoryError(false);

        if (titleComponentController.getTextField().getText().isBlank()) {

            titleComponentController.setError(true);
            valid = false;

        }

        if (categorySelectorController.getSelectedCategory() == null) {

            categorySelectorController.setCategoryError(true);
            valid = false;

        }

        if (categorySelectorController.getSelectedSubcategory() == null) {

            categorySelectorController.setSubcategoryError(true);
            valid = false;

        }

        if (priceComponentController.getTextField().getText().isBlank()) {

            priceComponentController.setError(true);
            valid = false;

        }

        if (cityComponentController.getTextField().getText().isBlank()) {

            cityComponentController.setError(true);
            valid = false;

        }

        if (descriptionComponentController.getTextArea().getText().isBlank()) {

            descriptionComponentController.setError(true);
            valid = false;

        }

        // Validation Specifications

        for (Control control : specificationInputs) {

            boolean empty = false;

            if (control instanceof TextField tf) {

                empty = tf.getText().isBlank();

            }

            else if (control instanceof ComboBox<?> combo) {

                empty = combo.getValue() == null;

            }

            if (empty) {

                control.setStyle("""
                    -fx-border-color:#e53935;
                    -fx-border-width:2;
                    -fx-border-radius:8;
                    """);

                valid = false;

            }

            else {

                control.setStyle("");

            }

        }

        if (!valid) {

            errorLabel.setVisible(true);
            errorLabel.setText("Please complete all required fields.");

        }

        return valid;

    }

    @FXML
    private void publishAdvertisement() {

        if (!validateForm()) {
            return;
        }

        System.out.println("Advertisement Published!");

    }

    @FXML
    private void chooseImages() {

        FileChooser chooser = new FileChooser();

        chooser.setTitle("Select Advertisement Images");

        chooser.getExtensionFilters().add(

                new FileChooser.ExtensionFilter(
                        "Images",
                        "*.png",
                        "*.jpg",
                        "*.jpeg"
                )

        );

        List<File> files = chooser.showOpenMultipleDialog(

                imageContainer.getScene().getWindow()

        );

        if (files == null || files.isEmpty())
            return;

        selectedImages.addAll(files);

        refreshImages();

    }

    private void refreshImages() {

        imageContainer.getChildren().clear();

        for (File file : selectedImages) {

            try {

                FXMLLoader loader = new FXMLLoader(

                        getClass().getResource(
                                "/view/advertisement/components/image-item.fxml"
                        )

                );

                Node node = loader.load();

                ImageItemController controller = loader.getController();

                controller.setImage(

                        new Image(file.toURI().toString())

                );

                controller.setRemoveAction(() -> {

                    selectedImages.remove(file);

                    refreshImages();

                });

                imageContainer.getChildren().add(node);

            }

            catch (Exception e) {

                e.printStackTrace();

            }

        }

    }
}