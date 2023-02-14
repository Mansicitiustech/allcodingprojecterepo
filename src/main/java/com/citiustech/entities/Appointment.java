package com.citiustech.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="appointment")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long appointmentId;
	private String meetingTitle;
	private String description;
	private String specialisation;
	private long employeeId;
	private String employeeName;
	@DateTimeFormat(pattern = "dd-mm-yyyy HH:mm:ss")
	private LocalDateTime dateCreated=LocalDateTime.now(); 
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date appointmentDate;
	private String timeSlotString;
	private long timeSlot;
	
	private String reason;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date rescheduleDate;
	private long rescheduleTimeSlot;
	private String rescheduleTimeSlotString;
	private String appointmentCreatedBy;
	private long patientId;
	private String patientName;
	private String appointmentStatus;
}
