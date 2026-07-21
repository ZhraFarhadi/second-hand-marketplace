package com.secondhand.backend.service.interfaces;

import com.secondhand.backend.dto.admin.response.AdminUserDetailsResponse;
import com.secondhand.backend.dto.admin.response.AdminUserSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminUserService {

    Page<AdminUserSummaryResponse> getUsers(
            Pageable pageable
    );

    AdminUserDetailsResponse getUser(
            Long userId
    );

    void blockUser(
            Long userId
    );

    void activateUser(
            Long userId
    );

}