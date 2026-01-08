package com.ravi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ravi.entity.Student;

public interface IStudentRepository extends CrudRepository<Student, Integer>, PagingAndSortingRepository<Student, Integer> {

}
