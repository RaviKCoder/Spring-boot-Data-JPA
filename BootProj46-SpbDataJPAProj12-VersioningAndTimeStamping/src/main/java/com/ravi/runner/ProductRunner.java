package com.ravi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Product;
import com.ravi.service.IProductService;
@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	IProductService productService;
	
	@Override
	public void run(String... args) throws Exception {
	try {
		
//		Product saveProduct = productService.saveProduct(new Product("Mobile", 15000.0));
//		System.out.println("product saved successfully :"+saveProduct);
		
//		String updatePrice = productService.updatePrice(1002);
//		System.out.println(updatePrice);
		
		Iterable<Product> showProductData = productService.showProductData();
		showProductData.forEach(System.out::println);
		
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}

	}

}
