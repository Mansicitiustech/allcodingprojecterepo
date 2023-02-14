package com.citiustech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.entities.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long>{

	Optional<List<Medication>> findByDrugName(String drugName);

}
