package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.Favorite;
import com.secondhand.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

    Page<Favorite> findByUserAndAdvertisementDeletedAtIsNullOrderByCreatedAtDesc(
            User user,
            Pageable pageable
    );

    long countByUser(User user);


}
