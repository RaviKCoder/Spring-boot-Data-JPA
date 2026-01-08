package com.ravi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Employee;
import com.ravi.service.EmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;
	
	@Override
	public void run(String... args) throws Exception {
		
		Iterable<Employee> fetchEmployeeByPageAndSize = employeeService.fetchEmployeeByPageAndSize(0, 3,false,"dateOfJoining");
		fetchEmployeeByPageAndSize.forEach(System.out::println);
	}

}
