package com.secondhand.backend.mapper.interfaces;

import com.secondhand.backend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.backend.dto.conversation.response.ConversationSummaryResponse;
import com.secondhand.backend.dto.message.response.MessageResponse;
import com.secondhand.backend.entity.Conversation;
import com.secondhand.backend.entity.User;
import org.springframework.data.domain.Page;

public interface ConversationMapper {

    ConversationSummaryResponse toSummaryResponse(
            Conversation conversation,
            User currentUser,
            String lastMessage,
            boolean hasUnreadMessages
    );

    ConversationDetailsResponse toDetailsResponse(
            Conversation conversation,
            Page<MessageResponse> messages
    );

}