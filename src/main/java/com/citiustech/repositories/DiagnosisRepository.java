package com.citiustech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.entities.Diagnosis;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long>{

	Optional<Diagnosis> findByDiagnosisCode(String code);

}
