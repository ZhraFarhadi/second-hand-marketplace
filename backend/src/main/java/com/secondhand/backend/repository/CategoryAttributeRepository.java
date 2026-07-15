
package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Category;
import com.secondhand.backend.entity.CategoryAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryAttributeRepository
        extends JpaRepository<CategoryAttribute, Long> {

    List<CategoryAttribute> findByCategoryOrderByIdAsc(Category category);

    boolean existsByCategoryAndName(
            Category category,
            String name
    );

}