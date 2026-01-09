package com.ravi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.Employee;
import com.ravi.repository.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	IEmployeeRepository repository;
	
	@Override
	public String registerEmployee(Employee employee) {
		Employee save = repository.save(employee);
		return "Employee register successfully with id: "+save.getEmpId();
	}
	
	@Override
	public String registerAllEmployee(List<Employee> employee) {
		List<Employee> saveAll = repository.saveAll(employee);
		List<Integer> ids = saveAll.stream().map(Employee::getEmpId).collect(Collectors.toList());
		return "List of empoyee save with ids value: "+ids;
	}
	
	@Override
	public List<Employee> showAllEmployee() {
		List<Employee> all = repository.findAll();
		return all;
	}

	@Override
	public List<Employee> findEmployeeBySkill(List<String> skill) {
	List<Employee> bySkills = repository.findBySkills(skill);
		
		return bySkills;
	}

	

	

}
