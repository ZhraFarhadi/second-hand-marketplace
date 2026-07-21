package com.secondhand.frontend.dto.conversation.response;

public class UserConversationResponse {

    private Long id;

    private String fullName;

    public UserConversationResponse() {
    }

    public UserConversationResponse(
            Long id,
            String fullName
    ) {
        this.id = id;
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}