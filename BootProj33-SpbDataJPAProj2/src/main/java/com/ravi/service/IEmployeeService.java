package com.ravi.service;

import java.util.List;

import com.ravi.entity.Employee;

public interface IEmployeeService {

	void createEmployee(Employee employee);

	void createMultipleEmployees(List<Employee> employees);

	void updateEmployee(Employee employee);

	Employee getEmployee(Integer id);

	List<Employee> getAllEmployees();

	boolean employeeExists(Integer id);

	int getEmployeeCount();

	
	
}
