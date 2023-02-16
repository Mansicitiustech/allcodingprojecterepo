package com.ct.model;

import lombok.Data;

@Data
public class EmailDetails {
	private String password;
	private String fromEmail;
	private String toEmail;
	private String subject;
	private String body;
}
