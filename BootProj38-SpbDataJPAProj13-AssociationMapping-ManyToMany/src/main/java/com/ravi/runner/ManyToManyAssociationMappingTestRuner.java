package com.ravi.runner;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Faculty;
import com.ravi.entity.Student;
import com.ravi.service.ICollegeMgmtService;

@Component
public class ManyToManyAssociationMappingTestRuner implements CommandLineRunner {

	@Autowired
	
	ICollegeMgmtService service;
	
	
	@Override
	public void run(String... args) throws Exception {
//		try {
//			
//			Faculty faculty1=new Faculty("Natraz", "Hyd");
//			Faculty faculty2=new Faculty("Ravishankar", "Jha");
//			
//			Student student1=new Student("Ravi", "MCA");
//			Student student2=new Student("Amit", "MCA");
//			Student student3=new Student("Rajesh", "B.Tech");
//			
//			faculty1.getStudents().add(student1);
//			faculty1.getStudents().add(student2);
//			
//			faculty2.getStudents().add(student1);
//			faculty2.getStudents().add(student2);
//			faculty2.getStudents().add(student3);
//		
//			String saveFacultiesAndHisStudent = service.saveFacultiesAndHisStudent(List.of(faculty1,faculty2));
//			System.out.println(saveFacultiesAndHisStudent);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			
//			Faculty faculty1=new Faculty("Kishor", "AP");
//			Faculty faculty2=new Faculty("Sudhakar", "HYD");
//			
//			Student student1=new Student("Ajit", "B.Tech");
//			Student student2=new Student("Sonu", "MCA");
//			Student student3=new Student("Deewakar", "MCA");
//			
//			student1.getFaculties().add(faculty1);
//			student1.getFaculties().add(faculty2);
//			
//			student2.getFaculties().add(faculty1);
//			student2.getFaculties().add(faculty2);
//			
//			student3.getFaculties().add(faculty1);
//		
//			String saveStudentAndTheirFaculty = service.saveStudentAndTheirFaculty(List.of(student1,student2,student3));
//			System.out.println(saveStudentAndTheirFaculty);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
		
		
		
		
		
		
//		try {
//			List<Faculty> showAllFacultiesAndTheirStudents = service.showAllFacultiesAndTheirStudents();
//			showAllFacultiesAndTheirStudents.forEach(faculty->{
//				System.out.println("Faculty: "+faculty);
//				Set<Student> students = faculty.getStudents();
//				students.forEach(student->{
//					System.out.println(student);
//				});
//				System.out.println("===================");
//			});
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			List<Student> showAllStudentsAndTheirFaculties = service.showAllStudentsAndTheirFaculties();
			showAllStudentsAndTheirFaculties.forEach(student->{
				System.out.println("Student: "+student);
				
				Set<Faculty> faculties = student.getFaculties();
				faculties.forEach(faculty->{
					System.out.println(faculties);
				});
				System.out.println("====================");
			});
		}catch (Exception e) {
			
		}
	
	}

}
