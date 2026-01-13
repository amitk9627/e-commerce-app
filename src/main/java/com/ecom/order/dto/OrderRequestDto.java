package com.ecom.order.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequestDto {

    private Long userId;
    private String Address;
    private String paymentStatus;
    private String paymentMethod;
    private List<OrderItemRequestDto> orderItems;

}
