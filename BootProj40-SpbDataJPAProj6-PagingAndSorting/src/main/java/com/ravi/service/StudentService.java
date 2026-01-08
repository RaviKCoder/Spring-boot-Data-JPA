package com.ravi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ravi.entity.Student;
import com.ravi.repository.IStudentRepository;

@Service
public class StudentService {
@Autowired
IStudentRepository studentRepository;

//public Student saveStudent(Student student) {
//	Student save = studentRepository.save(student);
//	return save;

public void fetchStudentsUsingPageRequest(Integer pagesize){
	
	long count = studentRepository.count();
	
	long pageCount=count/pagesize;
	
	if(count%pagesize!=0) {
		pageCount++;
	}
	for(int i=0;i<pageCount;i++) {
		Pageable pageable=PageRequest.of(i, pagesize);
		
		Page<Student> all = studentRepository.findAll(pageable);	
		all.forEach(System.out::println);
		System.out.println("==============================");
	}	
}

public Iterable<Student> fetchStudentAsSortedUsingMarks(Integer pageNo,Integer pageSize,Boolean ascOrder,String props){
	
	Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC,props);
	
	Pageable pageable=PageRequest.of(pageNo, pageSize,sort);
	
	Page<Student> all = studentRepository.findAll(pageable);
	
	return all;
	
}

public Iterable<Student> fetchStudentAsSortedUsingName(Integer pageNo,Integer pageSize,Boolean ascOrder,String props){
	
	Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC,props);
	
	Pageable pageable=PageRequest.of(pageNo, pageSize,sort);
	
	Page<Student> all = studentRepository.findAll(pageable);
	
	return all;
	
}


	
}

























