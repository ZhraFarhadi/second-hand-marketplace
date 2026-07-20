package com.secondhand.frontend.dto.conversation.response;

import com.secondhand.frontend.dto.auth.response.UserSummaryResponse;

import java.time.LocalDateTime;

public class ConversationSummaryResponse {

    private Long id;

    private Long advertisementId;

    private String advertisementTitle;

    private String advertisementPrimaryImage;

    private UserConversationResponse otherUser;

    private String lastMessage;

    private boolean hasUnreadMessages;

    private int unreadCount;

    private LocalDateTime lastMessageTime;

    public ConversationSummaryResponse() {
    }

    public ConversationSummaryResponse(
            Long id,
            Long advertisementId,
            String advertisementTitle,
            String advertisementPrimaryImage,
            UserConversationResponse otherUser,
            String lastMessage,
            boolean hasUnreadMessages,
            int unreadCount,
            LocalDateTime lastMessageTime
    ) {

        this.id = id;
        this.advertisementId = advertisementId;
        this.advertisementTitle = advertisementTitle;
        this.advertisementPrimaryImage = advertisementPrimaryImage;
        this.otherUser = otherUser;
        this.lastMessage = lastMessage;
        this.hasUnreadMessages = hasUnreadMessages;
        this.unreadCount = unreadCount;
        this.lastMessageTime = lastMessageTime;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Long advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getAdvertisementTitle() {
        return advertisementTitle;
    }

    public void setAdvertisementTitle(String advertisementTitle) {
        this.advertisementTitle = advertisementTitle;
    }

    public String getAdvertisementPrimaryImage() {
        return advertisementPrimaryImage;
    }

    public void setAdvertisementPrimaryImage(String advertisementPrimaryImage) {
        this.advertisementPrimaryImage = advertisementPrimaryImage;
    }

    public UserConversationResponse getOtherUser() {
        return otherUser;
    }

    public void setOtherUser(UserConversationResponse otherUser) {
        this.otherUser = otherUser;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public boolean isHasUnreadMessages() {
        return hasUnreadMessages;
    }

    public void setHasUnreadMessages(boolean hasUnreadMessages) {
        this.hasUnreadMessages = hasUnreadMessages;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public LocalDateTime getLastMessageTime() {
        return lastMessageTime;
    }

    public void setLastMessageTime(LocalDateTime lastMessageTime) {
        this.lastMessageTime = lastMessageTime;
    }

}