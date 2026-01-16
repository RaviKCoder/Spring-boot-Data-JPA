package com.ravi.service;

import java.util.List;

import com.ravi.entity.Student;

public interface IStudentService {

	public void addStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudentByRollNo(Integer rollNo);

    public void updateStudentMarks(Integer rollNo, Integer marks);
    public void updateStudentResult(String result,Integer rollNo);

    public List<Student> getPassedStudents();
    public List<Student> getFailedStudents();
    public List<Student> getStudentsAbove75();

    public Integer getTotalStudentCount();
    public Integer getPassStudentCount();
    public Integer getFailStudentCount();

    public Student getTopper();
    public Student getLowestMarksStudent();
	
}
