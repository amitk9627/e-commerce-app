package com.ecom.product.repository;


import com.ecom.product.dto.Projections;
import com.ecom.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT " +
            "p.productId AS productId, " +
            "p.productName AS productName, " +
            "p.productPrice AS productPrice, " +
            "p.productDescription AS productDescription, " +
            "p.productImage AS productImage, " +
            "p.isActive AS isActive, " +
            "c.categoryId AS categoryId, " +
            "c.categoryName AS categoryName, " +
            "sb.subCategoryId AS subCategoryId, " +
            "sb.subCategoryName AS subCategoryName " +
            "FROM Product p " +
            "LEFT JOIN p.category c " +
            "LEFT JOIN p.subCategory sb")
    List<Projections.ProductProjection> findAllWithCategoryAndSubCategory();
}
