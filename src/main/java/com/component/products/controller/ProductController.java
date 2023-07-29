package com.component.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.component.products.entity.Product;
import com.component.products.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product user) {
		return productService.createProduct(user);
	}


	
	@PutMapping("/updateProduct")
	public Product updateProduct(@RequestBody Product user) {
		return productService.updateProduct(user);
	}


}
