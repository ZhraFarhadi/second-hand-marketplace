package com.secondhand.frontend.service;

import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.message.request.SendMessageRequest;
import com.secondhand.frontend.dto.message.response.MessageResponse;

import java.lang.reflect.Type;

public class MessageService {

    private static final String BASE =
            "/messages";

    public MessageResponse sendMessage(
            Long conversationId,
            SendMessageRequest request
    ){

        try{

            Type type =
                    new TypeToken<MessageResponse>(){}.getType();

            return ApiClient.post(
                    BASE + "/" + conversationId,
                    request,
                    type
            );

        }

        catch(Exception e){

            throw new RuntimeException(e);

        }

    }

}