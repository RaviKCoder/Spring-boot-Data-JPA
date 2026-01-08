package com.ravi.entity;

import java.time.LocalDate;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "PATIENT_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Patient {
	
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "patient_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer patientId;
	
	@NonNull
	@Column(name = "PATIENT_NAME",length = 20)
	private String patientName;
	
	@NonNull
	@Column(name = "DISEASE",length = 20)
	private String disease;
	
	@NonNull
	@Column(name = "DOCTOR_NAME",length = 20)
	private String doctorName;
	
	@NonNull
	@Column(name = "AGE")
	private Integer age;
	
	
	@NonNull
	@Column(name = "ADMISSION_DATE")
	private LocalDate admissionDate;
	
	@NonNull
	@Column(name = "DISCHARGE")
	private Boolean discharged;
	

}
