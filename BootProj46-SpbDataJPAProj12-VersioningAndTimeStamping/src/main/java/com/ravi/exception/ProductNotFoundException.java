package com.ravi.exception;

public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException() {
		super();
		
	}
	
	public ProductNotFoundException(String str) {
		super(str);
		
	}

}
