package com.citiustech.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="appointment_timeslot")
public class AppointmentTimeSlot {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long slotId;
//	@OneToOne
//	private EmployeeDetails employeeDetails;
	private int employeeId;
	private String employeeName;
//	@DateTimeFormat(pattern = "dd/mm/yyyy")
//	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date date;
	private String startTime;
	private String endTime;
	private String slotStatus;
	@DateTimeFormat(pattern = "dd-mm-yyyy HH:mm:ss")
	private LocalDateTime dateCreated=LocalDateTime.now();
}
