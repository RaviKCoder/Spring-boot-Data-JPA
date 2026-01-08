package com.ravi.repository;

import org.springframework.data.repository.CrudRepository;

import com.ravi.entity.Course;

public interface ICourseRepository extends CrudRepository<Course, Integer> {

}
