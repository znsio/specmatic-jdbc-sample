package com.tbp.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tbp.crud.entity.Product;
import com.tbp.crud.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product user) {
		return productService.createProduct(user);
	}


	
	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product user) {
		return productService.updateProduct(user);
	}


}
