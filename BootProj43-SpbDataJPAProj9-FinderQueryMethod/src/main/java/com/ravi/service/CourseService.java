package com.ravi.service;

import java.time.Period;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ravi.entity.Course;
import com.ravi.repository.ICourseRepository;

@Service
public class CourseService {
	@Autowired
	ICourseRepository courseRepository;
	
	public Iterable<Course>showhAllActiveCourses(Boolean active){
		
		Iterable<Course> fetchAllActiveCourses = courseRepository.fetchAllActiveCourses(active);
		
		return fetchAllActiveCourses;
	}
	
	public Iterable<Course> showCoursesByInstructor(String instructorName){
		Iterable<Course> fetchCoursesByInstructor = courseRepository.fetchCoursesByInstructor(instructorName);
		return fetchCoursesByInstructor;	
	}
	
	public Iterable<Course> showhCoursesByFeeLessThanGivenAmount(Double amount){
		Iterable<Course> fetchCoursesByFeeLessThanGivenAmount = courseRepository.fetchCoursesByFeeLessThanGivenAmount(amount);
		
		return fetchCoursesByFeeLessThanGivenAmount;
		
	}
	
	public Iterable<Course> showCoursesByTitle(String bookTitle){
		Iterable<Course> fetchCoursesByTitle = courseRepository.fetchCoursesByTitle(bookTitle);

		return fetchCoursesByTitle;
		
	}
	
	public Iterable<Course> showCoursesByInstructorAndActive(String instructorName,Boolean activeOrNot){
	Iterable<Course> fetchCoursesByInstructorAndActive = courseRepository.fetchCoursesByInstructorAndActive(instructorName, activeOrNot);
		return fetchCoursesByInstructorAndActive;	
	}
	
	public Integer CountTotalCourses() {
		Integer countTotalCourses = courseRepository.countTotalCourses();
		return countTotalCourses;
	}
	
	public Double averageCourseFee() {
		Double averageCourseFee = courseRepository.getAverageCourseFee();
		return averageCourseFee;
	}
	
	public Double maximumCourseFee() {
		Double maximumCourseFee = courseRepository.getMaximumCourseFee();
		return maximumCourseFee;
	}
	
	public Integer countAllCoursesByInstructor(String instructorName) {
		Integer countCoursesByInstructor = courseRepository.countCoursesByInstructor(instructorName);
		return countCoursesByInstructor;
	}
	
	public String changeCourseFeeByCourseId(Double newFee,Integer courseId) {
	
			courseRepository.updateCourseFeeByCourseId(newFee,courseId);
			return "course fee updated successfully";
	}
	
	public String updateCourseFeeByPercentageForLongDurationCourse(Double percentage,Period timeDuration) {
		courseRepository.updateCourseFeeByPercentageForLongDurationCourse(percentage,timeDuration);
		return "fee increases for long duration courses";
	}

	public String removeInactiveCourses(Boolean activeOrNot) {
		courseRepository.deleteInactiveCourses(activeOrNot);
		return "Inactive courses deleted successfully";
	}
	
	
	public String removeCoursesByInstructor(String InstructorName) {
		courseRepository.deleteCoursesByInstructor(InstructorName);
		return "courses deleted successfully by instructor";
	}
	
	
	public Iterable<Course> showCoursesOrderedByFeeInDesc(){
		Iterable<Course> fetchCoursesOrderedByFeeInDesc = courseRepository.fetchCoursesOrderedByFeeInDesc();
		return fetchCoursesOrderedByFeeInDesc;
	}
	
	
	public Page<Course> showTopThreeHighestCourses(Pageable pageable){
		Page<Course> fetchTopThreeHighestCourses = courseRepository.fetchTopThreeHighestCourses(pageable);
		return fetchTopThreeHighestCourses;
	}
	
}
