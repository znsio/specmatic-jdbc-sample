package com.component.products.service;

import com.component.products.dao.ProductRepository;
import com.component.products.entity.Product;
import com.component.products.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product create(ProductDetails productDetails) {
        return productRepository.save(new Product(productDetails));
    }

    public Product update(int id, ProductDetails productDetails) {
        Optional<Product> productToBeUpdated = productRepository.findById(id);
        if (!productToBeUpdated.isPresent()) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        return productRepository.save(productToBeUpdated.get().updateWith(productDetails));
    }

}
