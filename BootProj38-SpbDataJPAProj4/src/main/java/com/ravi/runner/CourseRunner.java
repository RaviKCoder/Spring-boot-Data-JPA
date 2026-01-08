package com.ravi.runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Course;
import com.ravi.service.ICourseService;

@Component
public class CourseRunner implements CommandLineRunner {

 

	@Autowired
	
	ICourseService courseService;
	
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void run(String... args) throws Exception {
		
		while(true) {
			
			try {
				
				System.out.println("1.Add a single course");
				System.out.println("2.Add multiple courses");
				System.out.println("3.Fetch course by ID");
				System.out.println("4.Fetch all courses");
				System.out.println("5.Fetch selected courses");
				System.out.println("6.Check course existence");
				System.out.println("7.Update course fee");
				System.out.println("8.Delete course by ID");
				System.out.println("9.Delete course using entity");
				System.out.println("10.Delete multiple courses");
				System.out.println("11.Delete all courses");
				System.out.println("12.Exit");
				System.out.println("=========================");
				System.out.print("Select your choice: ");
				
				Integer choice=Integer.parseInt(sc.next());
				
				switch(choice) {
				
				case 1:
					
					System.out.print("enter course name: ");
					String name=sc.next();
					
					System.out.print("enter instructor: ");
					String instructor=sc.next();
					
					System.out.print("enter fee: ");
					Double fee=Double.parseDouble(sc.next());
					
					System.out.print("enter duration");
					String duration=sc.next();
					
					System.out.print("available or not");
					Boolean available=Boolean.parseBoolean(sc.next());
					
					String saveSingleCourse = courseService.saveSingleCourse(new Course(name.toUpperCase(), instructor.toUpperCase(), fee, duration.toUpperCase(), available));
					System.out.println(saveSingleCourse);
					break;
					
				case 2:
					
					System.out.print("how many course u want to insert: ");
					Integer noOfCourse=Integer.parseInt(sc.next());
					
					List<Course> list=new ArrayList<Course>();
					
					for(int i=1;i<=noOfCourse;i++) {
						
						System.out.print("enter course"+i+" name: ");
						name=sc.next();
						
						System.out.print("enter course"+i+"  instructor: ");
						instructor=sc.next();
						
						System.out.print("enter course"+i+"  fee: ");
						fee=Double.parseDouble(sc.next());
						
						System.out.print("enter course"+i+"  duration");
						duration=sc.next();
						
						System.out.print("enter course"+i+"  available or not");
						available=Boolean.parseBoolean(sc.next());
						
						Course course=new Course(name.toUpperCase(), instructor.toUpperCase(), fee, duration.toUpperCase(), available);
						
						list.add(course);
							
					}
					
					String saveMultipleCourse = courseService.saveMultipleCourse(list);
					System.out.println(saveMultipleCourse);
					break;
					
				case 3:
					
					System.out.print("enter course id: ");
					Integer id=Integer.parseInt(sc.next());
					
					Optional<Course> fetchCourseById = courseService.fetchCourseById(id);
					
					if(fetchCourseById.isPresent()) {
						System.out.println(fetchCourseById);
					}else {
						System.out.println("course not found");
					}
					
					break;
					
				case 4:
					
					Iterable<Course> fetchAll = courseService.fetchAll();
					
					long count = StreamSupport.stream(fetchAll.spliterator(), false).count();
					
					if(count!=0) {
						fetchAll.forEach(System.out::println);
					}else {
						System.out.println("No any record available");
					}
					break;
					
				case 5: 
					
					System.out.print("how many course u want to fetch: ");
					Integer selectedCourse=Integer.parseInt(sc.next());
					
					List<Integer> ids=new ArrayList<Integer>(); 
					
					for(int i=1;i<=selectedCourse;i++) {
						
						System.out.print("enter course "+i+" id :");
						
						Integer courseId=Integer.parseInt(sc.next());
						
						ids.add(courseId);	
					}
					
					Iterable<Course> fetchSelectedCourses = courseService.fetchSelectedCourses(ids);
					fetchSelectedCourses.forEach(System.out::println);
					break;
					
					
				case 6:
					
					System.out.print("enter course id: ");
					id=Integer.parseInt(sc.next());
					
					Boolean checkCourseExistence = courseService.checkCourseExistence(id);
					
					System.out.println("course exist: "+checkCourseExistence);
					break;
										
				case 7:
					
					System.out.print("enter course id: ");
					id=Integer.parseInt(sc.next());
					
					System.out.print("enter course new fee: ");
					Double newFee=Double.parseDouble(sc.next());
					
					String updateCourseFee = courseService.updateCourseFee(id, newFee);
					
					System.out.println(updateCourseFee);
					break;
					
				case 8:
					
					System.out.print("enter course id: ");
					id=Integer.parseInt(sc.next());
					
					String deleteCourseById = courseService.deleteCourseById(id);
					System.out.println(deleteCourseById);
					break;
					
				case 9:
					
					System.out.println("which course u want to delete , insert that course details: ");
					
					System.out.print("enter course id: ");
					
					id=Integer.parseInt(sc.next());
					
					System.out.print("enter course name: ");
					name=sc.next();
					
					System.out.print("enter instructor: ");
					instructor=sc.next();
					
					System.out.print("enter fee: ");
					fee=Double.parseDouble(sc.next());
					
					System.out.print("enter duration");
					duration=sc.next();
					
					System.out.print("available or not");
					available=Boolean.parseBoolean(sc.next());
					
					Course course=new Course(id, name.toUpperCase(), instructor.toUpperCase(), fee, duration.toUpperCase(), available);
					
					String deleteCourseUsingEntity = courseService.deleteCourseUsingEntity(course);
					System.out.println(deleteCourseUsingEntity);
					break;
					
				case 10:
					
					System.out.print("how many course u want to delete: ");
					Integer deleteCourse=Integer.parseInt(sc.next());
					
					ids=new ArrayList<Integer>(); 
					
					for(int i=1;i<=deleteCourse;i++) {
						
						System.out.print("enter course "+i+" id :");
						
						Integer courseId=Integer.parseInt(sc.next());
						
						ids.add(courseId);
					}
					
					String deleteMultipleCourses = courseService.deleteMultipleCourses(ids);
					System.out.println(deleteMultipleCourses);
					break;
					
				case 11:
					
					String deleteAllCourses = courseService.deleteAllCourses();
					System.out.println(deleteAllCourses);
					break;
					
				case 12:
					
					System.out.println("Thankyou......");
					System.exit(0);
					
				default :
					
					throw new IllegalAccessException("Invalid choice.");
				
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
		}
			
	}

}
