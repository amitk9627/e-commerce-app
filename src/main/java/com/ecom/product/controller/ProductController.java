package com.ecom.product.controller;

import com.ecom.product.dto.ProductRequestDTO;
import com.ecom.product.dto.Projections;
import com.ecom.product.model.Product;
import com.ecom.product.service.ProductService;
import com.ecom.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/createProduct")
    public ResponseEntity<ApiResponse<ProductRequestDTO>> createProduct(@RequestBody ProductRequestDTO product){
        ApiResponse<ProductRequestDTO> apiResponse = new ApiResponse<>();
        try{
            ProductRequestDTO products = productService.createProduct(product);
            if(products == null){
                apiResponse.setMessage("product not saved");
                apiResponse.setStatus(false);
            }
            apiResponse.setMessage("Product Added Successfully");
            apiResponse.setStatus(true);
            apiResponse.setResult(products);
            return ResponseEntity.ok().body(apiResponse);
        }catch(Exception error){
            apiResponse.setMessage(error.getMessage());
            apiResponse.setStatus(false);
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }
    @GetMapping("/getAllProduct")
    public ResponseEntity<ApiResponse<List<Projections.ProductProjection>>> getAllProduct() {
        ApiResponse<List<Projections.ProductProjection>> apiResponse = new ApiResponse<>();
        try{
            List<Projections.ProductProjection> products = productService.getAllProducts();
            System.out.println(products.size()+" list of product");
            if(products.isEmpty()){
                apiResponse.setMessage("No product Found!");
                apiResponse.setStatus(false);
            }
            apiResponse.setMessage("List Found Successfully");
            apiResponse.setStatus(true);
            apiResponse.setResult(products);
            return ResponseEntity.ok().body(apiResponse);
        }catch(Exception error){
            apiResponse.setMessage(error.getMessage());
            apiResponse.setStatus(false);
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ApiResponse<Projections.SingleProduct>> getProduct(@PathVariable("id") Long id) {
        ApiResponse<Projections.SingleProduct> apiResponse = new ApiResponse<>();
        try{
            Projections.SingleProduct product =  productService.getProductByID(id);
            if(product==null){
                apiResponse.setMessage("No product Found!");
                apiResponse.setStatus(false);
            }
            apiResponse.setMessage("List Found Successfully");
            apiResponse.setStatus(true);
            apiResponse.setResult(product);
            return ResponseEntity.ok().body(apiResponse);
        }catch(Exception error){
            apiResponse.setMessage(error.getMessage());
            apiResponse.setStatus(false);
            return ResponseEntity.internalServerError().body(apiResponse);
        }
    }


}
