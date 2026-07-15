package com.secondhand.frontend.controller.home;

import com.secondhand.frontend.model.Category;
import com.secondhand.frontend.model.Subcategory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    public void setCategory(Category category) {

        categoryButton.setText(category.getName() + " ▼");

        subcategoryContainer.getChildren().clear();

        for (Subcategory sub : category.getSubcategories()) {

            Button button = new Button(sub.getName());

            button.setMaxWidth(Double.MAX_VALUE);

            button.getStyleClass().add("subcategory-button");

            subcategoryContainer.getChildren().add(button);

        }

    }

}