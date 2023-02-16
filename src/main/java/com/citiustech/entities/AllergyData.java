package com.citiustech.entities;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AllergyData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int allergy_id;
	private String allergy_type;
	private String allergy_name;
	private String allergen_source;
	private String isoforms_or_partial_sequences_of_allergen;
	private String allerginicity;

}
