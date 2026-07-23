package com.secondhand.frontend.controller.admin;

import com.secondhand.frontend.dto.admin.response.AdminAdvertisementSummaryResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdminRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    public void initialize() {

        configureTable();

        loadAdvertisements();

    }

    private void configureTable() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        sellerColumn.setCellValueFactory(new PropertyValueFactory<>("sellerUsername"));

        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));

        cityColumn.setCellValueFactory(new PropertyValueFactory<>("cityName"));

        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

    }

    private void loadAdvertisements() {

        try {

            List<AdminAdvertisementSummaryResponse> ads =
                    repository.getPendingAdvertisements(0,100);

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

}