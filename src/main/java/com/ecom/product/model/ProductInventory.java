package com.ecom.product.model;

import jakarta.persistence.*;


@Entity
@Table(name="inventory")
public class ProductInventory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long inventoryId;

}
