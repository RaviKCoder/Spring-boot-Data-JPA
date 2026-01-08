package com.ravi.repository;

import org.springframework.data.repository.CrudRepository;

import com.ravi.entity.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer>{

}
