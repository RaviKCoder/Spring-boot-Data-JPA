package com.ravi.service;

import java.util.List;

import com.ravi.entity.Faculty;
import com.ravi.entity.Student;

public interface ICollegeMgmtService {
	
	public String saveFacultiesAndHisStudent(List<Faculty> faculties);
	
	public String saveStudentAndTheirFaculty(List<Student> students);
	
	public List<Faculty> showAllFacultiesAndTheirStudents();
	
	public List<Student> showAllStudentsAndTheirFaculties();

}
