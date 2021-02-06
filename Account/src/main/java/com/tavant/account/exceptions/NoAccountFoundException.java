package com.tavant.account.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoAccountFoundException extends Exception{
	
	public NoAccountFoundException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + this.getMessage();
	}

}
