package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.controller.components.HeaderController;
import com.secondhand.frontend.dto.advertisement.response.MyAdvertisementSummaryResponse;
import com.secondhand.frontend.repository.AdvertisementRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.FlowPane;

public class MyAdvertisementsController {

    @FXML
    private FlowPane advertisementsContainer;

    private final AdvertisementRepository repository =
            AdvertisementRepository.getInstance();

    @FXML
    public void initialize() {

        loadAdvertisements();

    }

    private void loadAdvertisements() {

        advertisementsContainer.getChildren().clear();

        try {

            var advertisements =
                    repository.getMyAdvertisements(
                            0,
                            20
                    );

            for (MyAdvertisementSummaryResponse advertisement : advertisements) {

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/view/advertisement/my-advertisement-card.fxml"
                                )
                        );

                Parent card =
                        loader.load();

                MyAdvertisementCardController controller =
                        loader.getController();

                controller.setAdvertisement(
                        advertisement
                );

                advertisementsContainer
                        .getChildren()
                        .add(card);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @FXML
    private HeaderController headerController;

    public void setBackVisible(boolean visible) {

        headerController.setBackVisible(visible);

    }



}