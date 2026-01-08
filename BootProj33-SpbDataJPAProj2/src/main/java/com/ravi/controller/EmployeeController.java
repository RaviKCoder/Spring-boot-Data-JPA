package com.ravi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ravi.entity.Employee;
import com.ravi.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	IEmployeeService employeeService;
	
	public void createEmployee(Employee employee) {
		employeeService.createEmployee(employee);
	}

	public void createMultipleEmployees(List<Employee> employees) {
		employeeService.createMultipleEmployees(employees);
	}

	public void updateEmployee(Employee employee) {
		employeeService.updateEmployee(employee);
	}

	public Employee getEmployee(Integer id) {
		Employee employee = employeeService.getEmployee(id);
		
		return employee;
		
	}

	public List<Employee> getAllEmployees(){
		List<Employee> allEmployees = employeeService.getAllEmployees();
		
		return allEmployees;
		
	}

	public boolean employeeExists(Integer id) {
		
		boolean employeeExists = employeeService.employeeExists(id);
		
		return employeeExists;
		
	}

	public int getEmployeeCount() {
		
		int employeeCount = employeeService.getEmployeeCount();
		
		return employeeCount;
		
	}

}
