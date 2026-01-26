package com.ravi.product_repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.product_entity.Product;

public interface IProductRepository extends JpaRepository<Product,Integer> {

}
