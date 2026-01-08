package com.ravi.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ravi.entity.Account;
import com.ravi.service.IAccountService;

@Component
public class AccountRunner implements CommandLineRunner {

	@Autowired
	IAccountService accountService;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
//			String saveAccount = accountService.openBankAccount(new Account(20000.0));
//			System.out.println(saveAccount);
			
//			Iterable<Account> showAccount = accountService.showAccount();
//			showAccount.forEach(System.out::println);
			
			
			String depositAmount = accountService.depositAmount(100002L, 6000.0);
			System.out.println(depositAmount);
//			
//			System.out.println("=============================");
//			
//			String withdrawAmount = accountService.withdrawAmount(100001L, 6000.0);
//			System.out.println(withdrawAmount);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
