package com.ecom.cart.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CartItemResponse {
    private Long productId;
    private String productName;
    private Long quantity;
    private String productImage;
    private BigDecimal productPrice;
}