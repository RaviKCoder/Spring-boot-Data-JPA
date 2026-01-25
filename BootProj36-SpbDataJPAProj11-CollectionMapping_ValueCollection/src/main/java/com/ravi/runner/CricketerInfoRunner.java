package com.ravi.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.CricketerInfo;
import com.ravi.service.ICricketerInfoService;
@Component
public class CricketerInfoRunner implements CommandLineRunner {

	@Autowired
	ICricketerInfoService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			//CricketerInfo info=new CricketerInfo("Rohit", "Mombai", List.of("Virat","Hardik","Subhman"), Set.of(1234567890L,9876543210L), Map.of("aadhar","555555","voterid","666666"));
			
			//			List<CricketerInfo> showAllCricketer = service.showAllCricketer();
			//			showAllCricketer.forEach(System.out::println);
			
			CricketerInfo showCricketerById = service.showCricketerById(1001);
			System.out.println(showCricketerById);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
	}//main

}//class
