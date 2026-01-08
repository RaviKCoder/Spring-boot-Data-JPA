package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Order;

import java.time.LocalDate;
import java.util.List;

public interface IOrderRepository extends JpaRepository<Order,Integer> {
	
	public List<Order> findByOrderStatus(String orderStatus);
	
	public List<Order> findByPaymentMode(String paymentMode);
	
	public List<Order> findByTotalAmountGreaterThan(Double totalAmount);
	
	public List<Order> findByOrderDateBetween(LocalDate orderDate1,LocalDate orderDate2);
	
	public List<Order> findByCustomerName(String customerName);

}
