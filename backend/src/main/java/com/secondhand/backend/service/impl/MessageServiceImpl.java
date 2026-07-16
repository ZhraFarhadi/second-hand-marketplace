package com.secondhand.backend.service.impl;

import com.secondhand.backend.dto.message.request.SendMessageRequest;
import com.secondhand.backend.dto.message.response.MessageResponse;
import com.secondhand.backend.entity.Conversation;
import com.secondhand.backend.entity.Message;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.exception.BusinessException;
import com.secondhand.backend.exception.ErrorCode;
import com.secondhand.backend.mapper.interfaces.MessageMapper;
import com.secondhand.backend.repository.ConversationRepository;
import com.secondhand.backend.repository.MessageRepository;
import com.secondhand.backend.service.interfaces.CurrentUserService;
import com.secondhand.backend.service.interfaces.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageServiceImpl
        implements MessageService {

    private final MessageRepository messageRepository;

    private final ConversationRepository conversationRepository;

    private final CurrentUserService currentUserService;

    private final MessageMapper messageMapper;

    @Override
    public MessageResponse sendMessage(
            Long conversationId,
            SendMessageRequest request
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

        User receiver =
                getOtherUser(
                        conversation,
                        currentUser
                );

        Message message =
                createMessage(
                        conversation,
                        currentUser,
                        receiver,
                        request.getContent()
                );

        conversation.setLastMessageAt(
                LocalDateTime.now()
        );

        return messageMapper.toResponse(
                message,
                currentUser
        );

    }

    @Override
    @Transactional
    public Page<MessageResponse> getConversationMessages(
            Conversation conversation,
            User currentUser,
            Pageable pageable
    ) {

        validateConversationAccess(
                conversation,
                currentUser
        );

        markMessagesAsRead(
                conversation,
                currentUser
        );

        return messageRepository
                .findByConversationOrderByCreatedAtAsc(
                        conversation,
                        pageable
                )
                .map(message ->
                        messageMapper.toResponse(
                                message,
                                currentUser
                        )
                );

    }

    @Override
    public void markMessagesAsRead(
            Conversation conversation,
            User currentUser
    ) {

        messageRepository
                .findByConversationAndReceiverAndReadFalse(
                        conversation,
                        currentUser
                )
                .forEach(message ->
                        message.setRead(true)
                );

    }

    @Override
    @Transactional(readOnly = true)
    public String getLastMessage(
            Conversation conversation
    ) {

        return messageRepository
                .findTopByConversationOrderByCreatedAtDesc(
                        conversation
                )
                .map(Message::getContent)
                .orElse(null);

    }

    @Override
    @Transactional(readOnly = true)
    public boolean hasUnreadMessages(
            Conversation conversation,
            User currentUser
    ) {

        return messageRepository
                .existsByConversationAndReceiverAndReadFalse(
                        conversation,
                        currentUser
                );

    }

    @Override
    @Transactional(readOnly = true)
    public long getUnreadCount(
            Conversation conversation,
            User currentUser
    ) {

        return messageRepository
                .countByConversationAndReceiverAndReadFalse(
                        conversation,
                        currentUser
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

    private Message createMessage(
            Conversation conversation,
            User sender,
            User receiver,
            String content
    ) {

        String messageContent =
                content == null
                        ? ""
                        : content.trim();

        if (messageContent.isBlank()) {

            throw new BusinessException(
                    ErrorCode.INVALID_MESSAGE_CONTENT
            );

        }

        Message message =
                new Message();

        message.setConversation(
                conversation
        );

        message.setSender(
                sender
        );

        message.setReceiver(
                receiver
        );

        message.setContent(
                messageContent
        );

        return messageRepository.save(
                message
        );

    }

    private User getOtherUser(
            Conversation conversation,
            User currentUser
    ) {

        if (conversation.getBuyer()
                .getId()
                .equals(currentUser.getId())) {

            return conversation.getSeller();

        }

        return conversation.getBuyer();

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
