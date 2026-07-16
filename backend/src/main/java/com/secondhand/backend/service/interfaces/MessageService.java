package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.message.request.SendMessageRequest;
import com.secondhand.backend.dto.message.response.MessageResponse;
import com.secondhand.backend.entity.Conversation;
import com.secondhand.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService {

    MessageResponse sendMessage(
            Long conversationId,
            SendMessageRequest request
    );

    Page<MessageResponse> getConversationMessages(
            Conversation conversation,
            User currentUser,
            Pageable pageable
    );

    void markMessagesAsRead(
            Conversation conversation,
            User currentUser
    );

    String getLastMessage(
            Conversation conversation
    );

    boolean hasUnreadMessages(
            Conversation conversation,
            User currentUser
    );

    long getUnreadCount(
            Conversation conversation,
            User currentUser
    );

}