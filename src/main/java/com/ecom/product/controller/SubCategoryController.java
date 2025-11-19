package com.ecom.product.controller;

import com.ecom.product.dto.SubCategoryProjection;
import com.ecom.product.dto.SubCategoryReq;
import com.ecom.product.dto.SubCategoryRes;
import com.ecom.product.model.SubCategory;
import com.ecom.product.service.CategoryService;
import com.ecom.product.service.SubCategoryService;
import com.ecom.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping("/addSubCategory")
    public ResponseEntity<ApiResponse<SubCategory>> addSubCategory(@RequestBody SubCategory request) {
        ApiResponse apiResponse = new ApiResponse();
        try{
            System.out.println(request.getSubCategoryName());
            SubCategory subCategory1=subCategoryService.createSubCategory(request);
            System.out.println(subCategory1.getSubCategoryName()+" response");
            apiResponse.setStatus(true);
            apiResponse.setMessage("Success");
            apiResponse.setResult(subCategory1);
            return ResponseEntity.ok().body(apiResponse);
        }catch(Exception e){
            apiResponse.setStatus(false);
            apiResponse.setMessage("Not Found "+e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }
    @GetMapping("/getAllSubCategory")
    public ResponseEntity<ApiResponse<List<SubCategory>>> getAllSubCategories() {
        ApiResponse apiResponse = new ApiResponse();
        try {
            List<SubCategoryProjection> subCategoryList=subCategoryService.getAllSubCategories();
//            System.out.println(subCategoryList.size()+" response");
            apiResponse.setStatus(true);
            apiResponse.setMessage("Success");
            apiResponse.setResult(subCategoryList);
            return ResponseEntity.ok().body(apiResponse);
        }catch(Exception e){
            apiResponse.setStatus(false);
            apiResponse.setMessage("Not Found "+e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }
    @GetMapping("/getSubCategoryByCategory")
    public ResponseEntity<ApiResponse<List<SubCategory>>> getSubCategoryByCategory(@RequestParam("category_id") Long categoryId) {
        ApiResponse response = new ApiResponse();
        try{
            List<SubCategory> subCategory = subCategoryService.getAllSubCategoriesByCategoryId(categoryId);
            response.setStatus(true);
            response.setMessage("Success");
            response.setResult(subCategory);
            return ResponseEntity.ok().body(response);
        }catch(Exception e){
            response.setStatus(false);
            response.setMessage("Not Found");
            return ResponseEntity.badRequest().body(response);
        }

    }
}
