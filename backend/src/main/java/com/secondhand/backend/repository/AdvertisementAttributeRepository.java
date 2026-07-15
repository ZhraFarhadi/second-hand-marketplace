
package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Advertisement;
import com.secondhand.backend.entity.AdvertisementAttribute;
import com.secondhand.backend.entity.CategoryAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementAttributeRepository
        extends JpaRepository<AdvertisementAttribute, Long> {

    List<AdvertisementAttribute> findByAdvertisement(
            Advertisement advertisement
    );

    boolean existsByCategoryAttribute(CategoryAttribute attribute);
}