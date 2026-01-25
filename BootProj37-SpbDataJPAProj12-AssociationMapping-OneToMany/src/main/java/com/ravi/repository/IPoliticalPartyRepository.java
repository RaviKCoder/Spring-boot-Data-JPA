package com.ravi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ravi.entity.PoliticalParty;

public interface IPoliticalPartyRepository extends JpaRepository<PoliticalParty, Integer> {

	//@Query("select p.partyId,p.partyName,p.partySymbol,pl.pid,pl.pname,pl.paddrs,pl.age from PoliticalParty p inner join  p.politician pl")
	//@Query("select p.partyId,p.partyName,p.partySymbol,pl.pid,pl.pname,pl.paddrs,pl.age from PoliticalParty p left join  p.politician pl")
	//@Query("select p.partyId,p.partyName,p.partySymbol,pl.pid,pl.pname,pl.paddrs,pl.age from PoliticalParty p right join  p.politician pl")
	@Query("select p.partyId,p.partyName,p.partySymbol,pl.pid,pl.pname,pl.paddrs,pl.age from PoliticalParty p full join  p.politician pl")
	public List<Object[]> showPartyAndPoliticianDataUsingJoins();
	
}
