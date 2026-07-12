
package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.AdvertisementAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdAttributeRepository
        extends JpaRepository<AdvertisementAttribute, Long> {

    List<AdvertisementAttribute> findByAdvertisement(
            Advertisement advertisement
    );

}