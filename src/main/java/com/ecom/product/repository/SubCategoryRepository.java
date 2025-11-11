package com.ecom.product.repository;

import com.ecom.product.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    boolean existsBySubCategoryName(String subCategoryName);
    List<SubCategory> findByCategory_CategoryId(Long categoryId);
}
