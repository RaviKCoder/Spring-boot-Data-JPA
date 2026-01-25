package com.ravi.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.PoliticalParty;
import com.ravi.entity.Politician;
import com.ravi.service.IPoliticalPartyService;

@Component
public class OneToMantBidirectionalTestRunner implements CommandLineRunner {

	@Autowired
	IPoliticalPartyService service;
	
	@Override
	public void run(String... args) throws Exception {
		
//		try {
//			//parent object
//			PoliticalParty party=new PoliticalParty("BJP", "Lotus");
//			//child object
//			Politician politician1=new Politician("Modi", "Gujrat", 75);
//			Politician politician2=new Politician("AmitSah", "Gujrat", 60);
//			
//			//link child objects to parent object
//			
//			party.setPolitician(Set.of(politician1,politician2));
//			
//			//link parent object to child object
//			politician1.setParty(party);
//			politician2.setParty(party);
//			
//			
//			//invoke the method
//			
//			String savePoliticalPartyAndPolitician = service.savePoliticalPartyAndPolitician(party);
//			System.out.println(savePoliticalPartyAndPolitician);
//	
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			//parent object
//			PoliticalParty party=new PoliticalParty("INC", "Hand");
//			//child object
//			Politician politician1=new Politician("Rahul", "Delhi", 50);
//			Politician politician2=new Politician("Priyanka", "Delhi", 45);
//			
//			//link child objects to parent object
//			
//			party.setPolitician(Set.of(politician1,politician2));
//			
//			//link parent object to child object
//			politician1.setParty(party);
//			politician2.setParty(party);
//
//			
//			//invoke the method
//			
//			String savePoliticiansAndPoliticalParty = service.savePoliticiansAndPoliticalParty(politician1, politician2);
//			System.out.println(savePoliticiansAndPoliticalParty);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			List<PoliticalParty> allPoliticalPartyAndPolitician = service.showAllPoliticalPartyAndPolitician();
//			allPoliticalPartyAndPolitician.forEach(party->{
//				System.out.println("Parent(party)"+party);
//				Set<Politician> politicians = party.getPolitician();
//				politicians.forEach(politician->{
//					System.out.println("Child(politician)"+politician);
//				});
//			});
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			service.showAllPoliticianAndTheirParties().forEach(politician->{
//				System.out.println("politician(child)"+politician);
//				
//				PoliticalParty party = politician.getParty();
//				System.out.println("politicalParty(parent) "+party);
//				System.out.println("===============================");
//			});
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			
//			String deletePartyAndItsPoliticianByartyId = service.deletePartyAndItsPoliticianByPartyId(1001);
//			System.out.println(deletePartyAndItsPoliticianByartyId);
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			String deleteAllPoliticiansOfAPartyByPartyId = service.deleteAllPoliticiansOfAPartyByPartyId(1002);
//			System.out.println(deleteAllPoliticiansOfAPartyByPartyId);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			String removePoliticianFromParty = service.removePoliticianFromParty(1021);
//			System.out.println(removePoliticianFromParty);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		
//		try {
//			Politician politician=new Politician("Amit", "Jharkhand", 24);
//			String newPoliticianToParty = service.addNewPoliticianToParty(1003, politician);
//			System.out.println(newPoliticianToParty);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			String changePoliticianFromOnePartyToAnotherParty = service.changePoliticianFromOnePartyToAnotherParty(1024, 1021);
//			System.out.println(changePoliticianFromOnePartyToAnotherParty);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			String deleteAllChildsAndItsParty = service.deleteAllChildsAndItsParty(1021);
//			System.out.println(deleteAllChildsAndItsParty);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			List<Object[]> showPartyAndPoliticianDataUsingJoims = service.showPartyAndPoliticianDataUsingJoins();
			showPartyAndPoliticianDataUsingJoims.forEach(row->{
				System.out.println(Arrays.toString(row));
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}//run

}//class
