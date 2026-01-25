package com.ravi.service;

import java.util.List;

import com.ravi.entity.PoliticalParty;
import com.ravi.entity.Politician;

public interface IPoliticalPartyService {
	
	public String savePoliticalPartyAndPolitician(PoliticalParty party);	
	public String savePoliticiansAndPoliticalParty(Politician politician1,Politician politician2);
	public List<PoliticalParty> showAllPoliticalPartyAndPolitician();
	public List<Politician> showAllPoliticianAndTheirParties();
	public String deletePartyAndItsPoliticianByPartyId(int partyId);
	public String deleteAllPoliticiansOfAPartyByPartyId(int partyId);
	public String removePoliticianFromParty(int pltcnId);
	public String addNewPoliticianToParty(int partyId,Politician politician);
	public String changePoliticianFromOnePartyToAnotherParty(int politicianId,int partyId);
	public String deleteAllChildsAndItsParty(int partyId);
	public List<Object[]> showPartyAndPoliticianDataUsingJoins();
}
