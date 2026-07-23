package com.secondhand.backend.dto.admin.response;

import com.secondhand.backend.enums.AccountStatus;
import com.secondhand.backend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminUserSummaryResponse {

    private Long id;

    private String fullName;

    private String username;

    private String email;

    private Role role;

    private AccountStatus accountStatus;

    private Double averageRating;

    private Long ratingCount;

}