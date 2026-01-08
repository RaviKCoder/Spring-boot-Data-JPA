package com.ravi.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.controller.EmployeeController;
import com.ravi.entity.Employee;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	EmployeeController employeeController;
	
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		while(true) {
			
			try {
				
				System.out.println("1.Insert single employee:");
				System.out.println("2.Insert multiple employee");
				System.out.println("3.Find Employee by ID");
				System.out.println("4.Find All Employees");
				System.out.println("5.Check employee exists");
				System.out.println("6.Count records");
				System.out.println("==========================");
				System.out.print("Select your choice:");
				
				Integer choice=Integer.parseInt(sc.next());
				
				switch(choice){
				
				case 1:
					
					System.out.print("Enter name: ");
					String name=sc.next();
					
					System.out.print("Enter department: ");
					String department=sc.next();
					
					System.out.print("Enter salary: ");
					Double salary=Double.parseDouble(sc.next());
					
					Employee emp=new Employee(name.toUpperCase(), department.toUpperCase(), salary);
					
					employeeController.createEmployee(emp);
					break;
					
				case 2:
					System.out.print("how many employee you want to insert:");
					Integer noOfEmployee=Integer.parseInt(sc.next());
					
					List<Employee> list=new ArrayList<Employee>();
					
					for(int i=1;i<=noOfEmployee;i++) {
						
						System.out.print("enter employee "+i+" name: ");
						name=sc.next();
						
						System.out.print("enter employee "+i+" department: ");
						department=sc.next();
						
						System.out.print("enter employee "+i+" salary: ");
						salary=Double.parseDouble(sc.next());
						
						Employee employee=new Employee(name.toUpperCase(), department.toUpperCase(), salary);
						list.add(employee);
						
						System.out.println("=====================");
					}
					
					employeeController.createMultipleEmployees(list);
					break;
					
					
				case 3:
					
					System.out.print("Enter id: ");
					Integer id=Integer.parseInt(sc.next());
					
					Employee employeeById = employeeController.getEmployee(id);
					
					System.out.println(employeeById);
					break;
					
				case 4:
					
					List<Employee> allEmployees = employeeController.getAllEmployees();
					
					allEmployees.forEach(empList->{
						System.out.println(empList);
					});
					
					//System.out.println(allEmployees);
					break;
				
				case 5:
					System.out.print("Enter id: ");
					id=Integer.parseInt(sc.next());
					
					boolean employeeExists = employeeController.employeeExists(id);
					System.out.println("Employee with ID="+id+" exists: "+employeeExists);
					break;
					
				case 6:
					
					int employeeCount = employeeController.getEmployeeCount();
					System.out.println("Total Employees: "+employeeCount);
					break;
					
				default :	
					
					throw new IllegalAccessException("Invalid choice:");
				}
					
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
			
			
			
		}
		
	}

}
