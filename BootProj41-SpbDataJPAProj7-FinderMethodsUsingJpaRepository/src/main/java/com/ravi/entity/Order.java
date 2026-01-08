package com.ravi.entity;


import java.time.LocalDate;

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

@Data
@Entity
@Table(name = "ORDER_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Order {
	
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "order_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(name = "ORDER_ID")
	private Integer orderId;
	
	@NonNull
	@Column(name = "CUSTOMER_NAME",length = 20)
	private String customerName;
	
	@NonNull
	@Column(name = "ORDER_STATUS",length = 20)
	private String orderStatus;
	
	
	@NonNull
	@Column(name = "PAYMENT_MODE",length = 20)
	private String paymentMode;
	
	@NonNull
	@Column(name = "TOTAL_AMOUNT")
	private Double totalAmount;
	
	
	@NonNull
	@Column(name = "ORDER_DATE",length = 20)
	private LocalDate orderDate;
	
}
