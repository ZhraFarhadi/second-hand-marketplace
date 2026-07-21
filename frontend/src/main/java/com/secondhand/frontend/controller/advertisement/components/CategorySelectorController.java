package com.secondhand.frontend.controller.advertisement.components;

import com.secondhand.frontend.dto.category.response.CategoryDetailsResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;
import com.secondhand.frontend.model.Category;
import com.secondhand.frontend.model.Subcategory;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CategorySelectorController {

    @FXML
    private ComboBox<Category> categoryComboBox;

    @FXML
    private ComboBox<Subcategory> subcategoryComboBox;

    private Consumer<Subcategory> subcategorySelectedListener;

    private List<CategoryDetailsResponse> categories =
            new ArrayList<>();

    @FXML
    public void initialize() {

        categoryComboBox.setOnAction(event -> {

            setCategoryError(false);
            setSubcategoryError(false);

            Category selectedCategory =
                    categoryComboBox.getValue();

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

    public void setCategories(List<CategoryDetailsResponse> categories) {

        this.categories = categories;

        categoryComboBox.getItems().clear();

        for (CategoryDetailsResponse category : categories) {

            Category uiCategory =
                    new Category(
                            category.getName(),
                            new ArrayList<>()
                    );

            for (CategorySummaryResponse child
                    : category.getChildren()) {

                uiCategory.getSubcategories().add(

                        new Subcategory(
                                child.getId(),
                                child.getName()
                        )

                );

            }

            categoryComboBox.getItems().add(uiCategory);

        }

    }

    public Category getSelectedCategory() {

        return categoryComboBox.getValue();

    }

    public Subcategory getSelectedSubcategory() {

        return subcategoryComboBox.getValue();

    }

    public void setOnSubcategorySelected(
            Consumer<Subcategory> listener
    ) {

        this.subcategorySelectedListener = listener;

    }

    public void setCategoryError(boolean error) {

        if (error) {

            categoryComboBox.setStyle("""
                    -fx-border-color:#e53935;
                    -fx-border-width:2;
                    -fx-border-radius:8;
                    """);

        }

        else {

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

        }

        else {

            subcategoryComboBox.setStyle("");

        }

    }

    public void selectCategory(Long subcategoryId) {

        for (Category category : categoryComboBox.getItems()) {

            for (Subcategory subcategory : category.getSubcategories()) {

                if (subcategory.getId().equals(subcategoryId)) {

                    categoryComboBox.setValue(category);

                    subcategoryComboBox.getItems().setAll(
                            category.getSubcategories()
                    );

                    subcategoryComboBox.setValue(subcategory);

                    if (subcategorySelectedListener != null) {

                        subcategorySelectedListener.accept(subcategory);

                    }

                    return;

                }

            }

        }

    }

}