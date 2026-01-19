package com.ravi.service;

import java.util.List;

import com.ravi.entity.Employee;

public interface IEmployeeService {

	public String saveEmployee(Employee employee);
	
	public List<Employee> FetchPaginatedEmployeeList(int pageSize,int pageNumber,boolean order,String ...properties);
}
