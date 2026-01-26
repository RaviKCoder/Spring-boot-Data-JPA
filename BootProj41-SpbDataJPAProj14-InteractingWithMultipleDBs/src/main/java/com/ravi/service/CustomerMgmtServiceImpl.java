package com.ravi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.customer_entity.Customer;
import com.ravi.customer_repository.ICustomerRepository;
import com.ravi.product_entity.Product;
import com.ravi.product_repository.IProductRepository;

@Service
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {

	@Autowired
	IProductRepository productRepository;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Override
	public String registerCustomerAndProduct(Customer customer, Product product) {
		//save the objects
		
		Integer pId = productRepository.save(product).getPid();
		Integer custId = customerRepository.save(customer).getCustNo();
		
		return "Customer and Product are save with id values: "+pId+" : "+custId;
	}

}
