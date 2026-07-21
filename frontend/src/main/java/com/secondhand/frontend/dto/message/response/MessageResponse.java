package com.secondhand.frontend.dto.message.response;

import java.time.LocalDateTime;

public class MessageResponse {

    private Long id;

    private Long senderId;

    private String content;

    private LocalDateTime createdAt;

    private boolean mine;

    public MessageResponse() {
    }

    public MessageResponse(
            Long id,
            Long senderId,
            String content,
            LocalDateTime createdAt,
            boolean mine
    ) {
        this.id = id;
        this.senderId = senderId;
        this.content = content;
        this.createdAt = createdAt;
        this.mine = mine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

}