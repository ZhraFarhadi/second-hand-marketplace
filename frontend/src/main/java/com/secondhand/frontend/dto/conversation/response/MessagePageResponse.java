package com.secondhand.frontend.dto.conversation.response;

import com.secondhand.frontend.dto.message.response.MessageResponse;

import java.util.List;

public class MessagePageResponse {

    private List<MessageResponse> content;

    public MessagePageResponse() {
    }

    public MessagePageResponse(List<MessageResponse> content) {
        this.content = content;
    }

    public List<MessageResponse> getContent() {
        return content;
    }

    public void setContent(List<MessageResponse> content) {
        this.content = content;
    }

}