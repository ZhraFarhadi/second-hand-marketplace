package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.Favorite;
import com.secondhand.backend.entity.User;
import com.secondhand.backend.enums.AdvertisementStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    boolean existsByUserAndAdvertisement(
            User user,
            Advertisement advertisement
    );

    Optional<Favorite> findByUserAndAdvertisement(
            User user,
            Advertisement advertisement
    );

    @Query("""
        select f
        from Favorite f
        where f.user = :user
          and f.advertisement.deletedAt is null
          and f.advertisement.status = :status
        order by f.createdAt desc
    """)
    Page<Favorite> findActiveFavoritesByUserOrderByCreatedAtDesc(
            @Param("user") User user,
            @Param("status") AdvertisementStatus status,
            Pageable pageable
    );

    long countByUser(User user);

    @Query("""
        select f.advertisement.id
        from Favorite f
        where f.user = :user
          and f.advertisement.id in :advertisementIds
    """)
    Set<Long> findFavoriteAdvertisementIdsByUserAndAdvertisementIds(
            @Param("user") User user,
            @Param("advertisementIds") Collection<Long> advertisementIds
    );
}
