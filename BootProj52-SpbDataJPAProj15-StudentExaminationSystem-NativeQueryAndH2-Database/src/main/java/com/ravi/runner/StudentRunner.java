package com.ravi.runner;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Student;
import com.ravi.service.IStudentService;

@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	IStudentService service;
	
	
	@Override
	public void run(String... args) throws Exception {
		while(true) {
			
			try {
				
				Scanner sc=new Scanner(System.in);
				
				System.out.println("1. Insert Student.");
				System.out.println("2. View All Students");
				System.out.println("3. Find Student by Roll No");
				System.out.println("4. Update Marks");
				System.out.println("5. Update Result");
				System.out.println("6. Passed Students");
				System.out.println("7. Failed Students");
				System.out.println("8. Students Above 75");
				System.out.println("9. Count Students");
				System.out.println("10. Pass Count");
				System.out.println("11.Fail Count");
				System.out.println("12. Find Topper");
				System.out.println("13. Find Lowest Marks");
				System.out.println("0. Exit");
				System.out.println("=========================");
				System.out.print("select your choice: ");
				
				int choice=Integer.parseInt(sc.nextLine());
				
				switch(choice) {
				
				case 1->{
					
					System.out.print("enter student name: ");
					String name=sc.nextLine().toUpperCase();
					
					System.out.print("enter student class: ");
					String studentClass=sc.nextLine().toUpperCase();
					
					System.out.print("enter student marks: ");
					int marks=Integer.parseInt(sc.nextLine());
					
					System.out.print("enter student result: ");
					String result=String.valueOf(sc.nextLine()).toUpperCase();
					
					System.out.print("enter student pass year: ");
					int passYear=Integer.parseInt(sc.nextLine());
					
					Student student=new Student(name, studentClass, marks, result, passYear);
					
					service.addStudent(student);
					
				}
				case 2->{
					List<Student> allStudents = service.getAllStudents();
					allStudents.forEach(System.out::println);
				}
				case 3->{
					
					System.out.print("enter student roll no: ");
					int rollno=Integer.parseInt(sc.nextLine());
					
					Student studentByRollNo = service.getStudentByRollNo(rollno);
					System.out.println(studentByRollNo);
					
				}
				case 4->{
					
					System.out.print("enter student roll no: ");
					int rollno=Integer.parseInt(sc.nextLine());
					
					System.out.print("enter student marks: ");
					int newMarks=Integer.parseInt(sc.nextLine());
					
					service.updateStudentMarks(rollno, newMarks);
					
				}
				case 5->{
					
					System.out.print("enter student roll no: ");
					int rollno=Integer.parseInt(sc.nextLine());
					
					System.out.print("enter student result: ");
					String result=String.valueOf(sc.nextLine()).toUpperCase();
					
					service.updateStudentResult(result, rollno);
				}
				case 6->{
					List<Student> passedStudents = service.getPassedStudents();
					passedStudents.forEach(System.out::println);
				}
				case 7->{
					List<Student> failedStudents = service.getFailedStudents();
					failedStudents.forEach(System.out::println);
				}
				case 8->{
					List<Student> studentsAbove75 = service.getStudentsAbove75();
					studentsAbove75.forEach(System.out::println);
				}
				case 9->{
					Integer totalStudentCount = service.getTotalStudentCount();
					System.out.println("Total student: "+totalStudentCount);
				}
				case 10->{
					Integer passStudentCount = service.getPassStudentCount();
					System.out.println("Pass student = "+passStudentCount);
				}
				case 11->{
					Integer failStudentCount = service.getFailStudentCount();
					System.out.println("Failed student = "+failStudentCount);
				}
				case 12->{
					
					Student topper = service.getTopper();
					System.out.println("Topper = "+topper);
				}
				case 13->{
					Student lowestMarksStudent = service.getLowestMarksStudent();
					System.out.println("Lowest Marks = "+lowestMarksStudent);
				}
				
				case 0->{
					System.out.println("Thankyou..........");
				}
				default ->{
					throw new IllegalArgumentException("Invalid choice");
				}

				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
		
		
		
		
		

		
		
		

	}

}
