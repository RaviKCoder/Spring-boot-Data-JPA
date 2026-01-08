package com.ravi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravi.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient,Integer> {

}
