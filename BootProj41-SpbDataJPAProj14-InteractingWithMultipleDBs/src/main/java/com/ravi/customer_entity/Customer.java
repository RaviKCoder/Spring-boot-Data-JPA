package com.ravi.customer_entity;

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
@Table(name = "MDB_CUSTOMER_INFO")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "cust_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer custNo;
	
	@NonNull
	@Column(length = 30)
	private String custName;
	
	@NonNull
	@Column(length = 30)
	private String custAddrs;
	
	@NonNull
	private Double custBillAmt;
}
