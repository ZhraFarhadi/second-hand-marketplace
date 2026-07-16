package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.backend.dto.conversation.response.ConversationSummaryResponse;
import com.secondhand.backend.dto.message.request.SendMessageRequest;
import com.secondhand.backend.dto.message.response.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConversationService {

    ConversationDetailsResponse startConversation(
            Long advertisementId
    );

    ConversationDetailsResponse getConversation(
            Long conversationId,
            Pageable pageable
    );

    Page<ConversationSummaryResponse> getMyConversations(
            Pageable pageable
    );

}
