package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.backend.dto.conversation.response.ConversationSummaryResponse;
import com.secondhand.backend.dto.message.response.MessageResponse;
import com.secondhand.backend.entity.AdvertisementImage;
import com.secondhand.backend.entity.Conversation;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.mapper.interfaces.AdvertisementMapper;
import com.secondhand.backend.mapper.interfaces.ConversationMapper;
import com.secondhand.backend.mapper.interfaces.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConversationMapperImpl
        implements ConversationMapper {

    private final UserMapper userMapper;

    private final AdvertisementMapper advertisementMapper;

    @Override
    public ConversationSummaryResponse toSummaryResponse(
            Conversation conversation,
            User currentUser,
            String lastMessage,
            boolean hasUnreadMessages
    ) {

        if (conversation == null) {
            return null;
        }

        User otherUser =
                conversation.getBuyer().getId().equals(currentUser.getId())
                        ? conversation.getSeller()
                        : conversation.getBuyer();

        return new ConversationSummaryResponse(

                conversation.getId(),

                conversation.getAdvertisement().getId(),

                conversation.getAdvertisement().getTitle(),

                getPrimaryImageUrl(conversation),

                userMapper.toSummaryResponse(otherUser),

                lastMessage,

                hasUnreadMessages,

                conversation.getLastMessageAt()

        );

    }

    @Override
    public ConversationDetailsResponse toDetailsResponse(
            Conversation conversation,
            Page<MessageResponse> messages
    ) {

        if (conversation == null) {
            return null;
        }

        return new ConversationDetailsResponse(

                conversation.getId(),

                userMapper.toSummaryResponse(
                        conversation.getBuyer()
                ),

                userMapper.toSummaryResponse(
                        conversation.getSeller()
                ),

                advertisementMapper.toSummaryResponse(
                        conversation.getAdvertisement()
                ),

                messages

        );

    }

    private String getPrimaryImageUrl(
            Conversation conversation
    ) {

        return conversation.getAdvertisement()
                .getImages()
                .stream()
                .filter(AdvertisementImage::isPrimary)
                .findFirst()
                .map(AdvertisementImage::getImageUrl)
                .orElse(null);

    }

}