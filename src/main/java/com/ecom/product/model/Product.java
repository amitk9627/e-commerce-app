package com.ecom.product.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name="product")
@EntityListeners(AuditingEntityListener.class)
@Data
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

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProductInventory inventory;
    @Transient
    private Long inventoryId;

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
    // Automatically expose categoryId in JSON
    public Long getCategoryId() {
        return category != null ? category.getCategoryId() : categoryId;
    }
    public Long getSubCategoryId() {
        return subCategory !=null ?  subCategory.getSubCategoryId(): subCategoryId;
    }
}
