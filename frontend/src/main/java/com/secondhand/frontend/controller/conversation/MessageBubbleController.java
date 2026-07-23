package com.secondhand.frontend.controller.conversation;

import com.secondhand.frontend.dto.message.response.MessageResponse;
import com.secondhand.frontend.util.RelativeTimeUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class MessageBubbleController {

    @FXML
    private VBox bubble;

    @FXML
    private Label contentLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Region leftSpacer;

    @FXML
    private Region rightSpacer;

    public void setMessage(
            MessageResponse message
    ) {

        contentLabel.setText(
                message.getContent()
        );

        timeLabel.setText(
                RelativeTimeUtil.format(
                        message.getCreatedAt()
                )
        );

        if (message.isMine()) {

            bubble.getStyleClass().add(
                    "my-message"
            );

            leftSpacer.setVisible(true);
            leftSpacer.setManaged(true);

            rightSpacer.setVisible(false);
            rightSpacer.setManaged(false);

        } else {

            bubble.getStyleClass().add(
                    "other-message"
            );

            rightSpacer.setVisible(true);
            rightSpacer.setManaged(true);

            leftSpacer.setVisible(false);
            leftSpacer.setManaged(false);

        }

    }

}