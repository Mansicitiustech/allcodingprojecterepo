package com.citiustech.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

public class AppointmentEditHistory {
	
	private int appointmentEditId;
	@OneToMany
	private Appointment appointment;
	
	private String modificationReason;
	@DateTimeFormat(pattern = "dd-mm-yyyy HH:mm:ss")
	private LocalDateTime modificationDateTime=LocalDateTime.now();
	private String modificationStatus;
//	@OneToOne
//	private EmployeeDetails updatedBy;
	

}
