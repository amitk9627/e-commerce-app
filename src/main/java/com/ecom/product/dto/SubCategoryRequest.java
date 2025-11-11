package com.ecom.product.dto;

public class SubCategoryRequest {
    private String subCategoryName;
    private boolean isActive;
    private Long categoryId;

    // Getters & Setters
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

    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
