package com.ecom.product.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="productInventory")
@Data
public class ProductInventory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long inventoryId;


    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product;

    @Transient
    private Long productId;

    private int availableStock;
    private int reservedStock=0;

    public ProductInventory() {
    }

    public Long getProductId() {
        return product != null ? product.getCategoryId() : productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
