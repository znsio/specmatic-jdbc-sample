package com.tbp.crud.service;

import java.util.Optional;

import com.tbp.crud.dao.ProductRepository;
import com.tbp.crud.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	public Product createProduct(Product user) {
		return productRepository.save(user);
	}
	
	public Product updateProduct(Product product) {
		Product oldProduct=null;
		Optional<Product> optionaluser= productRepository.findById(product.getId());
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
