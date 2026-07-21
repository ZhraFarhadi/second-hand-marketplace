package com.secondhand.backend.dto.admin.response;

import com.secondhand.backend.enums.AccountStatus;
import com.secondhand.backend.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AdminUserDetailsResponse {

    private Long id;

    private String fullName;

    private String username;

    private String email;

    private String phoneNumber;

    private Role role;

    private AccountStatus accountStatus;

    private Double averageRating;

    private Long ratingCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
