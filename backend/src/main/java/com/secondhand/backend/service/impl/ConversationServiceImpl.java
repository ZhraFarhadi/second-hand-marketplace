package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.conversation.response.ConversationDetailsResponse;
import com.secondhand.backend.dto.conversation.response.ConversationSummaryResponse;
import com.secondhand.backend.dto.message.response.MessageResponse;
import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.Conversation;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.enums.AdvertisementStatus;
import com.secondhand.backend.exception.BusinessException;
import com.secondhand.backend.exception.ErrorCode;
import com.secondhand.backend.mapper.interfaces.ConversationMapper;
import com.secondhand.backend.repository.AdvertisementRepository;
import com.secondhand.backend.repository.ConversationRepository;
import com.secondhand.backend.service.interfaces.ConversationService;
import com.secondhand.backend.service.interfaces.CurrentUserService;
import com.secondhand.backend.service.interfaces.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ConversationServiceImpl
        implements ConversationService {

    private final ConversationRepository conversationRepository;

    private final AdvertisementRepository advertisementRepository;

    private final CurrentUserService currentUserService;

    private final ConversationMapper conversationMapper;

    private final MessageService messageService;

    @Override
    public ConversationDetailsResponse startConversation(
            Long advertisementId
    ) {

        User currentUser =
                currentUserService.getCurrentUser();

        Advertisement advertisement =
                getAdvertisementOrThrow(
                        advertisementId
                );

        validateAdvertisementCanReceiveMessages(
                advertisement
        );

        validateNotSeller(
                advertisement,
                currentUser
        );

        Conversation conversation =
                conversationRepository
                        .findByBuyerAndSellerAndAdvertisement(
                                currentUser,
                                advertisement.getSeller(),
                                advertisement
                        )
                        .orElseGet(() ->
                                createConversation(
                                        currentUser,
                                        advertisement
                                )
                        );

        return conversationMapper.toDetailsResponse(
                conversation,
                Page.empty()
        );

    }

    @Override
    @Transactional
    public ConversationDetailsResponse getConversation(
            Long conversationId,
            Pageable pageable
    ) {

        User currentUser =
                currentUserService.getCurrentUser();

        Conversation conversation =
                getConversationOrThrow(
                        conversationId
                );

        validateConversationAccess(
                conversation,
                currentUser
        );

        Page<MessageResponse> messages =
                messageService
                        .getConversationMessages(
                                conversation,
                                currentUser,
                                pageable
                        );

        return conversationMapper.toDetailsResponse(
                conversation,
                messages
        );

    }

    @Override
    @Transactional(readOnly = true)
    public Page<ConversationSummaryResponse> getMyConversations(
            Pageable pageable
    ) {

        User currentUser =
                currentUserService.getCurrentUser();

        return conversationRepository
                .findMyConversations(
                        currentUser,
                        pageable
                )
                .map(conversation ->
                        conversationMapper.toSummaryResponse(

                                conversation,

                                currentUser,

                                messageService.getLastMessage(
                                        conversation
                                ),

                                messageService.hasUnreadMessages(
                                        conversation,
                                        currentUser
                                )


                        )
                );

    }


    private Conversation getConversationOrThrow(
            Long conversationId
    ) {

        return conversationRepository
                .findById(conversationId)
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.CONVERSATION_NOT_FOUND
                        )
                );

    }

    private Advertisement getAdvertisementOrThrow(
            Long advertisementId
    ) {

        return advertisementRepository
                .findByIdAndDeletedAtIsNull(
                        advertisementId
                )
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.ADVERTISEMENT_NOT_FOUND
                        )
                );

    }

    private void validateConversationAccess(
            Conversation conversation,
            User currentUser
    ) {

        if (!isParticipant(
                conversation,
                currentUser
        )) {

            throw new BusinessException(
                    ErrorCode.CONVERSATION_NOT_FOUND
            );

        }

    }

    private void validateAdvertisementCanReceiveMessages(
            Advertisement advertisement
    ) {

        if (advertisement.getStatus()
                != AdvertisementStatus.ACTIVE) {

            throw new BusinessException(
                    ErrorCode.ADVERTISEMENT_NOT_ACTIVE
            );

        }

    }

    private void validateNotSeller(
            Advertisement advertisement,
            User currentUser
    ) {

        if (advertisement.getSeller()
                .getId()
                .equals(currentUser.getId())) {

            throw new BusinessException(
                    ErrorCode.CANNOT_START_CONVERSATION_WITH_SELF
            );

        }

    }

    private Conversation createConversation(
            User buyer,
            Advertisement advertisement
    ) {

        Conversation conversation =
                new Conversation();

        conversation.setBuyer(
                buyer
        );

        conversation.setSeller(
                advertisement.getSeller()
        );

        conversation.setAdvertisement(
                advertisement
        );

        return conversationRepository.save(
                conversation
        );

    }

    private boolean isParticipant(
            Conversation conversation,
            User user
    ) {

        return conversation.getBuyer()
                .getId()
                .equals(user.getId())
                ||
                conversation.getSeller()
                        .getId()
                        .equals(user.getId());

    }

}