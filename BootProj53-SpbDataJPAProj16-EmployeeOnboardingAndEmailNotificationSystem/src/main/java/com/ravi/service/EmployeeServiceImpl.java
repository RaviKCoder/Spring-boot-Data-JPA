package com.ravi.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ravi.entity.Employee;
import com.ravi.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeRepository repository;
	
	@Autowired
	IMailService mailSender;
	
	@Override
	public String saveEmployee(Employee employee) {
		
		Employee emp = repository.save(employee);
		
		mailSender.sendMail(emp);
		
		return "Employee save successfully "+emp;
	}

	@Override
	public List<Employee> FetchPaginatedEmployeeList(int pageSize,int pageNumber,boolean order,String ...properties) {
		
		Sort sort = Sort.by(order?Sort.Direction.ASC:Sort.Direction.DESC,properties);
		
		Pageable pageable=PageRequest.of(pageNumber, pageSize,sort);
		
		Page<Employee> all = repository.findAll(pageable);
		
		List<Employee> list = all.stream().toList();
		
		return list;
	}

}
