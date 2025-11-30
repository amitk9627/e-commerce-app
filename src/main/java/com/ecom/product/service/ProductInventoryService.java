package com.ecom.product.service;

import com.ecom.product.model.Product;
import com.ecom.product.model.ProductInventory;
import com.ecom.product.repository.ProductInventoryRepository;
import com.ecom.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInventoryService {
    @Autowired
    ProductInventoryRepository productInventoryRepository;
    @Autowired
    ProductRepository productRepository;

    public void getProductInventoryById(Long productId) {}
    //  add
    public String createProductInventory(ProductInventory productInventory) {
        Product product = productRepository.findById(productInventory.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        productInventory.setProduct(product);
        productInventoryRepository.save(productInventory);
        return "Inventory Updated Successfully";
    }
    //    get,
    //    update
    //    delete
}
