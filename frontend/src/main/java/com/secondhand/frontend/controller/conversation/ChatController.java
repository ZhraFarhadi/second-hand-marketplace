package com.secondhand.frontend.controller.conversation;

import com.secondhand.frontend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.ConversationRepository;
import com.secondhand.frontend.repository.MessageRepository;
import com.secondhand.frontend.session.SessionManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class ChatController {

    @FXML
    private Label userNameLabel;

    @FXML
    private VBox messagesContainer;

    @FXML
    private TextField messageField;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Label advertisementTitleLabel;

    private Long conversationId;

    private Long advertisementId;

    private final ConversationRepository conversationRepository =
            new ConversationRepository();

    private final MessageRepository messageRepository =
            new MessageRepository();

    @FXML
    private Label avatarLabel;




    private Runnable onBack;

    public void setOnBack(Runnable onBack) {
        this.onBack = onBack;
    }



    @FXML
    private void onBackClicked() {

        if (onBack != null) {

            onBack.run();

        } else {

            NavigationManager.showConversationList();

        }

    }

    public void setConversationId(
            Long conversationId
    ){

        this.conversationId = conversationId;

        loadConversation();

    }

    private void loadConversation() {

        ConversationDetailsResponse conversation =
                conversationRepository.getConversation(
                        conversationId,
                        0,
                        30
                );

        advertisementTitleLabel.setText(
                conversation
                        .getAdvertisement()
                        .getTitle()
        );

        advertisementId = conversation.getAdvertisement().getId();
        if (conversation.getBuyer().getId().equals(SessionManager.getUserId())) {

            userNameLabel.setText(
                    conversation.getSeller().getFullName()
            );

        } else {

            userNameLabel.setText(
                    conversation.getBuyer().getFullName()
            );

        }

        avatarLabel.setText(
                userNameLabel.getText() != null && !userNameLabel.getText().isBlank()
                        ? userNameLabel.getText().substring(0, 1)
                        : "👤"
        );

        showMessages(conversation);

    }

    @FXML
    private void sendMessage(){

        String text =
                messageField.getText();

        if(text == null || text.isBlank()){

            return;

        }

        messageRepository.sendMessage(
                conversationId,
                text
        );

        messageField.clear();

        loadConversation();

    }

    private void showMessages(
            ConversationDetailsResponse conversation
    ){

        messagesContainer.getChildren().clear();

        conversation.getMessages()
                .getContent()
                .forEach(message -> {

                    try{

                        FXMLLoader loader =
                                new FXMLLoader(
                                        getClass().getResource(
                                                "/view/conversation/message-bubble.fxml"
                                        )
                                );

                        HBox node =
                                loader.load();

                        MessageBubbleController controller =
                                loader.getController();

                        controller.setMessage(
                                message
                        );

                        messagesContainer
                                .getChildren()
                                .add(node);

                    }

                    catch(Exception e){

                        e.printStackTrace();

                    }

                });

        scrollPane.layout();

        scrollPane.setVvalue(1.0);

    }

    @FXML
    private void onAdvertisementTitleClicked() {

        if (advertisementId == null)
            return;

        NavigationManager.showAdvertisementDetails(advertisementId);

    }

}