package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.AdvertisementImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdImageRepository
        extends JpaRepository<AdvertisementImage, Long> {

    List<AdvertisementImage> findByAdvertisementOrderByDisplayOrderAsc(
            Advertisement advertisement
    );

    Optional<AdvertisementImage> findByAdvertisementAndIsPrimaryTrue(
            Advertisement advertisement
    );

}
