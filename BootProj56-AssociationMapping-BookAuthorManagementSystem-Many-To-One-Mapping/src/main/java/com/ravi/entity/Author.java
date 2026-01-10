package com.ravi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="AM_MTO_AUTHOR")
public class Author {

	public Author() {
		System.out.println("Author:0 param constructor");
	}

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "Author_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NonNull
	@Column(length = 20) 
	private String name;
	
	@NonNull
	@Column(length = 20)
	private String country;

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
}
