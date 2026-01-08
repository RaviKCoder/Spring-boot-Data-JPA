package com.ravi.runner;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Order;
import com.ravi.repository.IOrderRepository;

@Component
public class OrderRunner implements CommandLineRunner {

	@Autowired
	IOrderRepository orderRepository;
	
	Scanner sc=new Scanner(System.in);
	
	
	@Override
	public void run(String... args) throws Exception {
		
		
//		Order save = orderRepository.save(new Order("SACHIN", "DELIVERED", "UPI", 110000.0, LocalDate.of(2025, 12, 28)));
//		System.out.println(save);
		
//		List<Order> byOrderStatus = orderRepository.findByOrderStatus("PLACED");
//		byOrderStatus.forEach(System.out::println);
		
//		List<Order> byPaymentMode = orderRepository.findByPaymentMode("UPI");
//		byPaymentMode.forEach(System.out::println);
//		
//		List<Order> byTotalAmountGreaterThan = orderRepository.findByTotalAmountGreaterThan(10000.0);
//		byTotalAmountGreaterThan.forEach(System.out::println);
//		
//		List<Order> byOrderDateBetween = orderRepository.findByOrderDateBetween(LocalDate.of(2025,12,10), LocalDate.of(2025,12,29));
//		byOrderDateBetween.forEach(System.out::println);
//		
		List<Order> byCustomerName = orderRepository.findByCustomerName("RAVI");
		byCustomerName.forEach(System.out::println);
		
			
	}
}
