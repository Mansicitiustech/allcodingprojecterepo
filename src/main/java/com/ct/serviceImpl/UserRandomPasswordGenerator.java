package com.ct.serviceImpl;

import org.apache.commons.lang3.RandomStringUtils;

public final class UserRandomPasswordGenerator {

	public static String generatePasword() {
		// TODO Auto-generated method stub
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
		String randomPassword = RandomStringUtils.random( 15, characters );
		return randomPassword;
	}

}
