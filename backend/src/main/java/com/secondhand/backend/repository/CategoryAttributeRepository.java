
package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Category;
import com.secondhand.backend.entity.CategoryAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryAttributeRepository
        extends JpaRepository<CategoryAttribute, Long> {

    List<CategoryAttribute> findByCategoryOrderByNameAsc(
            Category category
    );

    boolean existsByCategoryAndNameIgnoreCase(
            Category category,
            String name
    );

    boolean existsByCategoryAndNameIgnoreCaseAndIdNot(
            Category category,
            String name,
            Long id
    );

    Optional<CategoryAttribute> findById(
            Long id
    );

    boolean existsByCategory(Category category);

    boolean existsByAdvertisementAttributesIsNotEmpty(
            CategoryAttribute categoryAttribute
    );

}