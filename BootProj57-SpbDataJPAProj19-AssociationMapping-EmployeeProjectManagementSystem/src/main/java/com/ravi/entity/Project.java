package com.ravi.entity;


import java.time.Period;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MTOM_PROJECT")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Project {
	
	

	public Project() {
		super();
		System.out.println("Project::0 param Constructor");
	}

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "ProjId_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer projectId;
	
	@NonNull
	@Column(length = 30)
	private String projectName;
	
	@NonNull
	@Column(length = 30)
	private String clientName;
	
	@NonNull
	private Period duration;
	
	@ManyToMany(targetEntity = Employee.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "projects")
	private Set<Employee> employees=new HashSet<Employee>();

	//toString
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", clientName=" + clientName
				+ ", duration=" + duration + "]";
	}
	
	
	
	
}
