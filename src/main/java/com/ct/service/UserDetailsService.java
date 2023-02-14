package com.ct.service;

import java.util.Map;

import com.ct.dto.LoginForm;
import com.ct.dto.UnlockAccForm;
import com.ct.model.UserDetails;

public interface UserDetailsService {
public String checkEmail(String email);

public Map<Integer,String> getStates(int sid);
public Map<Integer,String> getCities(int ciid);
public String registerUser(UserDetails user);
public String unlockAccount(UnlockAccForm accForm);
public String login(LoginForm loginForm);
public Map<Integer, String> getCountries();
}
