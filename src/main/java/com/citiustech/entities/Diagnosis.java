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
public class Diagnosis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long diagnosisId;
	private String diagnosisCode; 
	private String diagnosisDescription ;
	private boolean diagnosisIsDepricated;

//	@ManyToMany(mappedBy = "diagnosis")
//	private List<PatientVisit> patientVisit;
}
