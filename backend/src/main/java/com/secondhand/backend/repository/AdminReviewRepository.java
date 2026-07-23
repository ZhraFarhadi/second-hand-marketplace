package com.secondhand.backend.repository;


import com.secondhand.backend.entity.AdminReview;
import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminReviewRepository
        extends JpaRepository<AdminReview, Long> {

    List<AdminReview> findByAdvertisementOrderByReviewedAtDesc(
            Advertisement advertisement
    );

    Page<AdminReview> findByAdminOrderByReviewedAtDesc(
            User admin,
            Pageable pageable
    );

    Optional<AdminReview> findFirstByAdvertisementOrderByReviewedAtDesc(
            Advertisement advertisement
    );

    Page<AdminReview>
    findByAdvertisementOrderByReviewedAtDesc(
            Advertisement advertisement,
            Pageable pageable
    );

}