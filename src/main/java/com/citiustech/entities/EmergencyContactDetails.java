package com.citiustech.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Emergency_Contact_Details")
public class EmergencyContactDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emergencyInfoId;
	private String firstName;
	private String lastName;
	private String ralationship;
	private String mobileNo;
	private String email;
	private String address;
	private String access;
	
	@OneToOne
	private PatientDetails patientDetails;
}
