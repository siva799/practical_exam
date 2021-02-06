package com.tavant.account.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoDataFoundException extends Exception{
	public NoDataFoundException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + this.getMessage();
	}

}
