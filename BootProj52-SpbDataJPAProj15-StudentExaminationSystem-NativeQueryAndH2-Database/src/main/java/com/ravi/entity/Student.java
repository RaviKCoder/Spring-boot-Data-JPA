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
@Table(name ="Student_Examination" )
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "Student_Examination_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer rollNo;

	@NonNull
	@Column(length = 20)
	private String name;

	@NonNull
	@Column(length = 20)
	private String studentClass;

	@NonNull
	private Integer marks;

	@NonNull
	@Column(length = 20)
	private String result;

	@NonNull
	private Integer examYear;	
}
