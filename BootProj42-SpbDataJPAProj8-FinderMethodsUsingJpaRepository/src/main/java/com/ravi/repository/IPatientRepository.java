package com.ravi.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Integer>{

	public Iterable<Patient> findByDisease(String disease);
	
	public Iterable<Patient> findByDoctorName(String doctor);
	
	public Iterable<Patient> findByAgeGreaterThan(Integer age);
	
	public Iterable<Patient> findByAdmissionDateAfter(LocalDate date);
	
	public Iterable<Patient> findByDischarged(Boolean discharge);
	
}
