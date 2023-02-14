package com.citiustech.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Procedure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long procedureId;
	private String procedureCode; 
	private String procedureDescription;
	private boolean procedureIsDepricated; 

//	@ManyToMany(mappedBy = "procedure")
//	private List<PatientVisit> patientVisit;
}
