package com.ravi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.customer_entity.Customer;
import com.ravi.product_entity.Product;
import com.ravi.service.ICustomerMgmtService;

@Component
public class MultipleDBTestRunner implements CommandLineRunner {

	@Autowired
	ICustomerMgmtService serrvice;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			
			Customer customer=new  Customer("Ravi", "Jharkhand", 8000.0);
			Product product=new Product("Laptop", 50000.0, 2);
			
			String registerCustomerAndProduct = serrvice.registerCustomerAndProduct(customer, product);
			System.out.println(registerCustomerAndProduct);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
