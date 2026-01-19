package com.ecom.cart.controller;

import com.ecom.cart.dto.*;
import com.ecom.cart.service.CartService;
import com.ecom.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/modifyCart")
    public ResponseEntity<ApiResponse<CartResponse>> modifyCart(@RequestBody() CartRequest request) {
        ApiResponse<CartResponse> response = new ApiResponse<>();
        try{
            List<CartDto> productList = request.getProductList();

            CartResponse cartResponse=cartService.addToCart(productList);
            response.setStatus(true);
            response.setMessage("Cart Updated Successfully");
            response.setResult(cartResponse);
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            response.setStatus(false);
            response.setMessage("f :  ");
           return ResponseEntity.badRequest().body(response);
        }
    }
}
