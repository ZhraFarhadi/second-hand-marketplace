package com.secondhand.frontend.service;

import com.google.gson.reflect.TypeToken;
import com.secondhand.frontend.client.ApiClient;
import com.secondhand.frontend.dto.admin.request.CreateAdminReviewRequest;
import com.secondhand.frontend.dto.admin.request.CreateCategoryRequest;
import com.secondhand.frontend.dto.admin.response.*;
import com.secondhand.frontend.model.ReviewStatus;

import java.lang.reflect.Type;
import java.util.List;

public class AdminService {

    public AdminDashboardResponse getDashboard() {

        try {

            return ApiClient.get(
                    "/admin/dashboard",
                    AdminDashboardResponse.class
            );

        }

        catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public List<AdminUserSummaryResponse> getUsers(
            int page,
            int size
    ) {

        try {

            Type type =
                    new TypeToken<List<AdminUserSummaryResponse>>() {}.getType();

            return ApiClient.get(
                    "/admin/users?page=" + page + "&size=" + size,
                    type
            );

        }

        catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public List<AdminAdvertisementSummaryResponse> getPendingAdvertisements(
            int page,
            int size
    ) {

        try {

            Type type =
                    new TypeToken<List<AdminAdvertisementSummaryResponse>>() {}.getType();

            return ApiClient.get(
                    "/admin/reviews/pending?page=" + page + "&size=" + size,
                    type
            );

        }

        catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public AdminAdvertisementDetailsResponse getAdvertisementDetails(
            Long advertisementId
    ) {

        try {

            return ApiClient.get(
                    "/admin/advertisements/" + advertisementId,
                    AdminAdvertisementDetailsResponse.class
            );

        }

        catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public void approveAdvertisement(
            Long advertisementId
    ) {

        try {

            CreateAdminReviewRequest request =
                    new CreateAdminReviewRequest();

            request.setReviewStatus(
                    ReviewStatus.APPROVED
            );

            request.setComment("");

            ApiClient.put(
                    "/admin/reviews/" + advertisementId,
                    request,
                    Object.class
            );

        }

        catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public void rejectAdvertisement(
            Long advertisementId,
            String reason
    ) {

        try {

            CreateAdminReviewRequest request =
                    new CreateAdminReviewRequest();

            request.setReviewStatus(
                    ReviewStatus.REJECTED
            );

            request.setComment(reason);

            ApiClient.put(
                    "/admin/reviews/" + advertisementId,
                    request,
                    Object.class
            );

        }

        catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public void blockUser(Long userId){

        try{

            ApiClient.patch(
                    "/admin/users/" + userId + "/block"
            );

        }

        catch(Exception e){

            throw new RuntimeException(e);

        }

    }

    public void unblockUser(Long userId){

        try{

            ApiClient.patch(
                    "/admin/users/" + userId + "/unblock"
            );

        }

        catch(Exception e){

            throw new RuntimeException(e);

        }

    }


    public AdminUserDetailsResponse getUser(Long id){

        try{

            return ApiClient.get(
                    "/admin/users/" + id,
                    AdminUserDetailsResponse.class
            );

        }

        catch(Exception e){

            throw new RuntimeException(e);

        }

    }
    public AdminUserDetailsResponse getUserDetails(
            Long userId
    ){

        try{

            return ApiClient.get(
                    "/admin/users/" + userId,
                    AdminUserDetailsResponse.class
            );

        }catch(Exception e){

            throw new RuntimeException(e);

        }

    }

    public List<AdminCategoryResponse> getCategories(){

        try{

            Type type =
                    new TypeToken<List<AdminCategoryResponse>>(){}.getType();

            return ApiClient.get(
                    "/admin/categories",
                    type
            );

        }

        catch(Exception e){

            throw new RuntimeException(e);

        }

    }

    public void createCategory(

            String name,

            String description

    ){

        try{

            CreateCategoryRequest request =
                    new CreateCategoryRequest();

            request.setName(name);

            request.setDescription(description);

            ApiClient.post(

                    "/admin/categories",

                    request,

                    Object.class

            );

        }

        catch(Exception e){

            throw new RuntimeException(e);

        }

    }
    public void deleteCategory(Long id){

        try{

            ApiClient.delete(
                    "/admin/categories/" + id
            );

        }

        catch(Exception e){

            throw new RuntimeException(e);

        }

    }
}