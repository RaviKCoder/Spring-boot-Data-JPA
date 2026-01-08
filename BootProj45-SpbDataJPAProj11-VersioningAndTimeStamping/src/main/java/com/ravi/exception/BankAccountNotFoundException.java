package com.ravi.exception;

public class BankAccountNotFoundException extends RuntimeException {

	public BankAccountNotFoundException() {
		super();
	}	
		
		public BankAccountNotFoundException(String str) {
			super(str);
		
	}

	
}
