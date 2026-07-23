package com.secondhand.frontend.controller.conversation;

import com.secondhand.frontend.dto.conversation.response.ConversationSummaryResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.util.RelativeTimeUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ConversationItemController {

    @FXML
    private VBox root;

    @FXML
    private Label userLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label lastMessageLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label unreadLabel;

    private ConversationSummaryResponse conversation;

    @FXML
    public void initialize() {

        root.setOnMouseClicked(event -> {

            if (conversation != null) {

                NavigationManager.showConversation(
                        conversation.getId()
                );

            }

        });

    }

    public void setConversation(
            ConversationSummaryResponse conversation
    ) {

        this.conversation = conversation;

        userLabel.setText(
                conversation.getOtherUser().getFullName()
        );

        titleLabel.setText(
                conversation.getAdvertisementTitle()
        );

        lastMessageLabel.setText(
                conversation.getLastMessage()
        );

        timeLabel.setText(
                RelativeTimeUtil.format(
                        conversation.getLastMessageTime()
                )
        );

        if (conversation.getUnreadCount() > 0) {

            unreadLabel.setText(
                    String.valueOf(
                            conversation.getUnreadCount()
                    )
            );

        }

        else {

            unreadLabel.setVisible(false);

            unreadLabel.setManaged(false);

        }

    }

}