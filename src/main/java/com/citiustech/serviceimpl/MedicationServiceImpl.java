package com.citiustech.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.entities.Medication;
import com.citiustech.repositories.MedicationRepository;
import com.citiustech.service.MedicationService;

@Service
public class MedicationServiceImpl implements MedicationService{
	
	@Autowired
	private MedicationRepository medRepo;

	@Override
	public void saveMedication(Medication request) {
		medRepo.save(request);
	}

	@Override
	public Optional<List<Medication>> getAllMedicines() {
		return Optional.of(medRepo.findAll());
	}

	@Override
	public Optional<List<Medication>> getDrugDetailsByDrugName(String drugName) {
		return medRepo.findByDrugName(drugName);
	}

}
