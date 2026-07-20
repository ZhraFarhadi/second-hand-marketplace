package com.secondhand.frontend.controller.home;

import com.secondhand.frontend.dto.category.response.CategoryDetailsResponse;
import com.secondhand.frontend.dto.category.response.CategorySummaryResponse;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class CategoryItemController {

    @FXML
    private Button categoryButton;

    @FXML
    private VBox subcategoryContainer;

    private boolean expanded = false;

    @FXML
    private void toggleCategory() {

        expanded = !expanded;

        subcategoryContainer.setVisible(expanded);
        subcategoryContainer.setManaged(expanded);

    }

    public void setCategory(CategoryDetailsResponse category) {

        categoryButton.setText(category.getName() + " ▼");

        subcategoryContainer.getChildren().clear();

        if (category.getChildren() == null)
            return;

        for (CategorySummaryResponse child : category.getChildren()) {

            Button button = new Button(child.getName());

            button.setMaxWidth(Double.MAX_VALUE);

            button.getStyleClass().add("subcategory-button");

            // بعداً اینجا فیلتر بر اساس categoryId انجام می‌شود
            button.setUserData(child.getId());

            subcategoryContainer.getChildren().add(button);

        }

    }

}