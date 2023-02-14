package com.ct.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ct.dto.LoginForm;
import com.ct.dto.UnlockAccForm;
import com.ct.model.City;
import com.ct.model.Country;
import com.ct.model.State;
import com.ct.model.UserDetails;
import com.ct.repo.CityRepo;
import com.ct.repo.CountryRepo;
import com.ct.repo.StateRepo;
import com.ct.repo.UserDetailsRepo;
import com.ct.service.UserDetailsService;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
private UserDetailsRepo userRepo;
	@Autowired
	private CountryRepo countryRepo;
	@Autowired
	private CityRepo cityRepo;
	@Autowired
	private StateRepo stateRepo;
	@Override
	public String checkEmail(String email) {
		// TODO Auto-generated method stub
		Optional<UserDetails> userEmail = userRepo.findUserByEmail(email);
		//return userEmail.get().getEmail();
		if(userEmail.isPresent()) {
		 return userEmail.get().getEmail();
			}
		return "email is not exist";
	}

	

	@Override
	public String registerUser(UserDetails user) {
		// TODO Auto-generated method stub
		Optional<UserDetails> userEmail = userRepo.findUserByEmail(user.getEmail());
		//return userEmail.get().getEmail();
		if(userEmail.isPresent()) {
		 return "user is already exist for   " +userEmail.get().getEmail()+ " this email   so you cannot register";
			}
	 userRepo.save(user);
		return "register successfully   "+user.getEmail();
		
	}

	@Override
	public String unlockAccount(UnlockAccForm accForm) {
		// TODO Auto-generated method stub
		Optional<UserDetails> email = userRepo.findUserByEmail(accForm.getEmail());
		UserDetails updateUser = new UserDetails();
		if (email.isPresent()) {
			UserDetails userDetails = email.get();
			updateUser = userDetails;

			updateUser.setPassword(accForm.getTempPassword());
			updateUser.setCity(userDetails.getCity());
			updateUser.setCountry(userDetails.getCountry());
			updateUser.setDob(userDetails.getDob());
			updateUser.setEmail(userDetails.getEmail());
			updateUser.setFirstName(userDetails.getFirstName());
			updateUser.setGender(userDetails.getGender());
			updateUser.setLastName(userDetails.getLastName());
			updateUser.setPhNo(userDetails.getPhNo());
			updateUser.setState(userDetails.getState());
			updateUser.setUid(userDetails.getUid());
			userRepo.save(updateUser);
			return "user password change successfully for  " + userDetails.getEmail() + "   email";
		}
		return "email is invalid please enter valid email";
	}

	@Override
	public String login(LoginForm loginForm) {
		// TODO Auto-generated method stub

		Optional<UserDetails> loginUser = userRepo.findUserByEmail(loginForm.getEmail());
		System.out.println(loginUser.get().getEmail());
		// UserDetails user = loginUser.get();
		// if((loginForm.getEmail().equals(user.getEmail()))&&(loginForm.getPassword().equals(user.getPassword()))&&(loginForm.getStatus().equals("Active")))
		// {
		if ((loginForm.getEmail().equals(loginUser.get().getEmail()))
				&& (loginForm.getPassword().equals(loginUser.get().getPassword()))
				&& (loginForm.getStatus().equals("Active"))) {
			return "user login successfully with    " + loginUser.get().getEmail() + "   this email id";

		}
		return "please enter valid data something went wrong";
	}

	@Override
	public Map<Integer, String> getCountries() {
		Map<Integer,String> map=new HashMap<>();
		// TODO Auto-generated method stub
		List<Country> list = countryRepo.findAll();
		for(int i=0;i<list.size();i++) {
			int id = list.get(i).getCid();
			String name = list.get(i).getName();
	map.put(id, name);
		}
		
		return map;
	}



	@Override
	public Map<Integer, String> getStates(int sid) {
		Map<Integer,String> map=new HashMap<>();
		Optional<State> findById = stateRepo.findById(sid);
		if(findById.isPresent()) {
		String name = findById.get().getName()	;
		int id = findById.get().getSid();
		map.put(id, name);
		return map;
		}
		map.put(sid, "for this sid  any state is not present");
		return map;
	}



	@Override
	public Map<Integer, String> getCities(int ciid) {
		Map<Integer,String> map=new HashMap<>();
		Optional<City> findById = cityRepo.findById(ciid);
		if(findById.isPresent()) {
		String name = findById.get().getName()	;
		int id = findById.get().getCiid();
		map.put(id, name);
		return map;
		}
		map.put(ciid, "for this ciid  any city is not present");
		return map;
	}
	

}