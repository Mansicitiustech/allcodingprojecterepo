package com.citiustech.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientRegistrationDTO {
	
	private Long patientId;
	private String title;
	private String firstName;
	private String lastName;
	private String email;
	private long contactNumber;
	private String password;
	
	private String status;

}
