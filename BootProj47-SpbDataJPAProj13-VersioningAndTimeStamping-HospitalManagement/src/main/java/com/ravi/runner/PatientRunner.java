package com.ravi.runner;
import com.ravi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Patient;
import com.ravi.service.IPatientService;

@Component
public class PatientRunner implements CommandLineRunner {

    private final PatientService patientService_1;

	@Autowired
	IPatientService patientService;

    PatientRunner(PatientService patientService_1) {
        this.patientService_1 = patientService_1;
    }
	
	@Override
	public void run(String... args) throws Exception {
		try {
			
//			Patient savePatient = patientService.savePatient(new Patient("Influenza", "Rest"));
//			System.out.println(savePatient);
			
//			Iterable<Patient> loadsPatientRecord = patientService.loadsPatientRecord();
//			loadsPatientRecord.forEach(System.out::println);
			
			String updateDiagnosisAndTreatment = patientService.updateDiagnosisAndTreatment(1005, "Hypertension","Medication");
			System.out.println(updateDiagnosisAndTreatment);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
