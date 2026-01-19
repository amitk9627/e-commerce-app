package com.ecom.cart.service;

import com.ecom.cart.dto.*;
import com.ecom.product.model.Product;
import com.ecom.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    ProductService productService;

    public CartResponse addToCart(List<CartDto> cartDto) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        List <CartItemResponse> responseItems = new ArrayList<>();
        for (CartDto item: cartDto) {
            Product product = productService.getProductById(item.getProductId());
            // total product value
            BigDecimal itemTotal =
                    product.getProductPrice()
                            .multiply(BigDecimal.valueOf(item.getQuantity()));
            // total cart value
            totalAmount = totalAmount.add(itemTotal);

            // response with correct project data
            CartItemResponse responseItem= new CartItemResponse();
            // from product fetch from the DB
            responseItem.setProductId(product.getProductId());
            responseItem.setQuantity(item.getQuantity());
            responseItem.setProductName(product.getProductName());
            responseItem.setProductImage(product.getProductImage());
            // from the calculation, itemTotal=  price * quantity
            responseItem.setProductPrice(itemTotal);
            // add product object into arrayList
            responseItems.add(responseItem);
        }
        CartResponse cartResponse = new CartResponse();
        cartResponse.setTotalAmount(totalAmount);
        cartResponse.setProductList(responseItems);

        return cartResponse;
    }
}
