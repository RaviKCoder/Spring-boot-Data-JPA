package com.ravi.runner;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Student;
import com.ravi.service.StudentService;

@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	StudentService studentService;
	
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void run(String... args) throws Exception {
		
		while(true) {
			
			
//			Student saveStudent = studentService.saveStudent(new Student("ANKIT", "BSC", 450, "B"));
//			System.out.println(saveStudent);	
			
			try {
				
				System.out.println("1.Fetch students using PageRequest.");
				System.out.println("2.Sort by marks");
				System.out.println("3.Sort by name");
				System.out.println("4.Exit");
				System.out.println("===========");
				System.out.print("Select your choice: ");
				
				Integer choice=Integer.parseInt(sc.next());
				switch(choice) {
				
				case 1:
					
					System.out.print("enter page size: ");
					Integer pageSize=Integer.parseInt(sc.next());
					studentService.fetchStudentsUsingPageRequest(pageSize);
					break;
					
				case 2:
					
					System.out.print("enter page number: ");
					Integer pageNo=Integer.parseInt(sc.next());
					
					System.out.print("enter page size: ");
					pageSize=Integer.parseInt(sc.next());
					
					System.out.print("In which order u want sort asc->true or desc->false:  ");
					Boolean ascOrder=Boolean.parseBoolean(sc.next());

					System.out.print("enter property name: ");
					String marks=sc.next();
					
					
					
					Iterable<Student> fetchStudentAsSortedUsingMarks = studentService.fetchStudentAsSortedUsingMarks(pageNo, pageSize, ascOrder, marks);
					
					fetchStudentAsSortedUsingMarks.forEach(System.out::println);
					break;
					
				case 3:
					
					System.out.print("enter page number: ");
					pageNo=Integer.parseInt(sc.next());
					
					System.out.print("enter page size: ");
					pageSize=Integer.parseInt(sc.next());
					
					System.out.print("In which order u want sort asc->true or desc->false:  ");
					ascOrder=Boolean.parseBoolean(sc.next());

					System.out.print("enter property name: ");
					String name=sc.next();
					
					
					
					Iterable<Student> fetchStudentAsSortedUsingName = studentService.fetchStudentAsSortedUsingName(pageNo, pageSize, ascOrder, name);
					
					fetchStudentAsSortedUsingName.forEach(System.out::println);
					break;
					
				case 4:
					System.exit(0);
					
				default :
					
					throw new IllegalArgumentException("invalid choice.");
				
				
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	
		}

		}
}
