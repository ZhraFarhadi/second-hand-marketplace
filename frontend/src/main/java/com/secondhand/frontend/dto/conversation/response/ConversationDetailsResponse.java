package com.secondhand.frontend.dto.conversation.response;

public class ConversationDetailsResponse {

    private Long id;

    private UserConversationResponse buyer;

    private UserConversationResponse seller;

    private AdvertisementConversationResponse advertisement;

    private MessagePageResponse messages;

    public ConversationDetailsResponse() {
    }

    public ConversationDetailsResponse(
            Long id,
            UserConversationResponse buyer,
            UserConversationResponse seller,
            AdvertisementConversationResponse advertisement,
            MessagePageResponse messages
    ) {

        this.id = id;
        this.buyer = buyer;
        this.seller = seller;
        this.advertisement = advertisement;
        this.messages = messages;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserConversationResponse getBuyer() {
        return buyer;
    }

    public void setBuyer(UserConversationResponse buyer) {
        this.buyer = buyer;
    }

    public UserConversationResponse getSeller() {
        return seller;
    }

    public void setSeller(UserConversationResponse seller) {
        this.seller = seller;
    }

    public AdvertisementConversationResponse getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(
            AdvertisementConversationResponse advertisement
    ) {
        this.advertisement = advertisement;
    }

    public MessagePageResponse getMessages() {
        return messages;
    }

    public void setMessages(MessagePageResponse messages) {
        this.messages = messages;
    }

}