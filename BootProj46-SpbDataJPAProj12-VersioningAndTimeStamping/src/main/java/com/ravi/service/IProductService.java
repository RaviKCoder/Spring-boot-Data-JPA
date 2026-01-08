package com.ravi.service;

import com.ravi.entity.Product;

public interface IProductService {
	
	public Product saveProduct(Product product);
	
	public String updatePrice(Integer id);
	
	public Iterable<Product> showProductData();

}
