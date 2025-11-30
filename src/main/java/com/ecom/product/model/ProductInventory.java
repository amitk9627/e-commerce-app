package com.ecom.product.model;

import jakarta.persistence.*;


@Entity
@Table(name="productInventory")
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

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }

    public int getReservedStock() {
        return reservedStock;
    }

    public void setReservedStock(int reservedStock) {
        this.reservedStock = reservedStock;
    }
}
