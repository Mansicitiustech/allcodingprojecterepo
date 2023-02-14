package com.ct.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ct.exception.EmailNotFoundException;
import com.ct.model.EmailDetails;
import com.ct.model.Password;
import com.ct.model.StatusConstants;
import com.ct.model.User;
import com.ct.model.UserRegistration;
import com.ct.repo.PasswordRepo;
import com.ct.repo.UserRegistrationRepo;
import com.ct.repo.UserRepo;
import com.ct.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
private UserRepo userRepo;
	@Autowired
	private UserRegistrationRepo registerRepo;
	@Autowired
private PasswordRepo passwordRepo;
	@Autowired
	private JavaMailSender emailSender;
	@Override
	public UserRegistration userRegister(UserRegistration request) {
	User user=new User();
	user.setEmail(request.getEmail());
	user.setPassword(UserRandomPasswordGenerator.generatePasword());
	user.setStatus(StatusConstants.ACTIVE);
	userRepo.save(user);
	UserRegistration userRegister=new UserRegistration();
	
	userRegister.setId(request.getId());
	userRegister.setFirstName(request.getFirstName());
	userRegister.setLastName(request.getLastName());
	userRegister.setEmail(request.getEmail());
	userRegister.setCity(request.getCity());
	userRegister.setCountry(request.getCountry());
	userRegister.setGender(request.getGender());
	userRegister.setDob(request.getDob());
	userRegister.setPhNo(request.getPhNo());
	userRegister.setState(request.getState());
	userRegister.setUser(user);
	UserRegistration registration = registerRepo.save(userRegister);
	
	return registration;
	
		
	}

	public Optional<User> userLogin(User request) throws EmailNotFoundException {
		String email = request.getEmail();
		
		Optional<User> loginUser = userRepo.findUserByEmail(email);
		User user = loginUser.get();
		if((request.getEmail().equals(user.getEmail()))&&(request.getPassword().equals(user.getPassword()))&&(user.getStatus().equals("Active"))) {
		return Optional.of(user);
		}
		
	return Optional.empty();
	
	}
	
	public List<UserRegistration> getAllUser(){
		return registerRepo.findAll();
	}

	

	@Override
	public boolean isForgotPasswordDone(User request) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepo.findUserByEmail(request.getEmail());
		//User loginUser = user.get();
		if(user.isPresent()) {
			updateUserPassword(request,UserRandomPasswordGenerator.generatePasword());
			return true;
		}
		return false;
	}

	@Override
	public void updateUserPassword(User request, String generatePasword) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepo.findUserByEmail(request.getEmail());
		User loginUser = user.get();
		loginUser.setPassword(generatePasword);
		userRepo.save(loginUser);
		Password updatePassword = new Password();
		updatePassword.setPassword(generatePasword);
		updatePassword.setUser(loginUser);
		passwordRepo.save(updatePassword);

	}
	@Override
	public void sendRegistrationEmail(EmailDetails emailDetails) {
		SimpleMailMessage emailMessage=new SimpleMailMessage();
		Optional<User> findUserByEmail = userRepo.findUserByEmail(emailDetails.getToEmail());
		if(findUserByEmail.isPresent()) {
		emailMessage.setFrom(emailDetails.getFromEmail());
		emailMessage.setTo(emailDetails.getToEmail());
		emailMessage.setText(emailDetails.getBody()+emailDetails.getPassword());
		emailMessage.setSubject(emailDetails.getSubject());
		emailSender.send(emailMessage);
	}}

	@Override
	public boolean findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findUserByEmail(email).isPresent();
	}
}
