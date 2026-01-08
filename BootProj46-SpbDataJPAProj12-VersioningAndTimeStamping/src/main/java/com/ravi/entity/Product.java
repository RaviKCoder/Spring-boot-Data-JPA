package com.ravi.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "PRODUCTS_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Product {
	
	//Data
	
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "products_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer productId;
	
	@NonNull
	@Column(length = 20)
	private String productName;
	
	@NonNull
	private Double price;
	
	//MetaData
	
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private LocalDate creationTime;
	
	@UpdateTimestamp
	@Column(updatable = true,insertable = false)
	private LocalDate lastlyUpdatedOn;
	
	@Version
	private Integer countUpdate;

}
