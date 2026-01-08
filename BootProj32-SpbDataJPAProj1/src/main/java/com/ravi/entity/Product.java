package com.ravi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {

	@Column(name="PRODUCTID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	
	@Column(name="NAME",length = 20)
	@NonNull
	private String name;
	
	@Column(name="CATEGORY",length = 20)
	@NonNull
	private String category;
	
	@Column(name="PRICE")
	@NonNull
	private Double price;
	
	@Column(name="STOCK")
	@NonNull
	private Integer stock;
	
}
