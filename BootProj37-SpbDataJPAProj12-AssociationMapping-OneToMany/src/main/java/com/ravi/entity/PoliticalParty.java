package com.ravi.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Setter
@Getter
@Table(name = "AM_OTM_POLOTICAL_PARTY ")
@AllArgsConstructor
@RequiredArgsConstructor
public class PoliticalParty {

	public PoliticalParty() {
		System.out.println("PoliticalParty: 0 param constructor.");
	}

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "Political_Party_seq",initialValue = 1001,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer partyId;
	
	@NonNull
	@Column(length = 30)
	private String partyName;
	
	@NonNull
	@Column(length = 30)
	private String partySymbol;
	
	@OneToMany(targetEntity = Politician.class,cascade =CascadeType.ALL,mappedBy = "party" )
	//@JoinColumn(name="P_ID",referencedColumnName = "PARTYID")
	private Set<Politician> politician;//collection of HAS-A property to build many to one association
	
	//toString
	
	@Override
	public String toString() {
		return "PoliticalParty [partyId=" + partyId + ", partyName=" + partyName + ", partySymbol=" + partySymbol + "]";
	}	
}
