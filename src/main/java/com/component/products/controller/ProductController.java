package com.component.products.controller;

import com.component.products.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;

import com.component.products.entity.Product;
import com.component.products.service.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public Product create(@RequestBody ProductDetails productDetails) {
		return productService.create(productDetails);
	}

	@PutMapping("/products/{id}")
	public Product update(@PathVariable int id, @RequestBody ProductDetails productDetails) {
		return productService.update(id, productDetails);
	}

}
