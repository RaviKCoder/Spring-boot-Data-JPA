package com.ravi.service;

import java.util.List;

import com.ravi.entity.Employee;

public interface IEmployeeService {

	public String registerEmployee(Employee employee);
	
	public String registerAllEmployee(List<Employee> employee);
	
	public List<Employee> showAllEmployee();
	
	
	public List<Employee> findEmployeeBySkill(List<String> skill);
}
