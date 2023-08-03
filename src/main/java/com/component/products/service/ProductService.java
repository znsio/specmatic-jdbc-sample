package com.component.products.service;

import java.util.Optional;

import com.component.products.dao.ProductRepository;
import com.component.products.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Product create(Product user) {
		return productRepository.save(user);
	}
	
	public Product update(int id, Product product) {
		Product oldProduct=null;
		Optional<Product> optionaluser= productRepository.findById(id);
		if(optionaluser.isPresent()) {
			oldProduct=optionaluser.get();
			oldProduct.setName(product.getName());
			oldProduct.setCost(product.getCost());
			productRepository.save(oldProduct);
		}else {
			return new Product();
		}
		return oldProduct;
	}


}
