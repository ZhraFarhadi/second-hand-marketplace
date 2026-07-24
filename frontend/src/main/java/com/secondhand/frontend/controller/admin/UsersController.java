package com.secondhand.frontend.controller.admin;

import com.secondhand.frontend.dto.admin.response.AdminUserSummaryResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdminRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class UsersController {

    @FXML
    private TableView<AdminUserSummaryResponse> usersTable;

    @FXML
    private TableColumn<AdminUserSummaryResponse, Long> idColumn;

    @FXML
    private TableColumn<AdminUserSummaryResponse, String> usernameColumn;

    @FXML
    private TableColumn<AdminUserSummaryResponse, String> fullNameColumn;

    @FXML
    private TableColumn<AdminUserSummaryResponse, String> emailColumn;

    @FXML
    private TableColumn<AdminUserSummaryResponse, String> roleColumn;

    @FXML
    private TableColumn<AdminUserSummaryResponse, String> statusColumn;

    @FXML
    private TableColumn<AdminUserSummaryResponse, Double> ratingColumn;

    @FXML
    private TableColumn<AdminUserSummaryResponse, Void> actionColumn;

    private final AdminRepository repository =
            new AdminRepository();


    @FXML
    private TableColumn<AdminUserSummaryResponse, Void> detailsColumn;

    @FXML
    public void initialize() {

        configureTable();

        configureActions();

        loadUsers();

        usersTable.setRowFactory(tv -> {

            TableRow<AdminUserSummaryResponse> row =
                    new TableRow<>();

            row.setOnMouseClicked(e -> {

                if(!row.isEmpty()){

                    NavigationManager.showUserDetails(
                            row.getItem().getId()
                    );

                }

            });

            return row;

        });

        configureActions();


    }

    private void configureTable() {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));

        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));

        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        statusColumn.setCellValueFactory(new PropertyValueFactory<>("accountStatus"));

        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("averageRating"));

    }

    private void loadUsers() {

        try {

            List<AdminUserSummaryResponse> users =
                    repository.getUsers(0,100);

            usersTable.setItems(
                    FXCollections.observableArrayList(users)
            );

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void goDashboard() {
        NavigationManager.showHome();
    }


    private void configureActions() {

        actionColumn.setCellFactory(column -> new TableCell<>() {

            private final javafx.scene.control.Button button =
                    new javafx.scene.control.Button();

            {

                button.setOnAction(event -> {

                    AdminUserSummaryResponse user =
                            getTableView().getItems().get(getIndex());

                    try {

                        if("ACTIVE".equals(user.getAccountStatus())) {

                            repository.blockUser(user.getId());

                        }

                        else {

                            repository.unblockUser(user.getId());

                        }

                        loadUsers();

                    }

                    catch (Exception e) {

                        e.printStackTrace();

                    }

                });

            }

            @Override
            protected void updateItem(
                    Void item,
                    boolean empty
            ) {

                super.updateItem(item, empty);

                if (empty) {

                    setGraphic(null);

                    return;

                }

                AdminUserSummaryResponse user =
                        getTableView().getItems().get(getIndex());

                if("ACTIVE".equals(user.getAccountStatus())){

                    button.setText("Block");

                }
                else{

                    button.setText("Unblock");

                }

                setGraphic(button);

            }

        });

    }
}