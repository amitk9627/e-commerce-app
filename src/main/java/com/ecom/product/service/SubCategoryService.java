package com.ecom.product.service;

import com.ecom.product.dto.SubCategoryRequest;
import com.ecom.product.model.Category;
import com.ecom.product.model.SubCategory;
import com.ecom.product.repository.CategoryRepository;
import com.ecom.product.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public SubCategory createSubCategory(SubCategoryRequest request) {
        if (subCategoryRepository.existsBySubCategoryName(request.getSubCategoryName())) {
            throw new RuntimeException("Category name already exists!");
        }
        // Find category from DB
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + request.getCategoryId()));

        // Create new subcategory
        SubCategory subCategory = new SubCategory();
        subCategory.setSubCategoryName(request.getSubCategoryName());
        subCategory.setActive(request.isActive());
        subCategory.setCategory(category);
        return subCategoryRepository.save(subCategory);
    }
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }
    public SubCategory getSubCategoryById(Long id) {
        return subCategoryRepository.getReferenceById(id);
    }
    public List<SubCategory> getAllSubCategoriesByCategoryId(Long categoryId) {
        return subCategoryRepository.findByCategory_CategoryId(categoryId);
    }

}
