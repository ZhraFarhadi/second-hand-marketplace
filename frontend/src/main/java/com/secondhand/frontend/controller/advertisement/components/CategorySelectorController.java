package com.secondhand.frontend.controller.advertisement.components;

import com.secondhand.frontend.mock.CategoryData;
import com.secondhand.frontend.model.Category;
import com.secondhand.frontend.model.Subcategory;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import java.util.function.Consumer;

public class CategorySelectorController {

    private Consumer<Subcategory> subcategorySelectedListener;

    @FXML
    private ComboBox<Category> categoryComboBox;

    @FXML
    private ComboBox<Subcategory> subcategoryComboBox;

    @FXML
    public void initialize() {

        categoryComboBox.getItems().addAll(CategoryData.getCategories());

        categoryComboBox.setOnAction(event -> {
            setCategoryError(false);
            setSubcategoryError(false);

            Category selectedCategory = categoryComboBox.getValue();

            subcategoryComboBox.getItems().clear();

            if (selectedCategory != null) {

                subcategoryComboBox
                        .getItems()
                        .addAll(selectedCategory.getSubcategories());

            }

        });

        subcategoryComboBox.setOnAction(event -> {

            setSubcategoryError(false);


            if (subcategorySelectedListener != null) {

                subcategorySelectedListener.accept(
                        subcategoryComboBox.getValue()
                );

            }

        });

    }


    public void setOnSubcategorySelected(Consumer<Subcategory> listener) {

        this.subcategorySelectedListener = listener;

    }

    public Category getSelectedCategory() {

        return categoryComboBox.getValue();

    }

    public Subcategory getSelectedSubcategory() {

        return subcategoryComboBox.getValue();

    }


    public void setCategoryError(boolean error) {

        if (error) {

            categoryComboBox.setStyle("""
            -fx-border-color:#e53935;
            -fx-border-width:2;
            -fx-border-radius:8;
        """);

        } else {

            categoryComboBox.setStyle("");

        }

    }

    public void setSubcategoryError(boolean error) {

        if (error) {

            subcategoryComboBox.setStyle("""
            -fx-border-color:#e53935;
            -fx-border-width:2;
            -fx-border-radius:8;
        """);

        } else {

            subcategoryComboBox.setStyle("");

        }

    }
}