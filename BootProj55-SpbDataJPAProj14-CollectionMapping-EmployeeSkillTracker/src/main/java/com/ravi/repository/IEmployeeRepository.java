package com.ravi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ravi.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
	
//	@Query("SELECT e FROM Employee e JOIN e.skills s WHERE s = ?1")//for single skill
	@Query("SELECT e FROM Employee e JOIN e.skills s WHERE s IN(?1)")//for multiple skills
			public List<Employee> findBySkills(List<String> skill);


}
