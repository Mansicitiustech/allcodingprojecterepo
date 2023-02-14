package com.citiustech.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.entities.Medication;

public interface MedicationService {

	void saveMedication(Medication request);

	Optional<List<Medication>> getAllMedicines();

	Optional<List<Medication>> getDrugDetailsByDrugName(String drugName);

}
