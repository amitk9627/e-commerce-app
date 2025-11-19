package com.ecom.product.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "subCategories")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subCategoryId;
    @Column(unique = true, nullable = false)
    private String subCategoryName;
    private boolean isActive=true;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties({"subCategories"}) // prevents recursion or lazy errors
    private Category category;
    @Transient
    private Long categoryId;

    public SubCategory() {}

    public SubCategory(Long subCategoryId, String subCategoryName, boolean isActive, Category category) {
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
        this.isActive = isActive;
        this.category = category;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    // ✅ Automatically expose categoryId in JSON
    public Long getCategoryId() {
        return category != null ? category.getCategoryId() : categoryId;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    // ✅ You MUST have these two methods
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
