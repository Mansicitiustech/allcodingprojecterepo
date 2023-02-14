package com.ct.exception;

import lombok.Data;

//@Data
public class EmailNotFoundException extends Exception {


private String message;

public EmailNotFoundException(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}


}
