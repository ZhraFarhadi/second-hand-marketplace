package com.secondhand.backend.dto.conversation.response;

import com.secondhand.backend.dto.auth.response.UserSummaryResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ConversationSummaryResponse {

    private Long id;

    private Long advertisementId;

    private String advertisementTitle;

    private String advertisementPrimaryImage;

    private UserSummaryResponse otherUser;

    private String lastMessage;

    private boolean unread;

    private LocalDateTime lastMessageTime;

}