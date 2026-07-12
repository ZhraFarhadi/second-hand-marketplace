package com.secondhand.backend.dto.auth.response;

import com.secondhand.backend.enums.AccountStatus;
import com.secondhand.backend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserProfileResponse {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private String phoneNumber;

    private Role role;

    private AccountStatus accountStatus;

}