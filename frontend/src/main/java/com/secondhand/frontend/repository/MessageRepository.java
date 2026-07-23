package com.secondhand.frontend.repository;

import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.dto.message.request.SendMessageRequest;
import com.secondhand.frontend.dto.message.response.MessageResponse;
import com.secondhand.frontend.service.MessageService;

public class MessageRepository {

    private final MessageService service =
            new MessageService();

    public MessageResponse sendMessage(
            Long conversationId,
            String content
    ){

        SendMessageRequest request =
                new SendMessageRequest(
                        content
                );

        return service.sendMessage(
                conversationId,
                request
        );

    }

}