package com.citiustech.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(SomethingWentWrong.class)
	public String somethingWentWrong()
	{
		return "Something went wrong please check";
	}

}
