package com.secondhand.frontend.service;

import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.common.PageResponse;
import com.secondhand.frontend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.frontend.dto.conversation.response.ConversationSummaryResponse;

import java.lang.reflect.Type;

public class ConversationService {

    private static final String BASE =
            "/conversations";

    public ConversationDetailsResponse startConversation(
            Long advertisementId
    ) {

        try {

            Type type =
                    new TypeToken<ConversationDetailsResponse>() {
                    }.getType();

            return ApiClient.post(
                    BASE + "/start/" + advertisementId,
                    null,
                    type
            );

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public ConversationDetailsResponse getConversation(
            Long conversationId,
            int page,
            int size
    ) {

        try {

            Type type =
                    new TypeToken<ConversationDetailsResponse>() {
                    }.getType();

            return ApiClient.get(
                    BASE + "/" + conversationId +
                            "?page=" + page +
                            "&size=" + size,
                    type
            );

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public PageResponse<ConversationSummaryResponse> getMyConversations(
            int page,
            int size
    ) {

        try {

            Type type =
                    new TypeToken<PageResponse<ConversationSummaryResponse>>() {
                    }.getType();

            return ApiClient.get(
                    BASE +
                            "?page=" + page +
                            "&size=" + size,
                    type
            );

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

}