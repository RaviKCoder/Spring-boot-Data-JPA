package com.ravi.customer_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.customer_entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

}
