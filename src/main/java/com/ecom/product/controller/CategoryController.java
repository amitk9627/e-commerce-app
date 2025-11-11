package com.ecom.product.controller;

import com.ecom.product.model.Category;
import com.ecom.product.service.CategoryService;
import com.ecom.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAllCategory")
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategory() {
        ApiResponse response = new ApiResponse();
        try{
            List getAllCategoryList= categoryService.getAllCategories();
            System.out.println( "getAllCategoryList");
            response.setStatus(true);
            response.setMessage("success");
            response.setResult(getAllCategoryList);
            return ResponseEntity.ok().body(response);
        }catch( Exception error){
            response.setStatus(false);
            response.setMessage("Not found");
           return ResponseEntity.badRequest().body(response);
        }
    }
    @PostMapping("/addCategory")
    public ResponseEntity<ApiResponse> addCategory (@RequestBody Category category) {
        ApiResponse response = new ApiResponse();
        try{
            Category category1=categoryService.createCategory(category);
            response.setResult(category1);
            response.setMessage("success");
            response.setStatus(true);
            return ResponseEntity.ok().body(response);
        }catch(Exception error){
            response.setStatus(false);
            response.setMessage("Not found");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/deleteCategory")
    public ResponseEntity<ApiResponse> deleteCategory(@RequestParam("category_id") Long categoryId) {
        ApiResponse response = new ApiResponse();
        try{
            String deleteMsg= categoryService.deleteCategory(categoryId);
            response.setMessage(deleteMsg);
            response.setStatus(true);
            return ResponseEntity.ok().body(response);
        }catch(Exception error){
            response.setStatus(false);
            response.setMessage("Not found");
            return ResponseEntity.badRequest().body(response);
        }
    }

}
