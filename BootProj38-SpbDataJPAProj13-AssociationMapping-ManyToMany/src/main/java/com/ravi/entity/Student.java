
//Student.java
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
@Table(name = "MTOM_STUDENT")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {

	public Student() {
		super();
		System.out.println("0: param constructor");		
	}


	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "Sid_sequ",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer sid;
	
	@NonNull
	@Column(length = 30)
	private String sname;
	
	@NonNull
	@Column(length = 30)
	private String squalification;
	
	@ManyToMany(targetEntity = Faculty.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "students")
	private Set<Faculty> faculties=new HashSet<Faculty>();

	
	//toString
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", squalification=" + squalification + "]";
	}

}
