package com.ct.service;

import com.ct.model.EmailDetails;
import com.ct.model.User;
import com.ct.model.UserRegistration;

public interface UserService {

UserRegistration userRegister(UserRegistration request);
public void updateUserPassword(User request, String generatePasword);
public boolean isForgotPasswordDone(User request);
//public void sendRegistrationEmail(String password,String toEail,String subject,String body);

public void sendRegistrationEmail(EmailDetails emailDetails);
public boolean findUserByEmail(String email);
}
