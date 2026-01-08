package com.ravi.runner;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Product;
import com.ravi.service.ProductService;

@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	ProductService productService;
	
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void run(String... args) throws Exception {
		
		while(true) {
			
			try {
				
				System.out.println("1.Add Product");
				System.out.println("2.Get Product by ID");
				System.out.println("3.List All Products");
				System.out.print("Select your choice:");
				
				Integer choice=Integer.parseInt(sc.next());
				
				switch (choice) {
				case 1: 
					
					System.out.print("Enter product name: ");
					String name=sc.next();
					
					System.out.print("Enter product category: ");
					String category=sc.next();
					
					System.out.print("Enter product price: ");
					Double price=Double.parseDouble(sc.next());
					
					System.out.print("Enter product stock: ");
					Integer stock=Integer.parseInt(sc.next());
					
					Product p=new Product();
					p.setName(name.toUpperCase());
					p.setCategory(category.toUpperCase());
					p.setPrice(price);
					p.setStock(stock);
					
					productService.addProduct(p);
					break;
					
				case 2:
					
					System.out.print("Enter product id: ");
					Integer id=Integer.parseInt(sc.next());
					
				Product productById = productService.getProductById(id);
					System.out.println(productById);
					break;
					
				case 3:
					
					Iterable<Product> allProducts = productService.getAllProducts();
					
					allProducts.forEach(System.out::println);
					
					//System.out.println(allProducts);
					break;
					
				case 4:
					System.out.println("Thank You......");
					System.exit(0);
				
					
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
				
				
				
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		
		


	}

}
