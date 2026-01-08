package com.ravi.service;

import com.ravi.entity.Patient;

public interface IPatientService {

	public Patient savePatient(Patient patient);
	
	public Iterable<Patient> loadsPatientRecord();
	
	public String updateDiagnosisAndTreatment(Integer id,String newDiagnosis,String newTreatment);
	
	
	
}
