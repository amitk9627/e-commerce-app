package com.ecom.product.repository;

import com.ecom.product.dto.*;
import com.ecom.product.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    boolean existsBySubCategoryName(String subCategoryName);
    @Query("SELECT s.subCategoryId AS subCategoryId, " +
            "s.subCategoryName AS subCategoryName, " +
            "s.category.categoryId AS categoryId, " +
            "s.isActive AS isActive " +
            "FROM SubCategory s")
    List<Projections.SubCategoryProjection> findAllSubCategoryCustom();

    @Query("SELECT s.subCategoryId AS subCategoryId, " +
            "s.subCategoryName AS subCategoryName, " +
            "s.isActive AS isActive " +
            "FROM SubCategory s " +
            "WHERE s.category.categoryId = :categoryId")
    List<SubCategory> findByCategory_CategoryId(Long categoryId);
}
