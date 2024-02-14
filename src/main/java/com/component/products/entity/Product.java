package com.component.products.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entity_seq_generator")
    @SequenceGenerator(name = "entity_seq_generator", sequenceName = "hibernate_sequence", allocationSize = 1)
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
