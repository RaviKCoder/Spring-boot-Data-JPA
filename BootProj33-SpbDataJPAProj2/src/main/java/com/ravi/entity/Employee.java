package com.ravi.entity;

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
@Table(name="EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
	
	@Column(name="ID")
	@Id
	@SequenceGenerator(name = "gen1" , sequenceName = "seq",initialValue =101, allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	Integer id;

	@Column(name="NAME",length = 20)
	@NonNull
	String name;

	@Column(name="DEPARTMENT",length = 20)
	@NonNull
	String department;

	@Column(name="SALARY")
	@NonNull
	Double salary;



}
