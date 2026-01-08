package com.ravi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.Employee;
import com.ravi.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployeeRepository employeeRepository;
	
	@Override
	public void createEmployee(Employee employee) {
		Employee save = employeeRepository.save(employee);
		
		Integer id = save.getId();
		
		System.out.println("Employee save with id:"+id);

	}

	@Override
	public void createMultipleEmployees(List<Employee> employees) {
		Iterable<Employee> saveAll = employeeRepository.saveAll(employees);
		
		saveAll.forEach(list->{
			System.out.println("employee inserted with id: "+list.getId());
		});
	}

	@Override
	public void updateEmployee(Employee employee) {
		Employee save = employeeRepository.save(employee);
		
		Integer id = save.getId();
		
		System.out.println("Employee update with id:"+id);

	}

	@Override
	public Employee getEmployee(Integer id) {
		Optional<Employee> byId = employeeRepository.findById(id);
		return byId.get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		Iterable<Employee> all = employeeRepository.findAll();
		
		List<Employee> list=new ArrayList<Employee>();
		
		all.forEach(e->{
			list.add(e);
		});
		
		return list;
	}

	@Override
	public boolean employeeExists(Integer id) {
		boolean existsById = employeeRepository.existsById(id);
		return existsById;
	}

	@Override
	public int getEmployeeCount() {
		int count = (int)employeeRepository.count();
		return count;
	}

}
