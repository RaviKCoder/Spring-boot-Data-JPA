package com.ravi.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "EMPLOYEE_SKILL_TRACKER")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "Employee_skills_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer empId;
	
	@NonNull
	@Column(name = "EMP_NAME",length = 20)
	private String empName;
	
	@NonNull
	@Column(name = "EMP_SKILLS")
	@ElementCollection
	@CollectionTable(name = "EMPLOYEE_SKILLS",joinColumns = @JoinColumn(name="EMPLOYEE_ID",referencedColumnName ="empId" ))
	private List<String> skills;
	
	@NonNull
	@Column(name = "EMP_CERTIFICATIONS")
	@ElementCollection
	@CollectionTable(name = "EMPLOYEE_CERTIFICATION",joinColumns = @JoinColumn(name="EMPLOYEE_ID",referencedColumnName = "empId"))
	private Set<String> certifications;
	
	@NonNull
	@Column(name = "EMP_PROJECT_RATINGS")
	@ElementCollection
	@CollectionTable(name = "EMPLOYEE_PROJECT_RATING",joinColumns = @JoinColumn(name="EMPLOYEE_ID",referencedColumnName = "empId"))
	@MapKeyColumn(name="PROJECT_NAME")
	private Map<String, String> projectRatings;
}
