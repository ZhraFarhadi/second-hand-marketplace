package com.secondhand.backend.controller;

import com.secondhand.backend.dto.admin.response.AdminUserDetailsResponse;
import com.secondhand.backend.dto.admin.response.AdminUserSummaryResponse;
import com.secondhand.backend.service.interfaces.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
public class AdminUserController {

    private final AdminUserService adminUserService;

    @GetMapping
    public ResponseEntity<Page<AdminUserSummaryResponse>> getUsers(
            @PageableDefault(size = 20)
            Pageable pageable
    ) {

        return ResponseEntity.ok(
                adminUserService.getUsers(pageable)
        );

    }

    @GetMapping("/{userId}")
    public ResponseEntity<AdminUserDetailsResponse> getUser(
            @PathVariable
            Long userId
    ) {

        return ResponseEntity.ok(
                adminUserService.getUser(userId)
        );

    }

    @PatchMapping("/{userId}/block")
    public ResponseEntity<Void> blockUser(
            @PathVariable
            Long userId
    ) {

        adminUserService.blockUser(userId);

        return ResponseEntity.noContent().build();

    }

    @PatchMapping("/{userId}/unblock")
    public ResponseEntity<Void> unblockUser(
            @PathVariable
            Long userId
    ) {

        adminUserService.activateUser(userId);

        return ResponseEntity.noContent().build();

    }

}