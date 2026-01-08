package com.ravi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ravi.entity.Employee;

public interface IEmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

}
