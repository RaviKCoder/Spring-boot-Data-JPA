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

@Entity
@Data
@Table(name = "Employee_Onboarding")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "Employee_Onboarding_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer id;

	@NonNull
	@Column(length = 30)
	private String name;

	@NonNull
	@Column(length = 30)
	private String email;

	@NonNull
	@Column(length = 30)
	private String department;

	@NonNull
	private Double salary;

	@NonNull
	private LocalDate dateOfJoining;
	
}
