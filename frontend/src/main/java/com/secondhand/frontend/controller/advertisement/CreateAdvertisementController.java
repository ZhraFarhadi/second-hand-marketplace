package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.controller.advertisement.components.CategorySelectorController;
import com.secondhand.frontend.controller.advertisement.components.ImageItemController;
import com.secondhand.frontend.controller.components.FloatingPriceFieldController;
import com.secondhand.frontend.controller.components.FloatingTextAreaController;
import com.secondhand.frontend.controller.components.FloatingTextFieldController;

import com.secondhand.frontend.dto.advertisement.request.AdvertisementAttributeRequest;
import com.secondhand.frontend.dto.advertisement.request.AdvertisementImageRequest;
import com.secondhand.frontend.dto.advertisement.request.CreateAdvertisementRequest;

import com.secondhand.frontend.dto.advertisement.request.UpdateAdvertisementRequest;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementAttributeResponse;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementDetailsResponse;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementImageResponse;
import com.secondhand.frontend.dto.category.response.CategoryAttributeResponse;
import com.secondhand.frontend.dto.category.response.CategoryDetailsResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;

import com.secondhand.frontend.dto.city.response.CitySummaryResponse;

import com.secondhand.frontend.model.AttributeType;
import com.secondhand.frontend.model.Subcategory;

import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdvertisementRepository;
import com.secondhand.frontend.repository.CategoryRepository;
import com.secondhand.frontend.repository.CityRepository;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.control.*;

import javafx.scene.image.Image;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import javafx.stage.FileChooser;

import java.io.File;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import com.secondhand.frontend.dto.city.response.CitySummaryResponse;




public class CreateAdvertisementController {

    @FXML
    private FloatingTextFieldController titleComponentController;

    @FXML
    private FloatingPriceFieldController priceComponentController;

    @FXML
    private FloatingTextAreaController descriptionComponentController;

    @FXML
    private CategorySelectorController categorySelectorController;

    @FXML
    private VBox specificationsContainer;

    @FXML
    private FlowPane imageContainer;

    @FXML
    private Label errorLabel;

    @FXML
    private ComboBox<CitySummaryResponse> cityComboBox;

    private boolean editMode = false;

    private Long editingAdvertisementId;

    @FXML
    private Label pageTitle;

    @FXML
    private Button publishButton;

    private final List<AdvertisementImageRequest> currentImages =
            new ArrayList<>();



    private final AdvertisementRepository advertisementRepository =
            AdvertisementRepository.getInstance();

    private final CategoryRepository categoryRepository =
            CategoryRepository.getInstance();

    private final CityRepository cityRepository =
            CityRepository.getInstance();

    private final List<Control> specificationInputs =
            new ArrayList<>();

    private final List<CategoryAttributeResponse> currentAttributes =
            new ArrayList<>();

    private final List<File> selectedImages =
            new ArrayList<>();

    private List<CategoryDetailsResponse> categories =
            new ArrayList<>();

    @FXML
    public void initialize() {

        titleComponentController.setLabel("Title");

        priceComponentController.setLabel("Price");

        descriptionComponentController.setLabel("Description");

        descriptionComponentController.setRTL(true);

        titleComponentController.getTextField().setPrefWidth(550);

        priceComponentController.getTextField().setPrefWidth(220);

        categorySelectorController.setOnSubcategorySelected(
                this::loadSpecifications
        );

        loadCategories();

        loadCities();


        pageTitle.setText("Create Advertisement");

        publishButton.setText("Publish Advertisement");

    }

    private void loadCategories() {

        try {

            categories =
                    categoryRepository.getCategories();

            categorySelectorController.setCategories(categories);

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    private void loadCities() {

        try {

            var cities =
                    cityRepository.getCities();

            cityComboBox.getItems().setAll(cities);

            cityComboBox.setCellFactory(param -> new ListCell<>() {

                @Override
                protected void updateItem(
                        CitySummaryResponse item,
                        boolean empty
                ) {

                    super.updateItem(item, empty);

                    if (empty || item == null) {

                        setText(null);

                    }

                    else {

                        setText(item.getName());

                    }

                }

            });

            cityComboBox.setButtonCell(new ListCell<>() {

                @Override
                protected void updateItem(
                        CitySummaryResponse item,
                        boolean empty
                ) {

                    super.updateItem(item, empty);

                    if (empty || item == null) {

                        setText("Select City");

                    }

                    else {

                        setText(item.getName());

                    }

                }

            });

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    private void loadSpecifications(Subcategory subcategory) {

        specificationsContainer.getChildren().clear();

        specificationInputs.clear();

        currentAttributes.clear();

        if (subcategory == null)
            return;

        CategoryDetailsResponse details = categories
                .stream()
                .filter(c ->
                        c.getName().equals(subcategory.getName()))
                .findFirst()
                .orElse(null);

        if (details == null)
            return;

        currentAttributes.addAll(details.getAttributes());

        HBox row = null;

        int column = 0;

        for (CategoryAttributeResponse attribute : currentAttributes) {

            if (column == 0) {

                row = new HBox(18);

                specificationsContainer.getChildren().add(row);

            }

            VBox fieldBox = new VBox(6);

            Label label = new Label(attribute.getName());

            Control input;

            switch (AttributeType.valueOf(attribute.getDataType())) {

                case NUMBER -> {

                    TextField tf = new TextField();

                    tf.setPromptText(attribute.getName());

                    input = tf;

                }

                default -> {

                    TextField tf = new TextField();

                    tf.setPromptText(attribute.getName());

                    input = tf;

                }

            }

            input.setMaxWidth(Double.MAX_VALUE);

            specificationInputs.add(input);

            VBox.setVgrow(fieldBox, Priority.NEVER);

            HBox.setHgrow(fieldBox, Priority.ALWAYS);

            fieldBox.getChildren().addAll(label, input);

            row.getChildren().add(fieldBox);

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
        descriptionComponentController.setError(false);

        categorySelectorController.setCategoryError(false);
        categorySelectorController.setSubcategoryError(false);

        cityComboBox.setStyle("");

        if (titleComponentController.getText().isBlank()) {

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

        if (priceComponentController.getValue() <= 0) {

            priceComponentController.setError(true);

            valid = false;

        }

        if (cityComboBox.getValue() == null) {

            cityComboBox.setStyle("""
            -fx-border-color:#e53935;
            -fx-border-width:2;
            """);

            valid = false;

        }
        else {

            cityComboBox.setStyle("");

        }

        if (descriptionComponentController.getText().isBlank()) {

            descriptionComponentController.setError(true);

            valid = false;

        }

        for (Control control : specificationInputs) {

            boolean empty = false;

            if (control instanceof TextField tf) {

                empty = tf.getText().isBlank();

            }

            if (empty) {

                control.setStyle("""
                    -fx-border-color:#e53935;
                    -fx-border-width:2;
                    """);

                valid = false;

            }

        }

        if (!valid) {

            errorLabel.setVisible(true);

            errorLabel.setText(
                    "Please complete all required fields."
            );

        }

        return valid;

    }

    @FXML
    private void chooseImages() {

        FileChooser chooser = new FileChooser();

        chooser.setTitle("Select Images");

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

        if (files == null)
            return;

        selectedImages.addAll(files);

        refreshImages();

    }

    private void refreshImages() {

        imageContainer.getChildren().clear();

        for (File file : selectedImages) {

            try {

                FXMLLoader loader =
                        new FXMLLoader(

                                getClass().getResource(
                                        "/view/advertisement/components/image-item.fxml"
                                )

                        );

                Node node = loader.load();

                ImageItemController controller =
                        loader.getController();

                controller.setImage(

                        new Image(
                                file.toURI().toString()
                        )

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

    private CreateAdvertisementRequest buildRequest() {

        CreateAdvertisementRequest request =
                new CreateAdvertisementRequest();

        request.setTitle(

                titleComponentController.getText()

        );

        request.setDescription(

                descriptionComponentController.getText()

        );

        request.setPrice(

                BigDecimal.valueOf(
                        priceComponentController.getValue()
                )

        );

        request.setCategoryId(

                categorySelectorController
                        .getSelectedSubcategory()
                        .getId()

        );

        request.setCityId(

                cityComboBox
                        .getValue()
                        .getId()

        );

        List<AdvertisementAttributeRequest> attributes =
                new ArrayList<>();

        for (int i = 0; i < currentAttributes.size(); i++) {

            AdvertisementAttributeRequest attribute =
                    new AdvertisementAttributeRequest();

            attribute.setCategoryAttributeId(

                    currentAttributes.get(i).getId()

            );

            Control control =
                    specificationInputs.get(i);

            if (control instanceof TextField tf) {

                attribute.setValue(tf.getText());

            }

            attributes.add(attribute);

        }

        request.setAttributes(attributes);

        List<AdvertisementImageRequest> images =
                new ArrayList<>();

        int order = 0;

        for (File file : selectedImages) {

            AdvertisementImageRequest image =
                    new AdvertisementImageRequest();

            image.setDisplayOrder(order++);

            image.setPrimary(order == 1);

            image.setImageUrl(

                    file.toURI().toString()

            );

            images.add(image);

        }

        request.setImages(images);

        return request;

    }

    @FXML
    private void publishAdvertisement() {

        if (!validateForm())
            return;

        try {

            if (editMode) {

                UpdateAdvertisementRequest request =
                        buildUpdateRequest();

                advertisementRepository.updateAdvertisement(
                        editingAdvertisementId,
                        request
                );

            }

            else {

                CreateAdvertisementRequest request =
                        buildRequest();

                advertisementRepository.createAdvertisement(
                        request
                );

            }

            NavigationManager.showMyAdvertisements();

        }

        catch (Exception e) {

            e.printStackTrace();

            errorLabel.setVisible(true);

            errorLabel.setText(
                    editMode
                            ? "Failed to update advertisement."
                            : "Failed to publish advertisement."
            );

        }

    }

    public void loadAdvertisementForEdit(Long advertisementId) {

        editMode = true;

        editingAdvertisementId = advertisementId;

        pageTitle.setText("Edit Advertisement");

        publishButton.setText("Update Advertisement");

        try {

            AdvertisementDetailsResponse advertisement =
                    advertisementRepository.getAdvertisementDetails(
                            advertisementId
                    );

            fillForm(advertisement);

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }


    private void fillForm(
            AdvertisementDetailsResponse advertisement
    ) {


        currentImages.clear();

        for (AdvertisementImageResponse image : advertisement.getImages()) {

            AdvertisementImageRequest request =
                    new AdvertisementImageRequest();

            request.setImageUrl(
                    image.getImageUrl()
            );

            request.setPrimary(
                    image.isPrimary()
            );

            currentImages.add(request);

        }
        /*
         * Title
         */

        titleComponentController.setText(
                advertisement.getTitle()
        );

        /*
         * Description
         */

        descriptionComponentController.setText(
                advertisement.getDescription()
        );

        /*
         * Price
         */

        priceComponentController.setValue(
                advertisement.getPrice().longValue()
        );

        /*
         * Category
         */

        categorySelectorController.selectCategory(

                advertisement
                        .getCategory()
                        .getId()

        );

        /*
         * City
         */

        cityComboBox.getItems().stream()

                .filter(city ->
                        city.getId().equals(
                                advertisement.getCity().getId()
                        )
                )

                .findFirst()

                .ifPresent(cityComboBox::setValue);

        /*
         * Specifications
         */

        for (int i = 0;
             i < advertisement.getAttributes().size();
             i++) {

            AdvertisementAttributeResponse attribute =
                    advertisement.getAttributes().get(i);

            Control control =
                    specificationInputs.get(i);

            if (control instanceof TextField tf) {

                tf.setText(attribute.getValue());

            }

        }

    }

    private UpdateAdvertisementRequest buildUpdateRequest() {

        UpdateAdvertisementRequest request =
                new UpdateAdvertisementRequest();

        request.setTitle(
                titleComponentController.getText()
        );

        request.setDescription(
                descriptionComponentController.getText()
        );

        request.setPrice(
                BigDecimal.valueOf(
                        priceComponentController.getValue()
                )
        );

        request.setCategoryId(
                categorySelectorController
                        .getSelectedSubcategory()
                        .getId()
        );

        request.setCityId(
                cityComboBox
                        .getValue()
                        .getId()
        );

        List<AdvertisementAttributeRequest> attributes =
                new ArrayList<>();

        for (int i = 0; i < currentAttributes.size(); i++) {

            AdvertisementAttributeRequest attribute =
                    new AdvertisementAttributeRequest();

            attribute.setCategoryAttributeId(
                    currentAttributes.get(i).getId()
            );

            Control control =
                    specificationInputs.get(i);

            if (control instanceof TextField tf) {

                attribute.setValue(
                        tf.getText()
                );

            }

            attributes.add(attribute);

        }

        request.setAttributes(attributes);

        List<AdvertisementImageRequest> images =
                new ArrayList<>();

        if (!selectedImages.isEmpty()) {

            int order = 0;

            for (File file : selectedImages) {

                AdvertisementImageRequest image =
                        new AdvertisementImageRequest();

                image.setImageUrl(
                        file.toURI().toString()
                );

                image.setPrimary(order == 0);

                order++;

                images.add(image);

            }

        }
        else {

            images.addAll(currentImages);

        }


        request.setImages(images);

        return request;

    }

}