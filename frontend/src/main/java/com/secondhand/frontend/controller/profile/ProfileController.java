package com.secondhand.frontend.controller.profile;


import com.secondhand.frontend.controller.components.HeaderController;
import com.secondhand.frontend.dto.profile.request.ChangePasswordRequest;
import com.secondhand.frontend.dto.profile.request.UpdateProfileRequest;
import com.secondhand.frontend.dto.profile.response.UserProfileResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.ProfileRepository;
import com.secondhand.frontend.session.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ProfileController {

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField roleField;

    @FXML
    private TextField statusField;

    @FXML
    private PasswordField currentPasswordField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField confirmPasswordField;

    private final ProfileRepository profileRepository =
            new ProfileRepository();

    @FXML
    private HeaderController headerController;

    @FXML
    public void initialize() {

        loadProfile();

    }

    private void loadProfile() {

        try {

            UserProfileResponse user =
                    profileRepository.getProfile();

            fullNameField.setText(user.getFullName());

            usernameField.setText(user.getUsername());

            emailField.setText(user.getEmail());

            phoneField.setText(user.getPhoneNumber());

            roleField.setText(
                    user.getRole().name()
            );

            statusField.setText(
                    user.getAccountStatus().name()
            );

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void saveProfile() {

        try {

            UpdateProfileRequest request =
                    new UpdateProfileRequest(

                            fullNameField.getText(),

                            emailField.getText(),

                            phoneField.getText()

                    );

            UserProfileResponse updated =
                    profileRepository.updateProfile(request);

            loadProfile();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void changePassword() {

        try {

            ChangePasswordRequest request =
                    new ChangePasswordRequest(

                            currentPasswordField.getText(),

                            newPasswordField.getText(),

                            confirmPasswordField.getText()

                    );

            profileRepository.changePassword(request);

            currentPasswordField.clear();

            newPasswordField.clear();

            confirmPasswordField.clear();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void logout() {

        SessionManager.logout();

        NavigationManager.showLogin();

    }

    public void setBackVisible(boolean visible){

        headerController.setBackVisible(visible);

    }

}