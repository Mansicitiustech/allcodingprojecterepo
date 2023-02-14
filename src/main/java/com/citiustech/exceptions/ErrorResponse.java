package com.citiustech.exceptions;

public class ErrorResponse {
	private final int code;
    private final String message;
	public ErrorResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
    
    

}
