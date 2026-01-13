package com.ecom.product.dto;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductRequestDTO {
    private String productName;
    private String productDescription;
    private String productImage;
    private BigDecimal productPrice;
    private Long categoryId;
    private Long subCategoryId;
    private Integer availableStock = 0; // 👈 Just one field
}

