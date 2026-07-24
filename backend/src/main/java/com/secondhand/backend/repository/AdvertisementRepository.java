package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.Category;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.enums.AdvertisementStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertisementRepository
        extends JpaRepository<Advertisement, Long>,
        JpaSpecificationExecutor<Advertisement> {

    Page<Advertisement> findBySellerAndDeletedAtIsNullOrderByCreatedAtDesc(
            User seller,
            Pageable pageable
    );

    Page<Advertisement> findByStatusAndDeletedAtIsNullOrderByCreatedAtDesc(
            AdvertisementStatus status,
            Pageable pageable
    );

    Page<Advertisement> findByCategoryIdAndStatusAndDeletedAtIsNullOrderByCreatedAtDesc(
            Long categoryId,
            AdvertisementStatus status,
            Pageable pageable
    );

    Optional<Advertisement>
    findByIdAndDeletedAtIsNull(Long id);

    boolean existsByCategoryAndDeletedAtIsNull(Category category);



    Page<Advertisement> findAllByOrderByCreatedAtDesc(
            Pageable pageable
    );

    long countByStatus(AdvertisementStatus status);

    long countByStatusAndDeletedAtIsNull(
            AdvertisementStatus status
    );

    long countByDeletedAtIsNull();



}