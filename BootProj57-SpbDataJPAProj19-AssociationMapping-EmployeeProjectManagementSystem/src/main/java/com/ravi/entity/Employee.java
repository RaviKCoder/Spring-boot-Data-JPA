package com.ravi.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MTOM_EMPLOYEE")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {
	public Employee() {
		super();
		System.out.println("Employee::0 param constructor");
	}

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "empid_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer employeeId; 

	@NonNull
	@Column(length = 30)
	private String name;

	@NonNull
	@Column(length = 30)
	private String designation;
	
	@NonNull
	private Double salary;
	
	@ManyToMany(targetEntity = Project.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "MTOM_EMPLOYEES_PROJECTS",
				joinColumns = @JoinColumn(referencedColumnName = "employeeId",name = "E_ID"),
				inverseJoinColumns = @JoinColumn(referencedColumnName = "projectId",name = "P_ID"))
	private Set<Project> projects=new HashSet<Project>();

	//toString
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", designation=" + designation + ", salary="
				+ salary + "]";
	}	
}
