package com.ct.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ct.exception.EmailNotFoundException;
import com.ct.model.EmailDetails;
import com.ct.model.User;
import com.ct.model.UserRegistration;
import com.ct.serviceImpl.UserServiceImpl;

@RestController
public class UserController {
	@Autowired
	private UserServiceImpl userService;
	@PostMapping("/register")
public UserRegistration userRegister(@RequestBody UserRegistration request) {
	return userService.userRegister(request);
}
	@GetMapping("/userList")
	public List<UserRegistration> getAllUser(){
		return userService.getAllUser();
	}
	@PostMapping("/userLogin")
	public ResponseEntity<Optional<User>> login(@RequestBody User request) throws EmailNotFoundException{
		Optional<User> userLogin = userService.userLogin(request);
		System.out.println(userLogin.isPresent());
		if(!userLogin.isPresent()) {
			throw new EmailNotFoundException("email and password is incorrect ,please enter valid email and password");
		}
		return new ResponseEntity<Optional<User>>(userLogin,HttpStatus.FOUND);
	}
	
	@PostMapping("/forgotPassword")
	public ResponseEntity<String> forgotPassword(@RequestBody User request) throws EmailNotFoundException {
		if(!userService.isForgotPasswordDone(request)) {
			throw new EmailNotFoundException("email  is incorrect ,please enter valid email otherwise we cannot update your password");
			
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("your password updation is successfully and password is send on your email");
		
	}
	
	@PostMapping("/sendEmail")
	public void  sendRegistrationEmail(@RequestBody EmailDetails emailDetails) throws EmailNotFoundException {
		boolean emailPresent = userService.findUserByEmail(emailDetails.getToEmail());
		if(!emailPresent) {
			throw new EmailNotFoundException("email  is incorrect ,please enter valid email otherwise we cannot update your password");
			
		}
		userService.sendRegistrationEmail(emailDetails);
	}
}
