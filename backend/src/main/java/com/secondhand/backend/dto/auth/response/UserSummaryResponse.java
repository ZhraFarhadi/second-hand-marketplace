package com.secondhand.backend.dto.auth.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserSummaryResponse {

    private Long id;

    private String fullName;

    private String username;

}
