package com.ecom.product.controller;

import com.ecom.product.model.ProductInventory;
import com.ecom.product.service.ProductInventoryService;
import com.ecom.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/inventory")
public class ProductInventoryController {
    @Autowired
    private ProductInventoryService productInventoryService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<ProductInventory> > addProductInventory(@RequestBody ProductInventory productInventory) {
        ApiResponse<ProductInventory> apiResponse = new ApiResponse<>();
        try{
            String savedMessage = productInventoryService.createProductInventory(productInventory);
            apiResponse.setStatus(true);
            apiResponse.setMessage(savedMessage);
            return ResponseEntity.ok().body(apiResponse);
        }catch(Exception e){
            apiResponse.setStatus(false);
            apiResponse.setMessage(e.getMessage());
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }
//    @GetMapping("/get")
//    public ResponseEntity<ApiResponse<ProductInventory>> getProductInventory(){}
}
