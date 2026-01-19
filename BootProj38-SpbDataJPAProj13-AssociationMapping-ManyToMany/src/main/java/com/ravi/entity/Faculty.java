//Faculty.java
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
@Table(name = "MTOM_FACULTY")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Faculty {

	public Faculty() {
		super();
		System.out.println("0:param constructor");
	}

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "Faculty_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer fid;
	
	@NonNull
	@Column(length = 30)
	private String fname;
	
	@NonNull
	@Column(length = 30)
	private String addrs;
	
	
	@ManyToMany(targetEntity = Student.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "MTOM_FACULTIES_STUDENTS",//third table
				joinColumns = @JoinColumn(name="faculty_id",referencedColumnName = "fid"),//owning side FK column
				inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "sid"))//non owning FK column
	private Set<Student> students=new HashSet<Student>();

//toString 
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fname=" + fname + ", addrs=" + addrs + "]";
	}
}
