package com.secondhand.frontend.controller.advertisement;

import com.secondhand.frontend.dto.advertisement.response.AdvertisementSummaryResponse;
import com.secondhand.frontend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.ConversationRepository;
import com.secondhand.frontend.util.RelativeTimeUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import com.secondhand.frontend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.frontend.repository.ConversationRepository;




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
    private Button chatButton;

    private AdvertisementSummaryResponse advertisement;

    private final ConversationRepository conversationRepository =
            new ConversationRepository();

    @FXML
    public void initialize() {

        root.setOnMouseClicked(event -> {

            if (advertisement != null) {

                NavigationManager.showAdvertisementDetails(
                        advertisement.getId()
                );

            }

        });

        chatButton.setOnAction(event -> {

            onChatClicked();

            event.consume();

        });

    }

    public void setAdvertisement(
            AdvertisementSummaryResponse advertisement
    ) {

        this.advertisement = advertisement;

        titleLabel.setText(
                advertisement.getTitle()
        );

        priceLabel.setText(
                advertisement.getPrice().toPlainString()
        );

        cityLabel.setText(
                advertisement.getCity().getName()
        );

        timeLabel.setText(
                RelativeTimeUtil.format(
                        advertisement.getCreatedAt()
                )
        );

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

    public void disableChat() {

        chatButton.setVisible(false);

        chatButton.setManaged(false);

    }




}