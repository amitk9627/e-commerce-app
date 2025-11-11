package com.ecom.product.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(unique = true, nullable = false)
    private String categoryName;
    private String categoryDescription="";
    private String categoryImage ="";
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
    private boolean isActive= true;;
    private String role;

    public Category() {}

    public Category(Long categoryId, String categoryName, String categoryDescription, String categoryImage, boolean isActive, String role) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryImage = categoryImage;
        this.isActive = isActive;
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
