package com.ravi.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Product;
import com.ravi.repository.IProductRepository;

@Component
public class ProductRunner implements CommandLineRunner {

	@Autowired
	IProductRepository productRepository;
	
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void run(String... args) throws Exception {
		
		while(true) {
			try {
				System.out.println("1.Add product");
				System.out.println("2.Add multiple products");
				System.out.println("3.Find product by ID");
				System.out.println("4.View all products");
				System.out.println("5.Update product price");
				System.out.println("6.Delete product by ID");
				System.out.println("7.Delete all products");
				System.out.println("8.Exit");
				System.out.println("========================");
				System.out.print("Select your choice: ");
				
				Integer choice=Integer.parseInt(sc.next());
				
				switch(choice) {
				
				case 1:
					System.out.print("Enter product name: ");
					
					String name=sc.next();
					
					System.out.print("Enter product brand: ");
					
					String brand=sc.next();
					
					System.out.print("Enter product price: ");
					
					Double price=Double.parseDouble(sc.next());
					
					System.out.println("Enter product stock: ");
					
					Integer stock=Integer.parseInt(sc.next());
					
					Product productSaved = productRepository.save(new Product(name.toUpperCase(), brand.toUpperCase(), price, stock));
					System.out.println("Product saved successfully with id: "+productSaved.getProductId());
					break;
					
				case 2:
					System.out.print("How many product details u want to insert: ");
					Integer noOfProducts=Integer.parseInt(sc.next());
					
					List<Product> list=new ArrayList<Product>();
					
					for(int i=1;i<=noOfProducts;i++) {
						System.out.print("Enter product"+i+" name: ");
						
						name=sc.next();
						
						System.out.print("Enter product"+i+"  brand: ");
						
						brand=sc.next();
						
						System.out.print("Enter product"+i+"  price: ");
						
						price=Double.parseDouble(sc.next());
						
						System.out.print("Enter product"+i+"  stock: ");
						
						stock=Integer.parseInt(sc.next());
						
						Product product=new Product(name.toUpperCase(), brand.toUpperCase(), price, stock);
						
						list.add(product);
						
					}
					
					Iterable<Product> saveAll = productRepository.saveAll(list);
					System.out.print("List of product inserted successsfully with ids: ");
					saveAll.forEach(id->{
						System.out.println(id.getProductId()+" ");
					});
					break;
					
				case 3:
					
					System.out.print("Enter product id: ");
					Integer id=Integer.parseInt(sc.next());
					
					Optional<Product> byId = productRepository.findById(id);
					
					if(byId.isPresent()) {
						
						System.out.println(byId);
					}else {
						System.out.println("Product not found.");
					}
					break;
					
				case 4:
					
					Iterable<Product> all = productRepository.findAll();
					all.forEach(System.out::println);
					break;
					
				case 5:
					
					System.out.print("Enter product id: ");
					id=Integer.parseInt(sc.next());
					
					Optional<Product> opt = productRepository.findById(id);
					
					System.out.println(opt);
					
					if(opt.isPresent()) {
						Product product = opt.get();
						
						System.out.print("Enter new price: ");
						Double newPrice=Double.parseDouble(sc.next());
						product.setPrice(newPrice);
						
						Product save = productRepository.save(product);
						System.out.println("product price updated successfully: "+save);	
					}else {
						System.out.println("product not found");
					}
					break;
				
				case 6:
					
					System.out.print("Enter product id: ");
					id=Integer.parseInt(sc.next());
					
					productRepository.deleteById(id);
					System.out.println("Product deleted successfully with id: "+id);
					break;
					
				case 7:
					productRepository.deleteAll();
					
					System.out.println("All products deleted successfully");
					break;
					
				case 8:
					System.out.println("Thankyou.....");
					System.exit(0);
					
				default :
					
					throw new IllegalAccessException("Invalid choice");
						
				}
					
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		


	}

}
