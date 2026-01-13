package com.ecom.product.service;

import com.ecom.product.dto.ProductRequestDTO;
import com.ecom.product.dto.Projections;
import com.ecom.product.model.Category;
import com.ecom.product.model.Product;
import com.ecom.product.model.ProductInventory;
import com.ecom.product.model.SubCategory;
import com.ecom.product.repository.CategoryRepository;
import com.ecom.product.repository.ProductInventoryRepository;
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
    @Autowired
    ProductInventoryRepository productInventoryRepository;

    public ProductRequestDTO createProduct(ProductRequestDTO prod) {

        Category category = categoryRepository.findById(prod.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found with ID: " + prod.getCategoryId()));
        // Find subCategory from DB
        SubCategory subCategory = subCategoryRepository.findById(prod.getSubCategoryId()).orElseThrow(() -> new RuntimeException("Category not found with ID: " + prod.getCategoryId()));

        Product product = new Product();
        ProductInventory pi = new ProductInventory();
        product.setProductName(prod.getProductName());
        product.setProductImage(prod.getProductImage());
        product.setProductDescription(prod.getProductDescription());
        product.setProductPrice(prod.getProductPrice());
        product.setCategory(category);
        product.setSubCategory(subCategory);

        if (prod.getAvailableStock() == 0) {
            System.out.println("zero stack");
            pi.setAvailableStock(0);
            product.setActive(false);
        } else {
            System.out.println("zero ");
            pi.setAvailableStock(prod.getAvailableStock());
            product.setActive(true);
        }
        Product newProduct = productRepository.save(product);

        // all inventory
        pi.setProduct(newProduct);
        productInventoryRepository.save(pi);
        // 🔹 Build response
        ProductRequestDTO response = new ProductRequestDTO();
        response.setProductName(prod.getProductName());
        response.setProductImage(prod.getProductImage());
        response.setProductDescription(prod.getProductDescription());
        response.setProductPrice(prod.getProductPrice());
        response.setCategoryId(prod.getCategoryId());
        response.setSubCategoryId(prod.getSubCategoryId());
        response.setAvailableStock(prod.getAvailableStock());

        return response;
    }

    public List<Projections.ProductProjection> getAllProducts() {
        return productRepository.findAllWithCategoryAndSubCategory();
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
    }

    public Projections.SingleProduct getProductByID(Long id) {
        return productRepository.getProductById(id);
    }

    public Product addProductWithInventory(Product product, Integer initialStock) {
        Product savedProduct = productRepository.save(product);

        ProductInventory inventory = new ProductInventory();
        inventory.setProduct(savedProduct);
        inventory.setAvailableStock(initialStock != null ? initialStock : 0);
        productInventoryRepository.save(inventory);

        return savedProduct;
    }
}
