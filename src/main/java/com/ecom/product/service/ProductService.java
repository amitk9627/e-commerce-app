package com.ecom.product.service;

import com.ecom.product.dto.Projections;
import com.ecom.product.model.Category;
import com.ecom.product.model.Product;
import com.ecom.product.model.SubCategory;
import com.ecom.product.repository.CategoryRepository;
import com.ecom.product.repository.ProductRepository;
import com.ecom.product.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubCategoryRepository subCategoryRepository;
    public Product createProduct(Product product) {

        // Find category from DB
        Category category = categoryRepository.findById(product.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + product.getCategoryId()));
        // Find subCategory from DB
        SubCategory subCategory = subCategoryRepository.findById(product.getSubCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + product.getCategoryId()));

        product.setCategory(category);
        product.setSubCategory(subCategory);
        return productRepository.save(product);
    }

    public List<Projections.ProductProjection> getAllProducts() {
        return productRepository.findAllWithCategoryAndSubCategory();
    }
    public Projections.SingleProduct getProductByID(Long id) {
        return productRepository.getProductById(id);
    }
}
