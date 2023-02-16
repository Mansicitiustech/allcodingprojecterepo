package com.citiustech.exceptions;

public class MyRandomException extends RuntimeException{
	private final String message;

	
	public MyRandomException(String message) {
		super();
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
	
	

}
