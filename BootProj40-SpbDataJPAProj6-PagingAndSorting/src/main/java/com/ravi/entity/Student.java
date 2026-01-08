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
@Table(name = "STUDENT_RESULT")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "seq11",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private Integer id;
	
	@NonNull
	@Column(name = "NAME",length = 20)
	private String name;
	
	@NonNull
	@Column(name="COURSE",length = 20)
	private String course;
	
	@NonNull
	@Column(name = "MARKS")
	private Integer marks;
	
	@NonNull
	@Column(name = "GRADE",length = 1)
	private String grade;
	
}
