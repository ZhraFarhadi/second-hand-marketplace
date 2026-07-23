package com.secondhand.backend.mapper.interfaces;

import com.secondhand.backend.dto.message.response.MessageResponse;
import com.secondhand.backend.entity.Message;
import com.secondhand.backend.entity.User;

public interface MessageMapper {

    MessageResponse toResponse(

            Message message,

            User currentUser

    );

}