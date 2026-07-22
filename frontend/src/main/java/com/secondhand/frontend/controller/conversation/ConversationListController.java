package com.secondhand.frontend.controller.conversation;

import com.secondhand.frontend.controller.components.HeaderController;
import com.secondhand.frontend.dto.common.PageResponse;
import com.secondhand.frontend.dto.conversation.response.ConversationSummaryResponse;
import com.secondhand.frontend.navigation.NavigationManager;
import com.secondhand.frontend.repository.ConversationRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

public class ConversationListController {

    @FXML
    private VBox conversationsContainer;

    private final ConversationRepository repository =
            new ConversationRepository();

    @FXML
    public void initialize() {

        loadConversations();

    }

    private void loadConversations() {

        conversationsContainer.getChildren().clear();

        PageResponse<ConversationSummaryResponse> page =

                repository.getMyConversations(
                        0,
                        20
                );

        page.getContent().forEach(conversation -> {

            try {

                FXMLLoader loader =
                        new FXMLLoader(
                                getClass().getResource(
                                        "/view/conversation/conversation-item.fxml"
                                )
                        );

                VBox node =
                        loader.load();

                ConversationItemController controller =
                        loader.getController();

                controller.setConversation(
                        conversation
                );

                conversationsContainer
                        .getChildren()
                        .add(node);

            }

            catch (Exception e) {

                e.printStackTrace();

            }

        });

    }

    @FXML
    private HeaderController headerController;

    public void setBackVisible(boolean visible) {

        headerController.setBackVisible(visible);

    }

}