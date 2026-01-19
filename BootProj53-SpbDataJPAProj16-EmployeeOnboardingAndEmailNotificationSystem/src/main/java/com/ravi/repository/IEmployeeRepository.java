package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {

}
