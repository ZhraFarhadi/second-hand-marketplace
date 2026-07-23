package com.secondhand.backend.repository;

import com.secondhand.backend.entity.CategoryAttribute;
import com.secondhand.backend.entity.CategoryAttributeOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryAttributeOptionRepository
        extends JpaRepository<CategoryAttributeOption, Long> {

    List<CategoryAttributeOption>
    findByCategoryAttributeOrderByDisplayOrderAsc(
            CategoryAttribute attribute
    );

}
