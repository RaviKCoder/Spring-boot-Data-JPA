package com.ravi.runner;

import java.time.Period;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Employee;
import com.ravi.entity.Project;
import com.ravi.service.IEmployeeProjectMgmtService;

@Component
public class EmployeeProjectTestRunner implements CommandLineRunner {

	@Autowired
	IEmployeeProjectMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			
//			Employee employee=new Employee("Ravi", "developer", 35000.0);
//			String saveNewEmployee = service.saveNewEmployee(employee);
//			System.out.println(saveNewEmployee);
			
			
//			Project project=new Project("E-commerce", "HDFC", Period.of(0, 12, 0));
//			String saveNewProject = service.saveNewProject(project);
//			System.out.println(saveNewProject);
			
			
//			Employee employee=new Employee("Amit", "Tester", 40000.0);		
//			Project project1=new Project("Banking App", "Amazon", Period.ofMonths(9));
//			Project project2=new Project("Gaming App", "HDFC", Period.ofMonths(7));
//			Project project3=new Project("E-commerce", "Amazon", Period.ofMonths(5));
//			
//			employee.getProjects().add(project1);
//			employee.getProjects().add(project2);
//			employee.getProjects().add(project3);
//			
//			String saveOneEmployeeWithMultipleProjects = service.saveOneEmployeeWithMultipleProjects(employee);
//			System.out.println(saveOneEmployeeWithMultipleProjects);
			
			
//			Project project=new Project("Gaming App", "Google", Period.ofMonths(8));
//			
//			Employee employee1=new Employee("Ravi", "Developer", 50000.0);
//			Employee employee2=new Employee("Amit", "Tester", 60000.0);
//			
//			project.getEmployees().add(employee1);
//			project.getEmployees().add(employee2);
//			
//			String saveOneProjectWithMultipleEmployee = service.saveOneProjectWithMultipleEmployee(project);
//			System.out.println(saveOneProjectWithMultipleEmployee);
			
			
//			List<Employee> showEmployeesAndTheirProjects = service.showEmployeesAndTheirProjects();
//			showEmployeesAndTheirProjects.forEach(Employee->{
//				System.out.println(Employee);
//				
//				Set<Project> projects = Employee.getProjects();
//				System.out.println("Projects: ");
//				projects.forEach(project->{
//					System.out.println(project);
//				});
//				System.out.println("===========================");
//			});
			
			
			List<Project> showProjectsAndTheirEmployees = service.showProjectsAndTheirEmployees();
			showProjectsAndTheirEmployees.forEach(Project->{
				System.out.println(Project);
				
				Set<Employee> employees = Project.getEmployees();
				System.out.println("Employees: ");
				employees.forEach(employee->{
					System.out.println(employee);
				});
				System.out.println("=========================");
			});	
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
