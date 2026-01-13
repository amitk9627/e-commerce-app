package com.ecom.order.dto;


import lombok.Data;
import java.math.BigDecimal;

@Data
public class OrderItemRequestDto {
    private Long productId;
    private String productName;
    private BigDecimal price;
    private Integer quantity;

}
