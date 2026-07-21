package com.secondhand.frontend.repository;

import com.secondhand.frontend.dto.common.PageResponse;
import com.secondhand.frontend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.frontend.dto.conversation.response.ConversationSummaryResponse;
import com.secondhand.frontend.service.ConversationService;

public class ConversationRepository {

    private final ConversationService service =
            new ConversationService();

    public ConversationDetailsResponse startConversation(
            Long advertisementId
    ){

        return service.startConversation(
                advertisementId
        );

    }

    public ConversationDetailsResponse getConversation(
            Long conversationId,
            int page,
            int size
    ){

        return service.getConversation(
                conversationId,
                page,
                size
        );

    }

    public PageResponse<ConversationSummaryResponse> getMyConversations(
            int page,
            int size
    ){

        return service.getMyConversations(
                page,
                size
        );

    }

}