package com.secondhand.backend.repository;

import com.secondhand.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCaseAndIdNot(
            String name,
            Long id
    );

    List<Category> findAllByOrderByDisplayOrderAscNameAsc();

    List<Category> findAllByParentIsNullOrderByDisplayOrderAscNameAsc();

    List<Category> findAllByParentOrderByDisplayOrderAscNameAsc(Category parent);

    boolean existsByParent(Category parent);

    @Query("""
       select distinct c.parent.id
       from Category c
       where c.parent is not null
       """)
    List<Long> findParentCategoryIds();

}
