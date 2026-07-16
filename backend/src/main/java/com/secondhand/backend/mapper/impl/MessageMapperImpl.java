package com.secondhand.backend.mapper.impl;

import com.secondhand.backend.dto.message.response.MessageResponse;
import com.secondhand.backend.entity.Message;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.mapper.interfaces.MessageMapper;
import org.springframework.stereotype.Component;

@Component
public class MessageMapperImpl
        implements MessageMapper {

    @Override
    public MessageResponse toResponse(

            Message message,

            User currentUser

    ) {

        if (message == null) {
            return null;
        }

        return new MessageResponse(

                message.getId(),

                message.getSender().getId(),

                message.getContent(),

                message.getCreatedAt(),

                message.getSender()
                        .getId()
                        .equals(currentUser.getId())

        );

    }

}