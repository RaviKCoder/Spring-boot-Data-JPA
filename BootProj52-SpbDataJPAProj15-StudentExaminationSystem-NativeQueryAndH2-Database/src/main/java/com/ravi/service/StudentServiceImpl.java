package com.ravi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.Student;
import com.ravi.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentRepository repository;
	
	@Override
	public void addStudent(Student student) {
		Student save = repository.save(student);
		System.out.println("single student record save successfully.");
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> all = repository.findAll();
		return all;
	}

	@Override
	public Student getStudentByRollNo(Integer rollNo) {
		
		return repository.findByRollNo(rollNo);
	}

	@Override
	public void updateStudentMarks(Integer rollNo, Integer marks) {
		repository.updateMarks(marks, rollNo);
	}

	@Override
	public void updateStudentResult(String result,Integer rollNo) {
		repository.updateResult(result,rollNo);
	}

	@Override
	public List<Student> getPassedStudents() {
		
		return repository.findPassedStudents();
	}

	@Override
	public List<Student> getFailedStudents() {
		
		return repository.findFailedStudents();
	}

	@Override
	public List<Student> getStudentsAbove75() {
		
		return repository.findStudentsAbove75();
	}

	@Override
	public Integer getTotalStudentCount() {
		
		return repository.countTotalStudents();
	}

	@Override
	public Integer getPassStudentCount() {
		
		return repository.countPassedStudents();
	}
	
	@Override
	public Integer getFailStudentCount() {
		return repository.countFailedStudents();
	}

	@Override
	public Student getTopper() {
		
		return repository.findTopper();
	}

	@Override
	public Student getLowestMarksStudent() {
		
		return repository.findLowestMarks();
	}
}
