package com.ravi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravi.entity.Account;
import com.ravi.exception.BankAccountNotFoundException;
import com.ravi.repository.IAccountRepository;

@Service
public class AccountService implements IAccountService {
	
	@Autowired
	IAccountRepository accountRepository;

	@Override
	public String openBankAccount(Account account) {
		Account save = accountRepository.save(account);
		return "Bank Account is opened with account number: "+save.getAccountno();
	}

	@Override
	public String depositAmount(Long acno, Double amount) {
		// Load the object
		Account account = accountRepository.findById(acno).orElseThrow(()->new BankAccountNotFoundException("Invalid account number."));
		
		account.setBalance(account.getBalance()+amount);
		
		Account save = accountRepository.save(account);
		return "Amount is deposited to bank account : "+save.getAccountno();
	}

	@Override
	public String withdrawAmount(Long acno, Double amount) {
		// Load the object
				Account account = accountRepository.findById(acno).orElseThrow(()->new BankAccountNotFoundException("Invalid account number."));
				
				account.setBalance(account.getBalance()-amount);
				
				Account save = accountRepository.save(account);
				return "Amount is withdraw from  bank account : "+save.getAccountno();
	}
	
	public Iterable<Account> showAccount(){
		List<Account> all = accountRepository.findAll();
		return all;
	}

}
