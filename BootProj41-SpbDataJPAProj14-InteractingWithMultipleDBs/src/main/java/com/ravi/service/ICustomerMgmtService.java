package com.ravi.service;

import com.ravi.customer_entity.Customer;
import com.ravi.product_entity.Product;

public interface ICustomerMgmtService {

	public String registerCustomerAndProduct(Customer customer,Product product);
	
}
