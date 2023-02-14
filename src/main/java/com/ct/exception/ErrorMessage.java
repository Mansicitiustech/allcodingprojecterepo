package com.ct.exception;

import lombok.Data;

//@Data
public class ErrorMessage {


private String message;
private int code;
public ErrorMessage(int i, String message2) {
	// TODO Auto-generated constructor stub
	this.code=i;
	this.message=message2;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}

}
