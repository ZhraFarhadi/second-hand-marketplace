package com.secondhand.backend.service.impl;


import com.secondhand.backend.dto.admin.response.AdminUserDetailsResponse;
import com.secondhand.backend.dto.admin.response.AdminUserSummaryResponse;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.enums.AccountStatus;
import com.secondhand.backend.enums.Role;
import com.secondhand.backend.exception.BusinessException;
import com.secondhand.backend.exception.ErrorCode;
import com.secondhand.backend.mapper.interfaces.AdminUserMapper;
import com.secondhand.backend.mapper.interfaces.UserMapper;
import com.secondhand.backend.repository.UserRepository;
import com.secondhand.backend.service.interfaces.AdminUserService;
import com.secondhand.backend.service.interfaces.CurrentUserService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminUserServiceImpl
        implements AdminUserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final CurrentUserService currentUserService;

    @Override
    @Transactional(readOnly = true)
    public Page<AdminUserSummaryResponse> getUsers(
            Pageable pageable
    ) {

        return userRepository
                .findAllByOrderByCreatedAtDesc(pageable)
                .map(userMapper::toAdminSummaryResponse);

    }

    @Override
    @Transactional(readOnly = true)
    public AdminUserDetailsResponse getUser(
            Long userId
    ) {

        User user = getExistingUser(userId);

        return userMapper.toAdminDetailsResponse(user);

    }

    @Override
    public void blockUser(
            Long userId
    ) {

        User user =
                getExistingUser(userId);

        validateCanChangeStatus(user);

        if (user.getAccountStatus() == AccountStatus.BLOCKED) {

            throw new BusinessException(
                    ErrorCode.USER_ALREADY_BLOCKED
            );

        }

        user.setAccountStatus(
                AccountStatus.BLOCKED
        );

        userRepository.save(user);

    }

    @Override
    public void activateUser(
            Long userId
    ) {

        User user =
                getExistingUser(userId);

        validateCanChangeStatus(user);

        if (user.getAccountStatus() == AccountStatus.ACTIVE) {

            throw new BusinessException(
                    ErrorCode.USER_ALREADY_ACTIVE
            );

        }

        user.setAccountStatus(
                AccountStatus.ACTIVE
        );

        userRepository.save(user);

    }

    private User getExistingUser(
            Long userId
    ) {

        return userRepository
                .findById(userId)
                .orElseThrow(() ->
                        new BusinessException(
                                ErrorCode.USER_NOT_FOUND
                        )
                );

    }

    private void validateCanChangeStatus(
            User user
    ) {

        User currentAdmin =
                currentUserService.getCurrentUser();

        if (currentAdmin.getId().equals(user.getId())) {

            throw new BusinessException(
                    ErrorCode.ADMIN_CANNOT_BLOCK_SELF
            );

        }

        if (user.getRole() == Role.ADMIN) {

            throw new BusinessException(
                    ErrorCode.ADMIN_STATUS_CHANGE_NOT_ALLOWED
            );

        }

    }

}

