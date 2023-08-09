package com.component.products.controller;

import com.component.products.entity.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;

import com.component.products.entity.Product;
import com.component.products.service.ProductService;
import org.springframework.web.bind.annotation.*;

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

	@DeleteMapping("/products/{id}")
	public Product update(@PathVariable int id) {
		return productService.delete(id);
	}

}
