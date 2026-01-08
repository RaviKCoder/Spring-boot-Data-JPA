package com.ravi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "EMPLOYEES_FOR_PAGINATION")
public class Employee {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "NAME",length = 20)
	private String name;
	
	@Column(name = "DEPARTMENT",length = 20)
	private String department;
	
	private Double salary;
	
	@Column(name = "DATE_OF_JOINING",length = 20)
	private String dateOfJoining;
}
