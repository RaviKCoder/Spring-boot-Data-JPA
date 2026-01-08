package com.ravi.service;

import com.ravi.entity.Account;

public interface IAccountService {
	
	public String openBankAccount(Account account);
	
	public Iterable<Account> showAccount();
	
	public String withdrawAmount(Long acno,Double amount);
	
	public String depositAmount(Long acno,Double amount);	
}
