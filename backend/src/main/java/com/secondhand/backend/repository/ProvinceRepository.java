package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {

    Optional<Province> findByName(String name);

    boolean existsByName(String name);

    List<Province> findAllByOrderByNameAsc();

}
