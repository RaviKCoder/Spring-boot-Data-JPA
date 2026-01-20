package com.ravi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.Faculty;
import com.ravi.entity.Student;
import com.ravi.repository.IFacultyRepository;
import com.ravi.repository.IStudentRepository;

@Service
public class CollegeMgmtServiceImpl implements ICollegeMgmtService {

	@Autowired
	IFacultyRepository facultyRepo;
	
	@Autowired
	IStudentRepository studentRepo;
	
	@Override
	public String saveFacultiesAndHisStudent(List<Faculty> faculties) {
		
		List<Faculty> saveAll = facultyRepo.saveAll(faculties);
		
		List<Integer> ids = saveAll.stream().map(Faculty::getFid).collect(Collectors.toList());
		
		
		return ids.size()+" Faculty save successfully with ids: "+ids;
	}
	
	@Override
	public String saveStudentAndTheirFaculty(List<Student> students) {
		List<Student> saveAll = studentRepo.saveAll(students);
		
		List<Integer> ids = saveAll.stream().map(Student::getSid).collect(Collectors.toList());
		
		return saveAll.size()+" students save with ids: "+ids;
	}

	
	

	@Override
	public List<Faculty> showAllFacultiesAndTheirStudents() {
		List<Faculty> all = facultyRepo.findAll();
		
		return all;
	}

	@Override
	public List<Student> showAllStudentsAndTheirFaculties() {
		List<Student> students = studentRepo.findAll();
		return students;
	}

	
	
}
