package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Student;

public interface IStudentRepository extends JpaRepository<Student,Integer> {

}
