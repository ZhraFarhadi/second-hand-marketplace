package com.secondhand.frontend.repository;

import com.secondhand.frontend.dto.admin.request.CreateCategoryRequest;
import com.secondhand.frontend.dto.admin.response.*;
import com.secondhand.frontend.service.AdminService;

import java.util.List;

public class AdminRepository {

    private final AdminService service = new AdminService();

    public AdminDashboardResponse getDashboard() {
        return service.getDashboard();
    }

    public List<AdminUserSummaryResponse> getUsers(int page, int size) {
        return service.getUsers(page, size);
    }

    public List<AdminAdvertisementSummaryResponse> getPendingAdvertisements(int page, int size) {
        return service.getPendingAdvertisements(page, size);
    }

    public AdminAdvertisementDetailsResponse getAdvertisementDetails(
            Long advertisementId
    ) {
        return service.getAdvertisementDetails(advertisementId);
    }

    public void approveAdvertisement(Long advertisementId) {
        service.approveAdvertisement(advertisementId);
    }

    public void rejectAdvertisement(
            Long advertisementId,
            String reason
    ) {
        service.rejectAdvertisement(advertisementId, reason);
    }

    public void blockUser(Long userId) {

        service.blockUser(userId);

    }

    public void unblockUser(Long userId) {

        service.unblockUser(userId);

    }


    public AdminUserDetailsResponse getUser(Long id){

        return service.getUser(id);

    }






    public void deleteCategory(Long id) {
        service.deleteCategory(id);
    }

    public List<AdminCategoryResponse> getCategories(){

        return service.getCategories();

    }

    public void createCategory(
            String name,
            String description
    ){

        service.createCategory(
                name,
                description
        );

    }
}