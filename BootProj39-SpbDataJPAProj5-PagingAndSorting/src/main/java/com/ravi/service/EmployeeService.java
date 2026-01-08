package com.ravi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ravi.entity.Employee;
import com.ravi.repository.IEmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	IEmployeeRepository employeeRepository;	
	
	public Iterable<Employee> fetchEmployeeByPageAndSize(int pageNo,int pageSize,Boolean ascOrder, String props){
		
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC,props);
		
		Pageable pageable=PageRequest.of(pageNo, pageSize,sort);
		
		Page<Employee> all = employeeRepository.findAll(pageable);
		return all;
		
	}

}
