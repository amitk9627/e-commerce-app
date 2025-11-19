package com.ecom.product.dto;

import com.ecom.product.model.SubCategory;

public class SubCategoryRes {
    private Long subCategoryId;
    private String subCategoryName;
    private boolean isActive;
    private Long categoryId;
    private String categoryName;

    public SubCategoryRes(Long id, String name, boolean isActive, Long categoryId, String categoryName) {
        this.subCategoryId = id;
        this.subCategoryName = name;
        this.isActive = isActive;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public SubCategoryRes(SubCategory subCategory) {
        this.subCategoryId = subCategory.getSubCategoryId();
        this.subCategoryName = subCategory.getSubCategoryName();
        this.isActive = subCategory.isActive();
        if (subCategory.getCategory() != null) {
            this.categoryId = subCategory.getCategory().getCategoryId();
            this.categoryName = subCategory.getCategory().getCategoryName();
        }
    }

    // getters and setters
}
