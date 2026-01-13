package com.ecom.product.dto;

import java.math.BigDecimal;

public class Projections {
    public interface SubCategoryProjection {
        Long getSubCategoryId();

        String getSubCategoryName();

        Long getCategoryId();

        Boolean getIsActive();
    }
    public interface SubCategoryByCategoryID {
        Long getSubCategoryId();
        String getSubCategoryName();
        Long getCategoryId();
        String getCategoryName();
        Boolean getIsActive();
    }
    public interface ProductProjection {
        Long getProductId();
        String getProductName();
        BigDecimal getProductPrice();
        String getProductDescription();
        String getProductImage();
        Boolean getIsActive();
        Long getCategoryId();
        String getCategoryName();
        Long getSubCategoryId();
        String getSubCategoryName();
        Integer getAvailableStock();
        Boolean getTopSales();
    }
    public interface SingleProduct {
        Long getProductId();
        String getProductName();
        BigDecimal getProductPrice();
        String getProductDescription();
        String getProductImage();
        Boolean getIsActive();
        Long getCategoryId();
        String getCategoryName();
        Long getSubCategoryId();
        String getSubCategoryName();
        Integer getAvailableStock();
        Boolean getTopSales();
    }

    public interface productInventory {
        Long getProductId();

    }
}

