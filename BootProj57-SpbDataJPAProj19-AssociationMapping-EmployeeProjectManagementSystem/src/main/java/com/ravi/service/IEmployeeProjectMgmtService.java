package com.ravi.service;

import java.util.List;

import com.ravi.entity.Employee;
import com.ravi.entity.Project;

public interface IEmployeeProjectMgmtService {

	public String saveNewEmployee(Employee employee);
	
	public String saveNewProject(Project project);
	
	public String saveOneEmployeeWithMultipleProjects(Employee employee);
	
	public String saveOneProjectWithMultipleEmployee(Project project);
	
	public List<Employee> showEmployeesAndTheirProjects();
	
	public List<Project> showProjectsAndTheirEmployees();
}
