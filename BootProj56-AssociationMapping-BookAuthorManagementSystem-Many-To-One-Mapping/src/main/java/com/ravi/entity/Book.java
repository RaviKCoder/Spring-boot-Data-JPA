package com.ravi.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="AM_MTO_BOOK")
public class Book {

	public Book() {
		System.out.println("Book : 0 param constructor");
	}

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "Book_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@NonNull
	@Column(length = 20)
	private String title;
	
	@NonNull
	@Column(length = 20)
	private String genre;
	
	@ManyToOne
	@JoinColumn(name="A_ID",referencedColumnName = "ID")
	private Author author;

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", genre=" + genre + "]";
	}
	
}
