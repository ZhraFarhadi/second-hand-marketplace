package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.frontend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.ConversationRepository;
import com.secondhand.frontend.repository.FavoriteRepository;
import com.secondhand.frontend.util.RelativeTimeUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import com.secondhand.frontend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.frontend.repository.ConversationRepository;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;




public class AdvertisementCardController {

    @FXML
    private VBox root;

    @FXML
    private Label titleLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private ImageView advertisementImageView;



    private AdvertisementSummaryResponse advertisement;

    private Long advertisementId;

    @FXML
    private Label favoriteButton;


    private boolean favorite;



    @FXML
    public void initialize() {

        root.setOnMouseClicked(event -> {

            if (advertisement != null) {

                NavigationManager.showAdvertisementDetails(
                        advertisement.getId()
                );

            }

        });


    }

    public void setAdvertisement(
            AdvertisementSummaryResponse advertisement
    ) {

        this.advertisement = advertisement;

        this.advertisementId = advertisement.getId();

        titleLabel.setText(
                advertisement.getTitle()
        );

        priceLabel.setText(
                advertisement.getPrice().toPlainString() + " تومان"
        );

        cityLabel.setText(advertisement.getCity().getName()
        );

        timeLabel.setText(
                RelativeTimeUtil.format(
                        advertisement.getCreatedAt()
                )
        );

        setFavorite(advertisement.isFavorite());


        if (advertisement.getPrimaryImageUrl() != null
                && !advertisement.getPrimaryImageUrl().isBlank()) {

            advertisementImageView.setImage(
                    new Image(
                            advertisement.getPrimaryImageUrl(),
                            true
                    )
            );

        }

    }

    @FXML
    private void onChatClicked() {

        if (advertisement == null)
            return;

        ConversationRepository repository =
                new ConversationRepository();

        try {

            ConversationDetailsResponse conversation =
                    repository.startConversation(
                            advertisement.getId()
                    );

            NavigationManager.showConversation(
                    conversation.getId()
            );

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }


    public void setFavorite(boolean favorite) {

        this.favorite = favorite;

        updateFavoriteIcon();

    }

    private void updateFavoriteIcon() {

        favoriteButton.setText(
                favorite ? "♥" : "♡"
        );

    }




}