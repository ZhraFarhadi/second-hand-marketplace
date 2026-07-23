package com.secondhand.frontend.controller.admin;

import com.secondhand.frontend.dto.admin.response.AdminUserDetailsResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdminRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class UserDetailsController {

    @FXML
    private Label fullNameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label roleLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label ratingLabel;

    @FXML
    private Label createdAtLabel;

    @FXML
    private Button blockButton;

    private Long userId;

    private boolean blocked;

    private final AdminRepository repository =
            new AdminRepository();

    public void setUserId(Long id){

        userId = id;

        loadUser();

    }

    private void loadUser(){

        try{

            AdminUserDetailsResponse user =
                    repository.getUser(userId);

            fullNameLabel.setText(user.getFullName());
            usernameLabel.setText(user.getUsername());
            emailLabel.setText(user.getEmail());
            phoneLabel.setText(user.getPhoneNumber());
            roleLabel.setText(user.getRole());
            statusLabel.setText(user.getAccountStatus());

            ratingLabel.setText(
                    user.getAverageRating()
                            + " ("
                            + user.getRatingCount()
                            + ")"
            );

            createdAtLabel.setText(
                    String.valueOf(user.getCreatedAt())
            );

            blocked =
                    !"ACTIVE".equals(user.getAccountStatus());

            updateButton();

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }

    private void updateButton(){

        if(blocked){

            blockButton.setText("Unblock");

        }else{

            blockButton.setText("Block");

        }

    }

    @FXML
    private void toggleBlock(){

        try{

            if(blocked){

                repository.unblockUser(userId);

            }else{

                repository.blockUser(userId);

            }

            blocked = !blocked;

            updateButton();

            loadUser();

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }

    @FXML
    private void goBack(){

        NavigationManager.showUsers();

    }

}