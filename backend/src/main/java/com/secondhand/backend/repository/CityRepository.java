package com.secondhand.backend.repository;

import com.secondhand.backend.entity.City;
import com.secondhand.backend.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByNameAndProvince(String name,
                                         Province province);
    List<City> findAllByProvinceOrderByNameAsc(
            Province province
    );

    boolean existsByNameIgnoreCaseAndProvince(
            String name,
            Province province
    );

    List<City> findAllByOrderByNameAsc();


}