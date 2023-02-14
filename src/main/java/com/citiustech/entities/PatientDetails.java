package com.citiustech.entities;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "Patient_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PatientDetails {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	private String firstName;
	private String lastName;
	private String gender;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	//@JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
//	 @JsonDeserialize(using = LocalDateDeserializer.class)
//	  @JsonSerialize(using = LocalDateSerializer.class)
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")
	private LocalDate dateOfBirth;
	private String mobileNo;
	private String email;
	private String address;
	private String status;
	private String[] language;
	private String race;
	private String ethnicity;
	@Column(name = "Date_Created")
	private LocalDate localDate=LocalDate.now();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_role_id")
	private UserRole userRole;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EmergencyContactDetails emergencyContactDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Allergy> allergy;
//	
//	@OneToMany(mappedBy = "patientDetails")
//	private List<PatientVisit> patientVisit;
//	
//	@OneToOne(mappedBy = "patientDetails")
//	private Appointment appointment;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Allergy> allergy;
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<EmergencyContactInfo> emContactInfo;

}
