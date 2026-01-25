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
@Table(name="AM_OTM_POLOTICIAN")
@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class Politician {
	
	

	public Politician() {
		System.out.println("Politician::0-param constructor");
	}

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "Politician_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer pid;
	
	@NonNull
	@Column(length = 20)
	private String pname;
	
	@NonNull
	@Column(length = 20)
	private String paddrs;
	
	@NonNull
	private Integer age;
	
	@ManyToOne(targetEntity = PoliticalParty.class,cascade = CascadeType.ALL)
	@JoinColumn(name="P_ID",referencedColumnName = "PARTYID")
	private PoliticalParty party;//HAS-A property to build many to one association

	//toString()
	
	@Override
	public String toString() {
		return "Politician [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + ", age=" + age + "]";
	}	
}
