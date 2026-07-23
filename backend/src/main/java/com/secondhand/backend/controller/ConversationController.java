package com.secondhand.backend.controller;

import com.secondhand.backend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.backend.dto.conversation.response.ConversationSummaryResponse;
import com.secondhand.backend.service.interfaces.ConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conversations")
@RequiredArgsConstructor
public class ConversationController {

    private final ConversationService conversationService;

    @PostMapping("/start/{advertisementId}")
    public ConversationDetailsResponse startConversation(
            @PathVariable
            Long advertisementId
    ) {

        return conversationService.startConversation(
                advertisementId
        );

    }

    @GetMapping("/{conversationId}")
    public ConversationDetailsResponse getConversation(
            @PathVariable
            Long conversationId,

            @PageableDefault(
                    page = 0,
                    size = 30
            )
            Pageable pageable
    ) {

        return conversationService.getConversation(
                conversationId,
                pageable
        );

    }

    @GetMapping
    public Page<ConversationSummaryResponse> getMyConversations(

            @PageableDefault(
                    page = 0,
                    size = 20
            )
            Pageable pageable

    ) {

        return conversationService.getMyConversations(
                pageable
        );

    }

}
