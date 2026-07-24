package com.secondhand.frontend.controller.admin;

import com.secondhand.frontend.dto.admin.response.AdminCategoryResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdminRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CategoriesController {

    @FXML
    private TableView<AdminCategoryResponse> categoriesTable;

    @FXML
    private TableColumn<AdminCategoryResponse, Long> idColumn;

    @FXML
    private TableColumn<AdminCategoryResponse, String> nameColumn;

    private final AdminRepository repository =
            new AdminRepository();

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        loadCategories();

        categoriesTable.setRowFactory(tv -> {

            TableRow<AdminCategoryResponse> row =
                    new TableRow<>();

            row.setOnMouseClicked(e -> {

                if (e.getClickCount() == 2 && !row.isEmpty()) {

                  /*  NavigationManager.showCategoryDetails(
                            row.getItem().getId()
                    );
*/
                }

            });

            return row;

        });

    }

    private void loadCategories() {

        try {

            categoriesTable.setItems(

                    FXCollections.observableArrayList(

                            repository.getCategories()

                    )

            );

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void createCategory() {

        NavigationManager.showCreateCategory();

    }

    @FXML
    private void deleteCategory() {

        AdminCategoryResponse selected =
                categoriesTable.getSelectionModel().getSelectedItem();

        if (selected == null)
            return;

        repository.deleteCategory(
                selected.getId()
        );

        loadCategories();

    }

    @FXML
    private void goDashboard() {
        NavigationManager.showHome();
    }

}