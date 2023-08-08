package com.component.products.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int cost;

    public Product(ProductDetails productDetails) {
        this.name = productDetails.getName();
        this.cost = productDetails.getCost();
    }

    public Product updateWith(ProductDetails productDetails) {
        return new Product(id, productDetails.getName(), productDetails.getCost());
    }
}
