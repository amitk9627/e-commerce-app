package com.ecom.product.repository;


import com.ecom.product.dto.Projections;
import com.ecom.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("""
        SELECT 
            p.productId AS productId,
            p.productName AS productName,
            p.productDescription AS productDescription,
            p.productImage AS productImage,
            p.productPrice AS productPrice,
            p.topSales AS topSales,
            p.isActive AS active,
            c.categoryId AS categoryId,
            c.categoryName AS categoryName,
            sb.subCategoryId AS subCategoryId,
            sb.subCategoryName AS subCategoryName,
            pi.availableStock AS availableStock
        FROM Product p
        LEFT JOIN p.category c
        LEFT JOIN p.subCategory sb
        LEFT JOIN p.inventory pi
    """)
    List<Projections.ProductProjection> findAllWithCategoryAndSubCategory();

    @Query("""
        SELECT 
            p.productId AS productId,
            p.productName AS productName,
            p.productPrice AS productPrice,
            p.productDescription AS productDescription,
            p.productImage AS productImage,
            p.topSales AS topSales,
            p.isActive AS active,
            c.categoryId AS categoryId,
            c.categoryName AS categoryName,
            sb.subCategoryId AS subCategoryId,
            sb.subCategoryName AS subCategoryName,
            pi.availableStock AS availableStock
        FROM Product p
        LEFT JOIN p.category c
        LEFT JOIN p.subCategory sb
        LEFT JOIN p.inventory pi
        WHERE p.productId = :productId
        """)
    Projections.SingleProduct getProductById(Long productId);


}
