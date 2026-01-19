package com.ravi.runner;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Employee;
import com.ravi.service.IEmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	IEmployeeService service;
	
	
	
	@Override
	public void run(String... args) throws Exception {
		while(true) {
			Scanner sc=new Scanner(System.in);
			
			try {
				System.out.println("1.save employee and sen email.");
				System.out.println("2.fetch employee as sorted.");
				System.out.println("0.exit");
				System.out.println("============================");
				System.out.print("select your choice.");
				int choice=Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1->{
					System.out.print("enter employee name: ");
					String name=sc.nextLine().toUpperCase();
					
					System.out.print("enter employee email: ");
					String email=sc.nextLine();
					
					System.out.print("enter employee department: ");
					String department=sc.nextLine().toUpperCase();
					
					System.out.print("enter employee salary: ");
					double salary=Double.parseDouble(sc.nextLine());
					
					System.out.println("enter employee joining: ");
					System.out.print("enter year: ");
					int year=sc.nextInt();
					
					System.out.print("enter month: ");
					int month=sc.nextInt();
					
					System.out.print("enter dayOfTheMonth: ");
					int day=sc.nextInt();
					
					
					LocalDate dateOfJoining=LocalDate.of(year, month, day);
					
					Employee employee=new Employee(name, email, department, salary, dateOfJoining);
					
					String saveEmployee = service.saveEmployee(employee);
					System.out.println(saveEmployee);
					
				}
				case 2->{
					
					System.out.print("enter page number: ");
					int pageNumber=Integer.parseInt(sc.nextLine());
					
					System.out.print("enter page size: ");
					int pageSize=Integer.parseInt(sc.nextLine());
					
					System.out.print("enter order true/false: ");
					boolean order=Boolean.parseBoolean(sc.nextLine());
					
					System.out.println("1.name");
					System.out.println("2.email");
					System.out.println("3.department");
					System.out.println("4.salary");
					System.out.println("5.dateOfJoining");
					System.out.println("================");
					System.out.println("enter property name: ");
					System.out.print("select your choice: ");
					int ch=Integer.parseInt(sc.nextLine());
					
					switch(ch) {
					case 1->{
						System.out.print("enter property name: ");
						String prop=sc.next();
						List<Employee> fetchPaginatedEmployeeList = service.FetchPaginatedEmployeeList(pageSize, pageNumber, order, prop);
						fetchPaginatedEmployeeList.forEach(System.out::println);
					}
					case 2->{
						System.out.print("enter property name: ");
						String prop=sc.next();
						List<Employee> fetchPaginatedEmployeeList = service.FetchPaginatedEmployeeList(pageSize, pageNumber, order, prop);
						fetchPaginatedEmployeeList.forEach(System.out::println);
					}
					case 3->{
						System.out.print("enter property name: ");
						String prop=sc.next();
						List<Employee> fetchPaginatedEmployeeList = service.FetchPaginatedEmployeeList(pageSize, pageNumber, order, prop);
						fetchPaginatedEmployeeList.forEach(System.out::println);
					}
					case 4->{
						System.out.print("enter property name: ");
						String prop=sc.next();
						List<Employee> fetchPaginatedEmployeeList = service.FetchPaginatedEmployeeList(pageSize, pageNumber, order, prop);
						fetchPaginatedEmployeeList.forEach(System.out::println);
					}
					case 5->{
						System.out.print("enter property name: ");
						String prop=sc.next();
						List<Employee> fetchPaginatedEmployeeList = service.FetchPaginatedEmployeeList(pageSize, pageNumber, order, prop);
						fetchPaginatedEmployeeList.forEach(System.out::println);
					}
					
					}
			
				}
				case 0->{
					System.out.println("Thankyou.......");
					System.exit(0);
				}
				default ->{
					throw new IllegalArgumentException("Invalid choice.");
				}
				
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
		}
		
	}

}
