package com.ecom.product.dto;

public interface SubCategoryProjection {
    Long getSubCategoryId();
    String getSubCategoryName();
    Long getCategoryId();
    Boolean getIsActive();
}