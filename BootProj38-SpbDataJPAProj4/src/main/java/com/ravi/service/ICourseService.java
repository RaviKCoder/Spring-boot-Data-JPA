package com.ravi.service;

import java.util.List;
import java.util.Optional;

import com.ravi.entity.Course;

public interface ICourseService {

	public String saveSingleCourse(Course course);
	
	public String saveMultipleCourse(List<Course> list);
	
	public Optional<Course> fetchCourseById(Integer id);
	
	public Iterable<Course> fetchAll();
	
	public Iterable<Course> fetchSelectedCourses(List<Integer> list);
	
	public Boolean checkCourseExistence(Integer id);
	
	public String updateCourseFee(Integer courseId,Double newFee);
	
	public String deleteCourseById(Integer id);
	
	public String deleteCourseUsingEntity(Course course);
	
	public String deleteMultipleCourses(List<Integer> ids);
	
	public String deleteAllCourses();	
}
