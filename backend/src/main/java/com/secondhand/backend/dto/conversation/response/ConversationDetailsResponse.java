
package com.secondhand.backend.dto.conversation.response;

import com.secondhand.backend.dto.auth.response.UserSummaryResponse;
import com.secondhand.backend.dto.message.response.MessageResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@AllArgsConstructor
public class ConversationDetailsResponse {

    private Long id;

    private UserSummaryResponse buyer;

    private UserSummaryResponse seller;

    private Long advertisementId;

    private String advertisementTitle;

    private Page<MessageResponse> messages;

}