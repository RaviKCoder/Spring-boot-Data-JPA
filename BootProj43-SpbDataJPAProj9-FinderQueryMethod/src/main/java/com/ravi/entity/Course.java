package com.ravi.entity;

import java.time.LocalDateTime;
import java.time.Period;

import org.antlr.v4.runtime.misc.Interval;

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

@Data
@Entity
@Table(name = "COURSES_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {
	
	
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "course_seq1",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Integer id;
	
	@NonNull
	@Column(name = "TITLE",length = 20)
	private String title;
	
	@NonNull
	@Column(name = "INSTRUCTOR",length = 20)
	private String 	instructor;
	
	
	@NonNull
	@Column(name = "DURATION",length = 50)
	private Period duration;
	
	@NonNull
	@Column(name = "FEE")
	private Double fee;
	
	@NonNull
	@Column(name = "ACTIVE")
	private Boolean active;

}
