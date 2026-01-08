package com.ravi.repository;

import java.time.Period;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ravi.entity.Course;

public interface ICourseRepository extends JpaRepository<Course,Integer> {
	
	@Query("FROM Course WHERE active=:activeOrNot")
	public Iterable<Course> fetchAllActiveCourses(Boolean activeOrNot);
	
	@Query("FROM Course WHERE instructor=?1")
	public Iterable<Course> fetchCoursesByInstructor(String instructorName);
	
	@Query("FROM Course WHERE fee<:amount")
	public Iterable<Course> fetchCoursesByFeeLessThanGivenAmount(Double amount);
	
	@Query("FROM Course WHERE title like ?1")
	public Iterable<Course> fetchCoursesByTitle(String bookTitle);
	
	@Query("FROM Course WHERE instructor=:instructorName AND active=:activeOrNot")
	public Iterable<Course> fetchCoursesByInstructorAndActive(String instructorName,Boolean activeOrNot);
	
	@Query("SELECT count(*) FROM Course")
	public Integer countTotalCourses();
	
	@Query("SELECT AVG(fee) from Course")
	public Double getAverageCourseFee();
	
	@Query("SELECT MAX(fee) from Course")
	public Double getMaximumCourseFee();
	
	@Query("SELECT COUNT(*) FROM Course WHERE instructor=?1")
	public Integer countCoursesByInstructor(String instructorName);
	
	@Transactional
	@Modifying
	@Query("UPDATE Course SET fee=?1 where id=?2")
	public void updateCourseFeeByCourseId(Double newFee,Integer CourseId);
	
	@Transactional
	@Modifying
	@Query("UPDATE Course SET fee=fee+(fee*?1/100) where duration>=?2")
//								or
//	@Query("UPDATE Course SET fee=fee+(fee*:x/100) where duration>=:y")
	public void updateCourseFeeByPercentageForLongDurationCourse(Double percentage,Period timeDuration);
	
	@Transactional
	@Modifying
	@Query(value=("DELETE FROM COURSES_DETAILS WHERE ACTIVE=?1"),nativeQuery=true)
	public void deleteInactiveCourses(Boolean activeOrNot);
	
	@Transactional
	@Modifying
	@Query(value=("DELETE FROM COURSES_DETAILS WHERE INSTRUCTOR=?1"),nativeQuery=true)
	public void deleteCoursesByInstructor(String InstructorName);
	

	@Query("FROM Course ORDER BY fee DESC")
	public Iterable<Course> fetchCoursesOrderedByFeeInDesc();
	
	@Query("from Course order by fee desc")
	public Page<Course> fetchTopThreeHighestCourses(Pageable pageable);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
