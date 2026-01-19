package com.ecom.cart.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CartResponse {
    private List<CartItemResponse> productList;
    private BigDecimal totalAmount;
}
