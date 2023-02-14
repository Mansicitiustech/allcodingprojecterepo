package com.ct.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ct.dto.LoginForm;
import com.ct.dto.UnlockAccForm;
import com.ct.model.UserDetails;
import com.ct.serviceImpl.UserDetailsServiceImpl;

@RestController
public class UserDetailsController {
	@Autowired
private UserDetailsServiceImpl userService;
	@PostMapping("/register")
	public String registerUser(@RequestBody UserDetails user) {
		return userService.registerUser(user);
	}
	@PostMapping("/login")
	public String login(@RequestBody LoginForm loginForm) {
		return userService.login(loginForm);
	}
	@PostMapping("/unlock")
	public String unlockAccount(@RequestBody UnlockAccForm accForm) {
		return userService.unlockAccount(accForm);
	}
	@GetMapping("/checkemail")
	public String checkEmail(@RequestParam("email")String email) {
	return userService.checkEmail(email);
}
	@GetMapping("/findcountries")
	public Map<Integer,String> getCountries() {
	return userService.getCountries();
}
	@GetMapping("/findstate/{sid}")
	public Map<Integer, String> getStates(@PathVariable("sid") int sid){
		return userService.getStates(sid);
	}
	@GetMapping("/findcity/{ciid}")
	public Map<Integer, String> getCities(@PathVariable("ciid") int ciid){
		return userService.getCities(ciid);
	}
}
