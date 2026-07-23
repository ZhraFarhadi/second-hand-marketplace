package com.secondhand.backend.controller;

import com.secondhand.backend.dto.message.request.SendMessageRequest;
import com.secondhand.backend.dto.message.response.MessageResponse;
import com.secondhand.backend.service.interfaces.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/{conversationId}")
    public MessageResponse sendMessage(

            @PathVariable
            Long conversationId,

            @Valid
            @RequestBody
            SendMessageRequest request

    ) {

        return messageService.sendMessage(
                conversationId,
                request
        );

    }

}
