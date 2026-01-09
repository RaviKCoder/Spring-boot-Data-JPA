package com.ravi.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Employee;
import com.ravi.repository.IEmployeeRepository;
import com.ravi.service.IEmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	IEmployeeService service;
	Scanner sc=new Scanner(System.in);
	@Override
	public void run(String... args) throws Exception {
		try {
			
//			Employee employee=new Employee("Rajesh", List.of("Java","Spring","React"), Set.of("Java","React"), Map.of("STUDENT MANAGEMENT SYSTEM","Good","PRODUCT MANAGEMENT SYSTEM","GREAT"));
//			String registerEmployee = service.registerEmployee(employee);
//			System.out.println(registerEmployee);
			
//			System.out.println("==============================");
			
//			Employee employee1=new Employee("Sachin", List.of("Java","Spring","React"), Set.of("Java","React"), Map.of("HR MANAGEMENT SYSTEM","Good","PRODUCT MANAGEMENT SYSTEM","GREAT"));
//			Employee employee2=new Employee("Manoj", List.of("Java","Spring","React"), Set.of("Java","React"), Map.of("INVENTORY MANAGEMENT SYSTEM","Good","PRODUCT MANAGEMENT SYSTEM","GREAT"));
//			Employee employee3=new Employee("Pintu", List.of("Java","Spring","React"), Set.of("Java","React"), Map.of("STUDENT MANAGEMENT SYSTEM","Good","PRODUCT MANAGEMENT SYSTEM","GREAT"));
//			
//			String registerAllEmployee = service.registerAllEmployee(List.of(employee1,employee2,employee3));
//			System.out.println(registerAllEmployee);
			
			
//			System.out.println("==============================");
			
			List<Employee> showAllEmployee = service.showAllEmployee();
			showAllEmployee.forEach(System.out::println);
			
//			System.out.println("==============================");
//			
//			System.out.print("how many skills u want to find: ");
//			int noOfSkills=Integer.parseInt(sc.nextLine());
//			
//			List<String > skills=new ArrayList<String>();
//			
//			for(int i=1;i<=noOfSkills;i++) {
//				System.out.print("Enter skills "+i+" :");
//				skills.add(sc.nextLine());
//			}
//			
//			System.out.print("Enter skill: ");
//			
//			List<Employee> employeeBySkill = service.findEmployeeBySkill(skills);
//			employeeBySkill.forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
