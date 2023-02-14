package com.citiustech.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Patient_Visit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientVisit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientVisitId;
	
	private String height;
	private String weight;
	private String bloodPressure;
	private String bodyTemperature;
	private String respirationRate;
	
	private long patientId;
	private String patientName;
	
	@OneToOne
	@JoinColumn(name="appointment_id")
	private Appointment appointment;
	
//	@ManyToOne
//	@JoinColumn(name="patient_id")
//	private PatientDetails patientDetails;
	
	@OneToMany
	@JoinColumn(name = "prescription_id")
	private List<Prescription> prescription;
	
	@ManyToMany
//	@JoinTable(name = "Patient_visit_diagnosis",
//		joinColumns = @JoinColumn(name = "patient_visit_id"),
//		inverseJoinColumns = @JoinColumn(name = "diagnosis_id")
//	)
	@JoinColumn(name = "diagnosis_id")
	private List<Diagnosis> diagnosis = new ArrayList<>();
	
	@ManyToMany
	@JoinColumn(name = "procedure_id")
//	@JoinTable(name = "Patient_visit_procedure",
//    	joinColumns = @JoinColumn(name = "patient_visit_id"),
//    	inverseJoinColumns = @JoinColumn(name = "procedure_id")
//	)
	private List<Procedure> procedure = new ArrayList<>();

}