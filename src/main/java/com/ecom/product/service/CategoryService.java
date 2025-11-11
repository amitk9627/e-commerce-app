package com.ecom.product.service;

import com.ecom.product.model.Category;
import com.ecom.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // ✅ Create
    public Category createCategory(Category category) {
        if (categoryRepository.existsByCategoryName(category.getCategoryName())) {
            throw new RuntimeException("Category name already exists!");
        }
        return categoryRepository.save(category);
    }

    // ✅ Read all
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // ✅ Read by ID
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
    }

    // ✅ Update
    public Category updateCategory(Long id, Category updatedCategory)  {
        Category existing = getCategoryById(id);
        existing.setCategoryName(updatedCategory.getCategoryName());
        existing.setCategoryDescription(updatedCategory.getCategoryDescription());
        existing.setCategoryImage(updatedCategory.getCategoryImage());
        existing.setActive(updatedCategory.isActive());
        existing.setRole(updatedCategory.getRole());
        return categoryRepository.save(existing);
    }

    // ✅ Delete
    public String deleteCategory(Long id) {
        Category existing = getCategoryById(id);
        categoryRepository.delete(existing);
        return "Category deleted successfully (ID: " + id +", Name: "+ existing.getCategoryName()+ ")";
    }
}
