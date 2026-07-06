package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository
        extends JpaRepository<Advertisement, Long>,
        JpaSpecificationExecutor<Advertisement> {

    Page<Advertisement> findBySellerOrderByCreatedAtDesc(
            User seller,
            Pageable pageable
    );

}