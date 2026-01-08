package com.ravi.runner;

import java.time.LocalDateTime;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import com.ravi.BootProj43SpbDataJpaProj9FinderQueryMethodApplication;
import com.ravi.entity.Course;
import com.ravi.repository.ICourseRepository;
import com.ravi.service.CourseService;

@Component
public class CourseRunner implements CommandLineRunner {

    private final BootProj43SpbDataJpaProj9FinderQueryMethodApplication bootProj43SpbDataJpaProj9FinderQueryMethodApplication;

	@Autowired
	CourseService courseService;
	
	@Autowired
	ICourseRepository courseRepository;

    CourseRunner(BootProj43SpbDataJpaProj9FinderQueryMethodApplication bootProj43SpbDataJpaProj9FinderQueryMethodApplication) {
        this.bootProj43SpbDataJpaProj9FinderQueryMethodApplication = bootProj43SpbDataJpaProj9FinderQueryMethodApplication;
    }
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			
//			Course save = courseRepository.save(new Course("DEVSECOPS", "MR.NATRAZ",Period.of(0, 1, 0) , 1000.0, false));
//			System.out.println(save);
			
//			Iterable<Course> showhAllActiveCourses = courseService.showhAllActiveCourses(true);
//			showhAllActiveCourses.forEach(System.out::println);
			
//			Iterable<Course> showCoursesByInstructor = courseService.showCoursesByInstructor("RAVI");
//			showCoursesByInstructor.forEach(System.out::println);
			
//			Iterable<Course> showhCoursesByFeeLessThanGivenAmount = courseService.showhCoursesByFeeLessThanGivenAmount(5000.0);
//			showhCoursesByFeeLessThanGivenAmount.forEach(System.out::println);
			
			
//			Iterable<Course> showCoursesByTitle = courseService.showCoursesByTitle("JAVA");
//			showCoursesByTitle.forEach(System.out::println);
			
//			Iterable<Course> showCoursesByInstructorAndActive = courseService.showCoursesByInstructorAndActive("MR.NATRAZ", true);
//			showCoursesByInstructorAndActive.forEach(System.out::println);
			
			
//			Integer countTotalCourses = courseService.CountTotalCourses();
//			System.out.println("Total records: "+countTotalCourses);
			
//			Double averageCourseFee = courseService.averageCourseFee();
//			System.out.println("Average course fee: "+averageCourseFee);
			
			
//			Double maximumCourseFee = courseService.maximumCourseFee();
//			System.out.println("Maximum course fee: "+maximumCourseFee);
			
//			Integer countAllCoursesByInstructor = courseService.countAllCoursesByInstructor("MR.NATRAZ");
//			System.out.println("All courses by instructor: "+countAllCoursesByInstructor);
			
//			String changeCourseFeeByCourseId = courseService.changeCourseFeeByCourseId(4000.0,1011);
//			System.out.println(changeCourseFeeByCourseId);
			
//			String updateCourseFeeByPercentageForLongDurationCourse = courseService.updateCourseFeeByPercentageForLongDurationCourse(10.0,Period.of(0, 3, 0));
//			System.out.println(updateCourseFeeByPercentageForLongDurationCourse);
			
//			String removeInactiveCourses = courseService.removeInactiveCourses(false);
//			System.out.println(removeInactiveCourses);
			
//			String removeCoursesByInstructor = courseService.removeCoursesByInstructor("MR.NATRAZ");
//			System.out.println(removeCoursesByInstructor);
			
			
//			Iterable<Course> showCoursesOrderedByFeeInDesc = courseService.showCoursesOrderedByFeeInDesc();
//			showCoursesOrderedByFeeInDesc.forEach(System.out::println);
			
			Page<Course> fetchTopThreeHighestCourses = courseService.showTopThreeHighestCourses(PageRequest.of(0, 3));
			fetchTopThreeHighestCourses.forEach(System.out::println);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
