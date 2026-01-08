package com.ravi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.Product;
import com.ravi.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public void addProduct(Product p) {
		Product product = productRepository.save(p);
		Integer productId = product.getProductId();
		
		System.out.println("Product save with id: "+productId);
	}
	
	public Product getProductById(Integer id) {
		Optional<Product> byId = productRepository.findById(id);
		
		return byId.get();
		
	}
	
	public Iterable<Product> getAllProducts() {
		Iterable<Product> all = productRepository.findAll();
		return all;
		
	}



	
}
