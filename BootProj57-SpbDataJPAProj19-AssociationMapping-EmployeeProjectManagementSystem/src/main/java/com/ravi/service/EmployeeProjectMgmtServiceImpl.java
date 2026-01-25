package com.ravi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.Employee;
import com.ravi.entity.Project;
import com.ravi.repository.IEmployeeRepository;
import com.ravi.repository.IProjectRepository;

@Service
public class EmployeeProjectMgmtServiceImpl implements IEmployeeProjectMgmtService {

	@Autowired
	IEmployeeRepository employeeRepo;
	
	@Autowired
	IProjectRepository projectRepo;
	
	@Override
	public String saveNewEmployee(Employee employee) {
		Employee save = employeeRepo.save(employee);
		return "Employee saved successfully "+save;
	}

	@Override
	public String saveNewProject(Project project) {
		Project save = projectRepo.save(project);
		return "Project saved successfully "+save;
	}

	@Override
	public String saveOneEmployeeWithMultipleProjects(Employee employee) {
		Employee save = employeeRepo.save(employee);
		return "One employee with mutiple projects save successfully ";
	}

	@Override
	public String saveOneProjectWithMultipleEmployee(Project project) {
		Project save = projectRepo.save(project);
		return "One project with multiple employees save successfully ";
	}

	@Override
	public List<Employee> showEmployeesAndTheirProjects() {
		List<Employee> all = employeeRepo.findAll();
		return all;
	}

	@Override
	public List<Project> showProjectsAndTheirEmployees() {
		List<Project> all = projectRepo.findAll();
		return all;
	}

}
