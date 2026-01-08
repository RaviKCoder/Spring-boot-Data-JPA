package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Product;

public interface IProductRepository extends JpaRepository<Product,Integer> {

}
