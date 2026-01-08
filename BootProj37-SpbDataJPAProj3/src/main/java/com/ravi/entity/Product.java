package com.ravi.entity;



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
@Table(name="PRODUCT_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "seq1",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(name = "PRODUCTID")
	Integer productId ;

	@Column(name="PRODUCTNAME")
	@NonNull
	String productName;

	@Column(name="BRAND")
	@NonNull
	String brand;

	@Column(name="PRICE")
	@NonNull
	Double price;

	@Column(name = "STOCK")
	@NonNull
	Integer stock;

}
