package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.controller.advertisement.components.CategorySelectorController;
import com.secondhand.frontend.controller.advertisement.components.ImageItemController;
import com.secondhand.frontend.controller.components.FloatingPriceFieldController;
import com.secondhand.frontend.controller.components.FloatingTextAreaController;
import com.secondhand.frontend.controller.components.FloatingTextFieldController;
import com.secondhand.frontend.exception.ApiException;
import javafx.application.Platform;
import com.secondhand.frontend.controller.components.HeaderController;
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

import com.secondhand.frontend.dto.province.response.ProvinceResponse;
import com.secondhand.frontend.model.AttributeType;
import com.secondhand.frontend.model.Subcategory;

import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdvertisementRepository;
import com.secondhand.frontend.repository.CategoryRepository;
import com.secondhand.frontend.repository.CityRepository;

import com.secondhand.frontend.repository.ProvinceRepository;
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

    @FXML
    private HeaderController headerController;

    @FXML
    private ComboBox<ProvinceResponse> provinceComboBox;



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


    private final ProvinceRepository provinceRepository =
            ProvinceRepository.getInstance();

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

        loadProvinces();

        provinceComboBox.setOnAction(event -> {

            ProvinceResponse province =
                    provinceComboBox.getValue();

            if (province != null) {

                loadCities(province.getId());

            }

        });

        headerController.setBackVisible(true);


        pageTitle.setText("Create Advertisement");

        publishButton.setText("Publish Advertisement");

    }

    private void loadCategories() {

        System.out.println("ENTER loadCategories");

        try {

            List<CategorySummaryResponse> rootCategories =
                    categoryRepository.getRootCategories();

            System.out.println("ROOT SIZE = " + rootCategories.size());

            categorySelectorController.setCategories(rootCategories);

            System.out.println("EXIT loadCategories");

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    private void loadCities(Long provinceId) {

        try {

            var cities =
                    cityRepository.getCitiesByProvince(provinceId);

            System.out.println(cities);
            System.out.println("SIZE = " + cities.size());

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

                    } else {

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

                    } else {

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


        System.out.println("----------------------------");
        System.out.println("loadSpecifications called");
        System.out.println("subcategory = " + subcategory.getName());
        specificationsContainer.getChildren().clear();

        specificationInputs.clear();

        currentAttributes.clear();

        if (subcategory == null)
            return;


        try {

            CategoryDetailsResponse details =
                    categoryRepository.getCategory(subcategory.getId());

            System.out.println("========== CATEGORY ==========");
            System.out.println("ID = " + details.getId());
            System.out.println("NAME = " + details.getName());

            System.out.println("ATTRIBUTES = " + details.getAttributes());

            if (details.getAttributes() != null) {

                System.out.println("SIZE = " + details.getAttributes().size());

                for (CategoryAttributeResponse a : details.getAttributes()) {

                    System.out.println(
                            a.getId() + " | "
                                    + a.getName() + " | "
                                    + a.getDataType()
                    );

                }

            }
            else {

                System.out.println("ATTRIBUTES IS NULL");

            }

            if (details == null)
                return;

            currentAttributes.addAll(details.getAttributes());

            System.out.println("========== CATEGORY ATTRIBUTES ==========");

            for (CategoryAttributeResponse a : currentAttributes) {

                System.out.println(
                        a.getId() + "  "
                                + a.getName() + "  "
                                + a.getDataType()
                );

            }
            System.out.println(details);
            System.out.println(details.getAttributes());
            System.out.println(details.getAttributes().size());

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

                    case SELECT -> {

                        ComboBox<String> comboBox = new ComboBox<>();

                        if (attribute.getOptions() != null) {
                            comboBox.getItems().addAll(attribute.getOptions());
                        }

                        input = comboBox;

                    }

                    default -> {

                        TextField tf = new TextField();

                        tf.setPromptText(attribute.getName());

                        input = tf;

                    }

                }

                input.setMaxWidth(Double.MAX_VALUE);

                specificationInputs.add(input);


                System.out.println(
                        "Added Input : " +
                                attribute.getName() +
                                " -> " +
                                attribute.getDataType()
                );


                VBox.setVgrow(fieldBox, Priority.NEVER);

                HBox.setHgrow(fieldBox, Priority.ALWAYS);

                fieldBox.getChildren().addAll(label, input);

                row.getChildren().add(fieldBox);

                column++;


                if (column == 3)
                    column = 0;

            }

            System.out.println("currentAttributes = " + currentAttributes.size());
            System.out.println("specificationInputs = " + specificationInputs.size());

        }

        catch (Exception e) {

            e.printStackTrace();

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

        List<File> files =
                chooser.showOpenMultipleDialog(
                        imageContainer.getScene().getWindow()
                );

        if (files == null || files.isEmpty())
            return;

        for (File file : files) {

            AdvertisementImageRequest image =
                    new AdvertisementImageRequest();

            image.setId(null);

            image.setImageUrl(file.toURI().toString());

            image.setDisplayOrder(currentImages.size());

            // اولین تصویر Primary باشد
            image.setPrimary(currentImages.isEmpty());

            currentImages.add(image);
        }

        refreshImages();
    }

    private void refreshImages() {

        imageContainer.getChildren().clear();

        for (AdvertisementImageRequest image : currentImages) {

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
                                image.getImageUrl()
                        )

                );

                controller.setRemoveAction(() -> {

                    currentImages.remove(image);

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

        System.out.println("currentAttributes = " + currentAttributes.size());
        System.out.println("specificationInputs = " + specificationInputs.size());

        for (int i = 0; i < specificationInputs.size(); i++) {
            System.out.println(
                    i + " -> " +
                            specificationInputs.get(i).getClass().getSimpleName()
            );
        }

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
            else if (control instanceof ComboBox<?> comboBox) {

                Object value = comboBox.getValue();

                if (value != null)
                    attribute.setValue(value.toString());

            }
            else if (control instanceof CheckBox checkBox) {

                attribute.setValue(String.valueOf(checkBox.isSelected()));

            }

            attributes.add(attribute);

        }

        request.setAttributes(attributes);

        request.setImages(currentImages);

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

                CreateAdvertisementRequest request = buildRequest();

                System.out.println("========== ATTRIBUTES ==========");

                for (AdvertisementAttributeRequest a : request.getAttributes()) {

                    System.out.println(
                            "attributeId = " + a.getCategoryAttributeId()
                                    + " value = " + a.getValue()
                    );

                }

                advertisementRepository.createAdvertisement(request);

            }

            NavigationManager.showHome();

        }

        catch (ApiException e) {

            errorLabel.setVisible(true);

            errorLabel.setText(e.getMessage());

        }

        catch (Exception e) {

            e.printStackTrace();

            errorLabel.setVisible(true);

            errorLabel.setText("Unexpected error.");

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

            request.setId(image.getId());

            request.setImageUrl(image.getImageUrl());

            request.setDisplayOrder(image.getDisplayOrder());

            request.setPrimary(image.isPrimary());

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

        refreshImages();

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

        System.out.println("===== UPDATE IMAGES =====");

        for (AdvertisementImageRequest img : currentImages) {

            System.out.println(
                    img.getId()
                            + " | "
                            + img.getDisplayOrder()
                            + " | "
                            + img.getImageUrl()
                            + " | "
                            + img.isPrimary()
            );

        }

        request.setImages(currentImages);


        return request;

    }


    private void loadProvinces() {

        try {

            var provinces =
                    provinceRepository.getProvinces();

            System.out.println("===== PROVINCES FROM API =====");
            System.out.println(provinces);
            System.out.println("SIZE = " + provinces.size());

            for (ProvinceResponse province : provinces) {

                System.out.println(
                        province.getId()
                                + " -> "
                                + province.getName()
                );

            }

            provinceComboBox.getItems().setAll(provinces);

            Platform.runLater(() -> {

                System.out.println(
                        "COMBO ITEM COUNT = "
                                + provinceComboBox.getItems().size()
                );

            });

            provinceComboBox.setCellFactory(param -> new ListCell<>() {

                @Override
                protected void updateItem(
                        ProvinceResponse item,
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

            provinceComboBox.setButtonCell(new ListCell<>() {

                @Override
                protected void updateItem(
                        ProvinceResponse item,
                        boolean empty
                ) {

                    super.updateItem(item, empty);

                    if (empty || item == null) {

                        setText("Select Province");

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




}