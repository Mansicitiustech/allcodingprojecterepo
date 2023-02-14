package com.ct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(EmailNotFoundException.class)
public ResponseEntity<ErrorMessage> exception(EmailNotFoundException exception) {
		return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorMessage(500,exception.getMessage()));
	}
}
