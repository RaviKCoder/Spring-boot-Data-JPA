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
	@Table(name="COURSE_DETAILS")
	@AllArgsConstructor
	@NoArgsConstructor
	@RequiredArgsConstructor
	public class Course {
		
		@Id
		@SequenceGenerator(name = "gen1",sequenceName = "seq",initialValue = 1001,allocationSize = 1)
		@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
		@Column(name = "COURSEID")
		Integer courseId;
	
		@Column(name = "COURSENAME",length = 30)
		@NonNull
		String courseName;
	
		@Column(name = "INSTRUCTOR",length = 30)
		@NonNull
		String instructor;
	
		@Column(name = "FEE")
		@NonNull
		Double fee;
	
		@Column(name = "DURATION",length = 30)
		@NonNull
		String duration;
	
		@Column(name = "AVAILABLE")
		@NonNull
		Boolean available;
	}
