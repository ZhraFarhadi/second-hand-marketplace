
package com.secondhand.backend.dto.auth.response;

import com.secondhand.backend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private Long userId;

    private String username;

    private Role role;

    private String token;

}