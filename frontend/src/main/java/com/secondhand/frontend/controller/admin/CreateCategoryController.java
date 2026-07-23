package com.secondhand.frontend.controller.admin;

import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdminRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CreateCategoryController {

    @FXML
    private TextField nameField;

    @FXML
    private TextArea descriptionField;

    private final AdminRepository repository =
            new AdminRepository();

    @FXML
    private void createCategory() {

        repository.createCategory(

                nameField.getText(),

                descriptionField.getText()

        );

        NavigationManager.showCategories();

    }



    @FXML
    private void goBack() {

        NavigationManager.showCategories();

    }

}