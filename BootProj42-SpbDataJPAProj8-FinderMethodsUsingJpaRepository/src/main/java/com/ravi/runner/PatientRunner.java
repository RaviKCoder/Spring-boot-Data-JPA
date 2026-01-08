package com.ravi.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Patient;
import com.ravi.repository.IPatientRepository;

@Component
public class PatientRunner implements CommandLineRunner {

	@Autowired
	IPatientRepository patientRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		try {
			
//			Patient save = patientRepository.save(new Patient("AJIT", "FEVER", "MR.AK", 30, LocalDate.of(2025, 12, 25), true));
//			System.out.println(save);

//			Iterable<Patient> byDisease = patientRepository.findByDisease("DIABETES");
//			byDisease.forEach(System.out::println);
			
//			Iterable<Patient> byDoctorName = patientRepository.findByDoctorName("MR.SK");
//			byDoctorName.forEach(System.out::println);
			
//			Iterable<Patient> byAgeGreaterThan = patientRepository.findByAgeGreaterThan(20);
//			byAgeGreaterThan.forEach(System.out::println);
			
//			Iterable<Patient> byAdmissionDateAfter = patientRepository.findByAdmissionDateAfter(LocalDate.of(2025, 12, 10));
//			byAdmissionDateAfter.forEach(System.out::println);
			
			Iterable<Patient> byDischargedIsNot = patientRepository.findByDischarged(false);
			byDischargedIsNot.forEach(System.out::println);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
