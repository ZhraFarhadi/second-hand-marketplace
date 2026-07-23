package com.secondhand.backend.dto.admin.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AdminDashboardResponse {

    private Long totalUsers;

    private Long blockedUsers;

    private Long totalAdvertisements;

    private Long pendingAdvertisements;

    private Long activeAdvertisements;

    private Long soldAdvertisements;

    private Long totalCategories;

    private Long totalCities;

    private Long totalProvinces;

    private Long totalRatings;

    private Long totalConversations;

}
