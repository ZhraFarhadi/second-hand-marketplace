package com.secondhand.frontend.controller.advertisement.components;

import com.secondhand.frontend.dto.category.response.CategoryDetailsResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;
import com.secondhand.frontend.model.Category;
import com.secondhand.frontend.model.Subcategory;
import com.secondhand.frontend.repository.CategoryRepository;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import com.secondhand.frontend.dto.category.response.CategoryDetailsResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CategorySelectorController {

    @FXML
    private ComboBox<Category> categoryComboBox;

    @FXML
    private ComboBox<Subcategory> subcategoryComboBox;

    private Consumer<Subcategory> subcategorySelectedListener;



    @FXML
    public void initialize() {

        categoryComboBox.setOnAction(event -> {

            setCategoryError(false);
            setSubcategoryError(false);

            Category selectedCategory = categoryComboBox.getValue();

            subcategoryComboBox.getItems().clear();

            if (selectedCategory == null)
                return;

            try {

                var children =
                        CategoryRepository
                                .getInstance()
                                .getChildren(selectedCategory.getId());

                for (var child : children) {

                    subcategoryComboBox.getItems().add(

                            new Subcategory(
                                    child.getId(),
                                    child.getName()
                            )

                    );

                }

            }

            catch (Exception e) {

                e.printStackTrace();

            }

        });
        subcategoryComboBox.setOnAction(event -> {

            Subcategory selectedSubcategory = subcategoryComboBox.getValue();

            if (selectedSubcategory != null && subcategorySelectedListener != null) {

                System.out.println("SUBCATEGORY SELECTED = " + selectedSubcategory.getName());

                subcategorySelectedListener.accept(selectedSubcategory);

            }

        });

    }

    public void setCategories(List<CategorySummaryResponse> categories) {

        categoryComboBox.getItems().clear();

        for (CategorySummaryResponse category : categories) {

            Category uiCategory =
                    new Category(
                            category.getId(),
                            category.getName(),
                            new ArrayList<>()
                    );

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

        try {

            CategoryDetailsResponse subDetails =
                    CategoryRepository.getInstance().getCategory(subcategoryId);

            if (subDetails == null || subDetails.getParentId() == null)
                return;

            Long parentId = subDetails.getParentId();

            for (Category category : categoryComboBox.getItems()) {

                if (category.getId().equals(parentId)) {

                    categoryComboBox.setValue(category);

                    var children =
                            CategoryRepository.getInstance()
                                    .getChildren(category.getId());

                    subcategoryComboBox.getItems().clear();

                    for (var child : children) {

                        subcategoryComboBox.getItems().add(
                                new Subcategory(child.getId(), child.getName())
                        );

                    }

                    for (Subcategory sub : subcategoryComboBox.getItems()) {

                        if (sub.getId().equals(subcategoryId)) {

                            subcategoryComboBox.setValue(sub);

                            if (subcategorySelectedListener != null) {

                                subcategorySelectedListener.accept(sub);

                            }

                            break;

                        }

                    }

                    return;

                }

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }
}
