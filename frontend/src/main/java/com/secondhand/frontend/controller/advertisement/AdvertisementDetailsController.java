package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.dto.advertisement.response.AdvertisementAttributeResponse;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementDetailsResponse;
import com.secondhand.frontend.dto.advertisement.response.AdvertisementImageResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.AdvertisementRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import com.secondhand.frontend.util.RelativeTimeUtil;
import com.secondhand.frontend.repository.FavoriteRepository;
import com.secondhand.frontend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.frontend.repository.ConversationRepository;
import com.secondhand.frontend.repository.RatingRepository;
import com.secondhand.frontend.dto.rating.response.SellerProfileResponse;
import com.secondhand.frontend.dto.rating.response.SellerRatingResponse;
import com.secondhand.frontend.session.SessionManager;
import com.secondhand.frontend.exception.ApiException;
import javafx.util.Pair;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.List;
public class AdvertisementDetailsController {

    @FXML
    private ImageView mainImageView;

    @FXML
    private HBox thumbnailContainer;

    @FXML
    private VBox attributesContainer;

    @FXML
    private Label titleLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label sellerNameLabel;

    @FXML
    private Label sellerRateLabel;

    private Long advertisementId;

    @FXML
    private Label favoriteButton;


    @FXML
    private Label sellerStarsLabel;


    @FXML
    private Button rateSellerButton;

    @FXML
    private Button sellerProfileButton;

    private final RatingRepository ratingRepository =
            RatingRepository.getInstance();

    private Long sellerId;

    private StackPane selectedThumbnail;

    private final FavoriteRepository favoriteRepository =
            new FavoriteRepository();

    private Runnable onBack = NavigationManager::showHome;

    @FXML
    private Button chatButton;

    private final ConversationRepository conversationRepository =
            new ConversationRepository();

    @FXML
    public void initialize() {


        favoriteButton.setOnMouseClicked(e -> {

            favoriteClicked();

        });
        // منتظر loadAdvertisement می‌مانیم
    }


    public void loadAdvertisement(Long advertisementId) {

        this.advertisementId = advertisementId;

        try {

            AdvertisementDetailsResponse advertisement =
                    AdvertisementRepository
                            .getInstance()
                            .getAdvertisement(advertisementId);

            showAdvertisement(advertisement);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    private void showAdvertisement(
            AdvertisementDetailsResponse advertisement
    ) {

        titleLabel.setText(advertisement.getTitle());

        priceLabel.setText(
                advertisement.getPrice().toPlainString()
        );

        cityLabel.setText(
                advertisement.getCity().getName()
        );

        descriptionLabel.setText(
                advertisement.getDescription()
        );

        sellerNameLabel.setText(
                advertisement.getSeller().getFullName()
        );

        sellerId = advertisement.getSeller().getId();

        loadSellerRatingSummary();

        boolean isBuyerOfThisAd =
                advertisement.getBuyer() != null
                        && SessionManager.isLoggedIn()
                        && advertisement.getBuyer().getId().equals(
                        SessionManager.getUserId()
                );

        boolean canRate =
                !advertisement.isOwner()
                        && isBuyerOfThisAd
                        && "SOLD".equals(advertisement.getStatus());

        rateSellerButton.setVisible(canRate);
        rateSellerButton.setManaged(canRate);

        timeLabel.setText(
                RelativeTimeUtil.format(
                        advertisement.getCreatedAt()
                )
        );
        favorite = advertisement.isFavorite();

        updateFavoriteIcon();

        if (advertisement.isOwner()) {
            favoriteButton.setVisible(false);
            favoriteButton.setManaged(false);
            chatButton.setVisible(false);
            chatButton.setManaged(false);
        } else {
            favoriteButton.setVisible(true);
            favoriteButton.setManaged(true);
            chatButton.setVisible(true);
            chatButton.setManaged(true);
        }


        loadImages(advertisement);

        loadAttributes(advertisement);

    }

    private void loadSellerRatingSummary() {

        try {

            SellerProfileResponse profile =
                    ratingRepository.getSellerProfile(sellerId);

            double average =
                    profile.getAverageRating() != null
                            ? profile.getAverageRating()
                            : 0.0;

            long count =
                    profile.getRatingCount() != null
                            ? profile.getRatingCount()
                            : 0;

            sellerStarsLabel.setText(
                    buildStars(average)
            );

            sellerRateLabel.setText(
                    String.format("%.1f (%d نظر)", average, count)
            );

        }

        catch (Exception e) {

            e.printStackTrace();

            sellerStarsLabel.setText("—");
            sellerRateLabel.setText("بدون امتیاز");

        }

    }

    private String buildStars(double average) {

        int fullStars =
                (int) Math.round(average);

        StringBuilder stars = new StringBuilder();

        for (int i = 1; i <= 5; i++) {

            stars.append(
                    i <= fullStars ? "⭐" : "☆"
            );

        }

        return stars.toString();

    }

    @FXML
    private void onRateSellerClicked() {

        if (!com.secondhand.frontend.util.AuthGuard.requireLogin())
            return;

        Dialog<Pair<Integer, String>> dialog = new Dialog<>();

        dialog.setTitle("امتیازدهی به فروشنده");
        dialog.setHeaderText(null);

        ButtonType submitButtonType =
                new ButtonType("ثبت امتیاز", ButtonBar.ButtonData.OK_DONE);

        dialog.getDialogPane().getButtonTypes().addAll(
                submitButtonType,
                ButtonType.CANCEL
        );

        ComboBox<Integer> scoreBox = new ComboBox<>();
        scoreBox.getItems().addAll(1, 2, 3, 4, 5);
        scoreBox.setValue(5);

        TextArea commentField = new TextArea();
        commentField.setPromptText("نظر شما (اختیاری)...");
        commentField.setPrefRowCount(4);
        commentField.setWrapText(true);

        VBox content = new VBox(12);
        content.setPadding(new Insets(15));
        content.getChildren().addAll(
                new Label("امتیاز (۱ تا ۵):"),
                scoreBox,
                new Label("نظر:"),
                commentField
        );

        dialog.getDialogPane().setContent(content);

        dialog.setResultConverter(buttonType -> {

            if (buttonType == submitButtonType) {

                return new Pair<>(
                        scoreBox.getValue(),
                        commentField.getText()
                );

            }

            return null;

        });

        dialog.showAndWait().ifPresent(result -> {

            try {

                ratingRepository.createRating(
                        advertisementId,
                        result.getKey(),
                        result.getValue().isBlank() ? null : result.getValue()
                );

                new Alert(
                        Alert.AlertType.INFORMATION,
                        "امتیاز شما با موفقیت ثبت شد."
                ).showAndWait();

                rateSellerButton.setVisible(false);
                rateSellerButton.setManaged(false);

                loadSellerRatingSummary();

            }

            catch (Exception e) {

                e.printStackTrace();

                String message =
                        e instanceof ApiException
                                ? e.getMessage()
                                : "ثبت امتیاز با خطا مواجه شد.";

                new Alert(
                        Alert.AlertType.ERROR,
                        message
                ).showAndWait();

            }

        });

    }

    @FXML
    private void onViewSellerProfileClicked() {

        try {

            List<SellerRatingResponse> ratings =
                    ratingRepository.getSellerRatings(sellerId, 0, 20);

            VBox listBox = new VBox(12);
            listBox.setPadding(new Insets(15));

            if (ratings.isEmpty()) {

                listBox.getChildren().add(
                        new Label("هنوز نظری برای این فروشنده ثبت نشده است.")
                );

            }

            for (SellerRatingResponse rating : ratings) {

                VBox item = new VBox(4);

                Label header = new Label(
                        buildStars(rating.getScore())
                                + "   —   "
                                + (rating.getReviewer() != null
                                ? rating.getReviewer().getUsername()
                                : "کاربر")
                );

                item.getChildren().add(header);

                if (rating.getComment() != null
                        && !rating.getComment().isBlank()) {

                    Label comment = new Label(rating.getComment());
                    comment.setWrapText(true);
                    item.getChildren().add(comment);

                }

                listBox.getChildren().add(item);
                listBox.getChildren().add(new Separator());

            }

            ScrollPane scrollPane = new ScrollPane(listBox);
            scrollPane.setFitToWidth(true);
            scrollPane.setPrefHeight(400);
            scrollPane.setPrefWidth(450);

            Dialog<Void> dialog = new Dialog<>();
            dialog.setTitle("نظرات فروشنده");
            dialog.setHeaderText(null);
            dialog.getDialogPane().setContent(scrollPane);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

            dialog.showAndWait();

        }

        catch (Exception e) {

            e.printStackTrace();

            new Alert(
                    Alert.AlertType.ERROR,
                    "امکان بارگذاری نظرات فروشنده وجود ندارد."
            ).showAndWait();

        }

    }

    private void loadImages(
            AdvertisementDetailsResponse advertisement
    ) {

        thumbnailContainer.getChildren().clear();

        if (advertisement.getImages() == null
                || advertisement.getImages().isEmpty()) {

            mainImageView.setImage(null);
            return;

        }

        AdvertisementImageResponse primaryImage =
                advertisement.getImages()
                        .stream()
                        .filter(AdvertisementImageResponse::isPrimary)
                        .findFirst()
                        .orElse(advertisement.getImages().get(0));

        Image mainImage =
                new Image(primaryImage.getImageUrl(), true);

        mainImageView.setImage(mainImage);

        for (AdvertisementImageResponse imageResponse
                : advertisement.getImages()) {

            Image image =
                    new Image(imageResponse.getImageUrl(), true);

            ImageView thumbnail =
                    new ImageView(image);

            thumbnail.setFitWidth(90);
            thumbnail.setFitHeight(90);
            thumbnail.setPreserveRatio(true);

            StackPane pane =
                    new StackPane(thumbnail);

            pane.getStyleClass().add("thumbnail");

            pane.setOnMouseClicked(event -> {

                mainImageView.setImage(image);

                if (selectedThumbnail != null) {

                    selectedThumbnail.getStyleClass()
                            .remove("thumbnail-selected");

                }

                pane.getStyleClass()
                        .add("thumbnail-selected");

                selectedThumbnail = pane;

            });

            thumbnailContainer.getChildren().add(pane);

        }

        selectedThumbnail =
                (StackPane) thumbnailContainer.getChildren().get(0);

        selectedThumbnail.getStyleClass()
                .add("thumbnail-selected");

    }

    private void loadAttributes(
            AdvertisementDetailsResponse advertisement
    ) {

        attributesContainer.getChildren().clear();

        if (advertisement.getAttributes() == null) {
            return;
        }

        for (AdvertisementAttributeResponse attribute
                : advertisement.getAttributes()) {

            HBox row = new HBox(15);

            Label key =
                    new Label(attribute.getAttributeName());

            key.getStyleClass().add("attribute-name");

            Label value =
                    new Label(attribute.getValue());

            value.getStyleClass().add("attribute-value");

            Region spacer = new Region();

            HBox.setHgrow(
                    spacer,
                    Priority.ALWAYS
            );

            row.getChildren().addAll(
                    key,
                    spacer,
                    value
            );

            attributesContainer.getChildren().add(row);

        }

    }

    private boolean favorite;

    private void updateFavoriteIcon() {

        if (favorite) {

            favoriteButton.setText("♥");

            favoriteButton.getStyleClass().add(
                    "favorite-heart-active"
            );

        } else {

            favoriteButton.setText("♡");

            favoriteButton.getStyleClass().remove(
                    "favorite-heart-active"
            );

        }

    }

    @FXML
    private void favoriteClicked() {

        if (advertisementId == null)
            return;

        try {

            favoriteRepository.toggleFavorite(
                    advertisementId
            );

            favorite = !favorite;

            updateFavoriteIcon();

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

    @FXML
    private void onChatClicked() {


        if (!com.secondhand.frontend.util.AuthGuard.requireLogin())
            return;

        if (advertisementId == null)
            return;

        try {

            ConversationDetailsResponse conversation =
                    conversationRepository.startConversation(advertisementId);

            NavigationManager.showConversation(
                    conversation.getId(),
                    () -> NavigationManager.showAdvertisementDetails(advertisementId)
            );

        } catch (Exception e) {

            e.printStackTrace();

            String message =
                    (e.getCause() != null && e.getCause().getMessage() != null)
                            ? e.getCause().getMessage()
                            : e.getMessage();

            new Alert(
                    Alert.AlertType.ERROR,
                    message != null ? message : "امکان شروع گفت‌وگو وجود ندارد."
            ).showAndWait();

        }

    }

    @FXML
    private void onBackClicked() {
        onBack.run();
    }

    public void setOnBack(Runnable onBack) {

        this.onBack = onBack != null
                ? onBack
                : NavigationManager::showHome;

    }

}