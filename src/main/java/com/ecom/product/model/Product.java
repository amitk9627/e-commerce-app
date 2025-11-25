package com.ecom.product.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name="product")
@EntityListeners(AuditingEntityListener.class)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(nullable = false)
    private String productName;
    private String productDescription="";
    private String productImage="";
    private BigDecimal productPrice=new BigDecimal(0);
    private boolean topSales=false;
    private boolean isActive=true;
    private Long supplierId=null;
    @CreatedDate
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY) // Many products belong to one category
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @Transient
    private Long categoryId;

    @ManyToOne(fetch = FetchType.LAZY) // Many products belong to one category
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory;
    @Transient
    private Long subCategoryId;

    public Product() {}

    public Product(Long productId, String productName, String productDescription, String productImage, BigDecimal productPrice, Category category, SubCategory subCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.category = category;
        this.subCategory = subCategory;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    // ✅ Automatically expose categoryId in JSON
    public Long getCategoryId() {
        return category != null ? category.getCategoryId() : categoryId;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
    public Long getSubCategoryId() {
        return subCategory !=null ?  subCategory.getSubCategoryId(): subCategoryId;
    }

    public boolean isTopSales() {
        return topSales;
    }

    public void setTopSales(boolean topSales) {
        this.topSales = topSales;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productPrice=" + productPrice +
                ", topSales=" + topSales +
                ", supplierId=" + supplierId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", category=" + category +
                ", categoryId=" + categoryId +
                ", subCategory=" + subCategory +
                ", subCategoryId=" + subCategoryId +
                '}';
    }
}
