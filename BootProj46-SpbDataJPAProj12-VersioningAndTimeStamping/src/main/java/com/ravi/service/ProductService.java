package com.ravi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.Product;
import com.ravi.exception.ProductNotFoundException;
import com.ravi.repository.IProductRepository;
@Service
public class ProductService implements IProductService {

	@Autowired
	IProductRepository productRepository;
	
	@Override
	public Product saveProduct(Product product) {
		Product save = productRepository.save(product);
		return save;
	}

	@Override
	public String updatePrice(Integer id) {
		Product product = productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("invalid product id."));
		product.setPrice(product.getPrice()+(product.getPrice()*0.1));
		Product save = productRepository.save(product);
		return "product price updated successfully with id: "+save.getProductId();
	}

	@Override
	public Iterable<Product> showProductData() {
		List<Product> all = productRepository.findAll();
		
		return all;
	}

}
