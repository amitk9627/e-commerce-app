package com.ecom.cart.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartDto {
    Long productId;
    String productName="";
    Long quantity;
    BigDecimal productPrice=BigDecimal.ZERO;
}
