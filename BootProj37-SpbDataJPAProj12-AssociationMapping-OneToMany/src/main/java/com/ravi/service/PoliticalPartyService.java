package com.ravi.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.PoliticalParty;
import com.ravi.entity.Politician;
import com.ravi.repository.IPoliticalPartyRepository;
import com.ravi.repository.IPoliticianRepository;

import jakarta.transaction.Transactional;

@Service
public class PoliticalPartyService implements IPoliticalPartyService {

	@Autowired
	IPoliticalPartyRepository partyRepo;
	
	@Autowired
	IPoliticianRepository politicianRepo;
	
	@Override
	public String savePoliticalPartyAndPolitician(PoliticalParty party) {
		//use  repo
		PoliticalParty save = partyRepo.save(party);
		return "PoliticaParty and Politicians are saved with id value: "+save.getPartyId();
	}

	@Override
	public String savePoliticiansAndPoliticalParty(Politician politician1, Politician politician2) {
		//prepare List having bunch of politician
		List<Politician> list = List.of(politician1,politician2);
		//save the object
		List<Politician> savedList = politicianRepo.saveAll(list);
		//get id values
		//List<Integer> listOfId = savedList.stream().map(id->id.getPid()).collect(Collectors.toList());
		List<Integer> listOfId = savedList.stream().map(Politician::getPid).collect(Collectors.toList());
		return listOfId+" politicians are saved having id values: "+listOfId;
	}

	@Override
	public List<PoliticalParty> showAllPoliticalPartyAndPolitician() {
		List<PoliticalParty> all = partyRepo.findAll();
		return all;
	}

	@Override
	public List<Politician> showAllPoliticianAndTheirParties() {
		List<Politician> all = politicianRepo.findAll();
		return all;
	}

	@Override
	public String deletePartyAndItsPoliticianByPartyId(int partyId) {
		//load the party object
		
		Optional<PoliticalParty> byId = partyRepo.findById(partyId);
		if(byId.isPresent()) {
			PoliticalParty politicalParty = byId.get();
			partyRepo.delete(politicalParty);
			
			return "Political party and its politician are deleted.";
		}else {
			return "political party not found.";
		}	
	}

	@Override
	public String deleteAllPoliticiansOfAPartyByPartyId(int partyId) {
		//load parent object
		Optional<PoliticalParty> byId = partyRepo.findById(partyId);
		if(byId.isPresent()) {
			PoliticalParty politicalParty = byId.get();
			//load all politicians of a party
			Set<Politician> politician = politicalParty.getPolitician();
			//delete all politicians
			politician.forEach(pltcn->pltcn.setParty(null));
			//remove politician in batch
			politicianRepo.deleteAllInBatch();
			
			return partyId+" party's all politicians are deleted.";
			
		}
		return "party not found";
	}

	@Override
	@Transactional
	public String removePoliticianFromParty(int pltcnId) {
		Optional<Politician> byId = politicianRepo.findById(pltcnId);
		if(byId.isPresent()) {
			Politician politician = byId.get();
			politician.setParty(null);
			politicianRepo.save(politician);
			politicianRepo.delete(politician);
			return "politician removed from party with id: "+pltcnId;
		}
		return "politician not found ";
	}

	@Override
	public String addNewPoliticianToParty(int partyId, Politician politician) {
		//Load the party()parent object
		Optional<PoliticalParty> byId = partyRepo.findById(partyId);
		if(byId.isPresent()) {
			PoliticalParty politicalParty = byId.get();
			//get all existing childs
			Set<Politician> politician2 = politicalParty.getPolitician();
			//add new child
			politician2.add(politician);
			politician.setParty(politicalParty);
			//save the party
			partyRepo.save(politicalParty);
			
			return "new politician is added to existing party: "+partyId;	
		} 
		return "party not found to add the new politician.";
	}

	@Override
	public String changePoliticianFromOnePartyToAnotherParty(int politicianId, int partyId) {
		//load party object
		PoliticalParty party = partyRepo.findById(partyId).orElseThrow(()->new IllegalArgumentException("Invalid party id"));
		//load politician object
		Politician politician = politicianRepo.findById(politicianId).orElseThrow(()->new IllegalArgumentException("Invalid politician id"));
		//change the party
		politician.setParty(party);
		//update the party
		politicianRepo.save(politician);
		return "politician's party is changed";
	}

	@Override
	public String deleteAllChildsAndItsParty(int partyId) {
		//load party object
		Optional<PoliticalParty> byId = partyRepo.findById(partyId);
		if(byId.isPresent()) {
			PoliticalParty politicalParty = byId.get();
			//All politician of a party
			Set<Politician> politician = politicalParty.getPolitician();
			//remove party from polticians
			politician.forEach(pltch->{
				politicianRepo.delete(pltch);
			});
			return "All politicians and it's party is deleted";
		}
		
		return "Party is not found";
	}

	@Override
	public List<Object[]> showPartyAndPoliticianDataUsingJoins() {
		
		return partyRepo.showPartyAndPoliticianDataUsingJoins();
	}

	

}
