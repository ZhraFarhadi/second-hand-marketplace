package com.secondhand.frontend.controller.home;

import com.secondhand.frontend.dto.category.response.CategoryDetailsResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;
import com.secondhand.frontend.repository.CategoryRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.function.BiConsumer;

public class CategoryItemController {

    @FXML
    private Button categoryButton;

    @FXML
    private VBox subcategoryContainer;

    private boolean expanded = false;

    private BiConsumer<Long, Button> onSubcategorySelected;

    @FXML
    private void toggleCategory() {

        expanded = !expanded;

        subcategoryContainer.setVisible(expanded);
        subcategoryContainer.setManaged(expanded);

        if (!expanded)
            return;

        if (!subcategoryContainer.getChildren().isEmpty())
            return;

        Long categoryId = (Long) categoryButton.getUserData();

        try {

            var children =
                    CategoryRepository
                            .getInstance()
                            .getChildren(categoryId);

            for (var child : children) {

                Button button = new Button(child.getName());

                button.setMaxWidth(Double.MAX_VALUE);

                button.getStyleClass().add("subcategory-button");

                button.setUserData(child.getId());

                button.setOnAction(event ->
                        onSubcategorySelected.accept(child.getId(), button)
                );

                subcategoryContainer.getChildren().add(button);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void setCategory(
            CategorySummaryResponse category,
            BiConsumer<Long, Button> onSubcategorySelected
    ) {

        this.onSubcategorySelected = onSubcategorySelected;

        categoryButton.setText(category.getName() + " ▼");

        categoryButton.setUserData(category.getId());

        subcategoryContainer.getChildren().clear();

    }

}