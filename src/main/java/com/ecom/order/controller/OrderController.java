package com.ecom.order.controller;

import com.ecom.order.dto.OrderRequestDto;
//import com.ecom.order.model.Order;
//import com.ecom.order.repository.OrderRepository;
import com.ecom.order.service.OrderService;
//import com.ecom.product.service.ProductService;
import com.ecom.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
//    @Autowired
//    ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createOrder(@RequestBody OrderRequestDto req){
        ApiResponse response = new ApiResponse();
        try {
            orderService.createNewOrder(req);
            response.setStatus(true);
            response.setMessage("Order created successfully");
            return ResponseEntity.ok().body(response);
        }catch(Exception e){
            response.setStatus(false);
            response.setMessage(e.getMessage());
            return  ResponseEntity.badRequest().body(response);
        }
    }
}
