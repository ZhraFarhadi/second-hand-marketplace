package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.SellerRating;
import com.secondhand.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRatingRepository
        extends JpaRepository<SellerRating, Long> {

    boolean existsByReviewerAndAdvertisement(
            User reviewer,
            Advertisement advertisement
    );

    Optional<SellerRating> findByReviewerAndAdvertisement(
            User reviewer,
            Advertisement advertisement
    );

    Page<SellerRating> findBySellerOrderByCreatedAtDesc(
            User seller,
            Pageable pageable
    );

    long countBySeller(User seller);

    @Query("""
            SELECT AVG(sr.rating)
            FROM SellerRating sr
            WHERE sr.seller = :seller
            """)

    Double findAverageRatingBySeller(User seller);

}
