package com.ravi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ravi.entity.Course;
import com.ravi.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {

    

	@Autowired
	private ICourseRepository courseRepository;
	
	@Override
	public String saveSingleCourse(Course course) {
		Course save = courseRepository.save(course);
		return "sinle course inserted successfully with id: "+save.getCourseId();
	}

	@Override
	public String saveMultipleCourse(List<Course> list) {
		courseRepository.saveAll(list);
		return "multiple courses inserted successfuly";
	}

	@Override
	public Optional<Course> fetchCourseById(Integer id) {
		Optional<Course> byId = courseRepository.findById(id);
		
		return byId;	
	}

	@Override
	public Iterable<Course> fetchAll() {
		Iterable<Course> all = courseRepository.findAll();
		return all;
	}

	@Override
	public Iterable<Course> fetchSelectedCourses(List<Integer> list) {
		Iterable<Course> allById = courseRepository.findAllById(list);
		return allById;
	}

	@Override
	public Boolean checkCourseExistence(Integer id) {
		boolean existsById = courseRepository.existsById(id);
		return existsById;
	}

	@Override
	public String updateCourseFee(Integer courseId, Double newFee) {
		//Load the object
		Optional<Course> byId = courseRepository.findById(courseId);
		//update the object
		if(byId.isPresent()) {
			
			Course course = byId.get();
			
			course.setFee(newFee);
			
			Course save = courseRepository.save(course);
			
			return "course fee is updated successfully with id: "+save.getCourseId();
		}
			return "course not found";
		
	}

	@Override
	public String deleteCourseById(Integer id) {
		
		//Load the object
		Optional<Course> byId = courseRepository.findById(id);
		//delete the object
		if(byId.isPresent()) {
			courseRepository.deleteById(id);
			return "course deleted successfully by id: "+id;
		}
		return "course not found ";
	}

	@Override
	public String deleteCourseUsingEntity(Course course) {
		
		//Load the object
		Optional<Course> byId = courseRepository.findById(course.getCourseId());
		//delete the object
		if(byId.isPresent()) {
			
			courseRepository.delete(course);
			
			return "course is deleted successfully by entity:";
		}
		courseRepository.save(course);
		return "course saved successfully with id: "+course.getCourseId();
		
	}

	@Override
	public String deleteMultipleCourses(List<Integer> ids) {
		courseRepository.deleteAllById(ids);
		return "multiple courses deleted successfully by ids: "+ids.toString();
	}

	@Override
	public String deleteAllCourses() {
		courseRepository.deleteAll();
		return "All courses deleted successfully";
	}

}
