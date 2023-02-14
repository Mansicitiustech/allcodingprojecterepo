package com.citiustech.entities;

import java.util.List;

import javax.persistence.Column;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
	//quantity ,type, time, medication id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prescription_id")
	private int prescriptionId;
	private int quantity;
	private String type;
	private String[] timing;
	@OneToOne
//	@JoinTable(name = "Prescription_medication_info",
//	joinColumns = @JoinColumn(name = "prescription_id"),
//	inverseJoinColumns = @JoinColumn(name = "medication_id")
//)
	@JoinColumn(name =" drug_No")
	private Medication medication;
	
//	@ManyToOne(map)
//	private PatientVisit patientVisit;
}
