package com.ravi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.Patient;
import com.ravi.exception.PatientNotFoundException;
import com.ravi.repository.IPatientRepository;

@Service
public class PatientService implements IPatientService {

	@Autowired
	IPatientRepository patientRepository;
	
	@Override
	public Patient savePatient(Patient patient) {
		Patient save = patientRepository.save(patient);
		return save;
	}

	@Override
	public Iterable<Patient> loadsPatientRecord() {
		List<Patient> all = patientRepository.findAll();
		return all;
	}

	

	@Override
	public String updateDiagnosisAndTreatment(Integer id, String newDiagnosis, String newTreatment) {
		Patient patient = patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("Invalid patient id."));
		
		patient.setDiagnosis(newDiagnosis);
		patient.setTreatment(newTreatment);

		Patient save = patientRepository.save(patient);
		return "diagnosis updated successfully with id:"+save.getPatientId();
		
	}



}
