package com.secondhand.frontend.controller.profile;


import com.secondhand.frontend.controller.components.HeaderController;
import com.secondhand.frontend.dto.profile.request.ChangePasswordRequest;
import com.secondhand.frontend.dto.profile.request.UpdateProfileRequest;
import com.secondhand.frontend.dto.profile.response.UserProfileResponse;
import com.secondhand.frontend.exception.ApiException;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.ProfileRepository;
import com.secondhand.frontend.session.SessionManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

    @FXML
    private Label profileMessageLabel;

    @FXML
    private Label passwordMessageLabel;

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

        hideMessage(profileMessageLabel);

        try {

            UpdateProfileRequest request =
                    new UpdateProfileRequest(

                            fullNameField.getText(),

                            emailField.getText(),

                            phoneField.getText()

                    );

            profileRepository.updateProfile(request);

            showMessage(
                    profileMessageLabel,
                    "اطلاعات با موفقیت به‌روزرسانی شد.",
                    true
            );

            loadProfile();

        }

        catch (ApiException e) {

            showMessage(
                    profileMessageLabel,
                    e.getMessage(),
                    false
            );

        }

        catch (Exception e) {

            e.printStackTrace();

            showMessage(
                    profileMessageLabel,
                    "خطای غیرمنتظره‌ای رخ داد.",
                    false
            );

        }

    }

    @FXML
    private void changePassword() {

        hideMessage(passwordMessageLabel);

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

            showMessage(
                    passwordMessageLabel,
                    "رمز عبور با موفقیت تغییر کرد.",
                    true
            );

        }

        catch (ApiException e) {

            showMessage(
                    passwordMessageLabel,
                    e.getMessage(),
                    false
            );

        }

        catch (Exception e) {

            e.printStackTrace();

            showMessage(
                    passwordMessageLabel,
                    "خطای غیرمنتظره‌ای رخ داد.",
                    false
            );

        }

    }

    private void showMessage(
            Label label,
            String message,
            boolean success
    ) {

        label.getStyleClass().removeAll(
                "message-success",
                "message-error"
        );

        label.getStyleClass().add(
                success ? "message-success" : "message-error"
        );

        label.setText(message);

        label.setVisible(true);

        label.setManaged(true);

    }

    private void hideMessage(Label label) {

        label.setVisible(false);

        label.setManaged(false);

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