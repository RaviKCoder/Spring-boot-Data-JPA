package com.ravi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class FileRecord {
	
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "FileRecord_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NonNull
	@Column(length = 20)
	private String fileName;

	@NonNull
	@Lob
	private byte[] fileImage;
	
	@NonNull
	@Lob
	private char[] fileText ;
}
