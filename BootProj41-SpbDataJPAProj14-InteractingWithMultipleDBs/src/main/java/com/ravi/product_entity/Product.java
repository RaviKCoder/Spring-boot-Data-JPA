package com.ravi.product_entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "MDB_PRODUCT_INFO")
@AllArgsConstructor()
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName  = "prd_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer pid;
	
	@NonNull
	@Column(length = 30)
	private String pname;
	
	@NonNull
	private Double price;
	
	@NonNull
	private Integer qnty;
}
