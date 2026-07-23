package com.secondhand.frontend.dto.admin.response;

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

    public Long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(Long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public Long getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(Long blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

    public Long getTotalAdvertisements() {
        return totalAdvertisements;
    }

    public void setTotalAdvertisements(Long totalAdvertisements) {
        this.totalAdvertisements = totalAdvertisements;
    }

    public Long getPendingAdvertisements() {
        return pendingAdvertisements;
    }

    public void setPendingAdvertisements(Long pendingAdvertisements) {
        this.pendingAdvertisements = pendingAdvertisements;
    }

    public Long getActiveAdvertisements() {
        return activeAdvertisements;
    }

    public void setActiveAdvertisements(Long activeAdvertisements) {
        this.activeAdvertisements = activeAdvertisements;
    }

    public Long getSoldAdvertisements() {
        return soldAdvertisements;
    }

    public void setSoldAdvertisements(Long soldAdvertisements) {
        this.soldAdvertisements = soldAdvertisements;
    }

    public Long getTotalCategories() {
        return totalCategories;
    }

    public void setTotalCategories(Long totalCategories) {
        this.totalCategories = totalCategories;
    }

    public Long getTotalCities() {
        return totalCities;
    }

    public void setTotalCities(Long totalCities) {
        this.totalCities = totalCities;
    }

    public Long getTotalProvinces() {
        return totalProvinces;
    }

    public void setTotalProvinces(Long totalProvinces) {
        this.totalProvinces = totalProvinces;
    }

    public Long getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(Long totalRatings) {
        this.totalRatings = totalRatings;
    }

    public Long getTotalConversations() {
        return totalConversations;
    }

    public void setTotalConversations(Long totalConversations) {
        this.totalConversations = totalConversations;
    }
}