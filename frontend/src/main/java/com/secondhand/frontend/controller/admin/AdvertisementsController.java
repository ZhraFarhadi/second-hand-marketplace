package com.secondhand.frontend.controller.admin;

import com.secondhand.frontend.dto.admin.response.AdminAdvertisementSummaryResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdminRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.Button;
import java.math.BigDecimal;
import java.util.List;

public class AdvertisementsController {

    @FXML
    private TableView<AdminAdvertisementSummaryResponse> advertisementsTable;

    @FXML
    private TableColumn<AdminAdvertisementSummaryResponse, Long> idColumn;

    @FXML
    private TableColumn<AdminAdvertisementSummaryResponse, String> titleColumn;

    @FXML
    private TableColumn<AdminAdvertisementSummaryResponse, String> sellerColumn;

    @FXML
    private TableColumn<AdminAdvertisementSummaryResponse, String> categoryColumn;

    @FXML
    private TableColumn<AdminAdvertisementSummaryResponse, String> cityColumn;

    @FXML
    private TableColumn<AdminAdvertisementSummaryResponse, String> statusColumn;

    private final AdminRepository repository =
            new AdminRepository();


    @FXML
    private TableColumn<AdminAdvertisementSummaryResponse, BigDecimal> priceColumn;

    @FXML
    private TableColumn<AdminAdvertisementSummaryResponse, Void> actionColumn;

    @FXML
    public void initialize() {

        configureTable();

        configureActions();

        loadAdvertisements();

    }

    private void configureTable() {


        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        sellerColumn.setCellValueFactory(new PropertyValueFactory<>("sellerUsername"));

        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

        cityColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));

        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        priceColumn.setCellValueFactory(
                new PropertyValueFactory<>("price")
        );

        titleColumn.setPrefWidth(280);

        sellerColumn.setPrefWidth(170);

        categoryColumn.setPrefWidth(150);

        cityColumn.setPrefWidth(140);

        priceColumn.setPrefWidth(130);

        statusColumn.setPrefWidth(120);

        actionColumn.setPrefWidth(120);

    }

    private void loadAdvertisements() {

        try {

            List<AdminAdvertisementSummaryResponse> ads =
                    repository.getPendingAdvertisements(0, 100);

            System.out.println("ADS SIZE = " + ads.size());

            for (AdminAdvertisementSummaryResponse ad : ads) {

                System.out.println(
                        ad.getId() + "  " + ad.getTitle()
                );

            }

            advertisementsTable.setItems(
                    FXCollections.observableArrayList(ads)
            );

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void goDashboard() {

        NavigationManager.showDashboard();

    }

    private void configureActions() {

        actionColumn.setCellFactory(column -> new TableCell<>() {

            private final Button button = new Button("Review");

            {

                button.setOnAction(event -> {

                    AdminAdvertisementSummaryResponse advertisement =
                            getTableView().getItems().get(getIndex());

                    NavigationManager.showAdvertisementReview(
                            advertisement.getId()
                    );

                });

            }

            @Override
            protected void updateItem(Void item, boolean empty) {

                super.updateItem(item, empty);

                if (empty) {

                    setGraphic(null);

                }

                else {

                    setGraphic(button);

                }

            }

        });

    }
}