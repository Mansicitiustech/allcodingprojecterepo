package com.citiustech.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Allergy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int al_id;
	@Column(name = "Allergy_ID")
	private String allergyId;
	@Column(name = "Allergy_Type")
    private String allergyType;
	@Column(name = "Allergy_Name")
    private String allergyName;
	@Column(name = "Allergy_Description")
    private String allergyDescription;
	@Column(name = "Allergy_Clinical_Information")
    private String clinicalInformation;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private PatientDetails patientDetails;
}
