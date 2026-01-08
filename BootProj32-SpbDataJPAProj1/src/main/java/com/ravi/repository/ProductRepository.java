package com.ravi.repository;

import org.springframework.data.repository.CrudRepository;

import com.ravi.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{

}
