package com.citiustech.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Medication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long drugNo;
	private String drugID;
	private String drugName;
	private String drugGenericName;
	private String drugBrandName;
	private String drugForm; 

//	@ManyToMany(mappedBy = "medication")
//	private Prescription prescription;

}
