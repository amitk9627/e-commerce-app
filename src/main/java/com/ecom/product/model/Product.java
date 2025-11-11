package com.ecom.product.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(nullable = false)
    private String productName;
    private String productDescription="";
    private String productImage="";
    private long productPrice=0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;

    @ManyToOne(fetch = FetchType.LAZY) // Many products belong to one category
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product(Long productId, String productName, String productDescription, String productImage, long productPrice, Date createAt, Date updateAt, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.category = category;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Automatically set timestamps
    @PrePersist
    protected void onCreate() {
        this.createAt = new Date(); // when entity is created
        this.updateAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateAt = new Date(); // when entity is updated
    }
}
