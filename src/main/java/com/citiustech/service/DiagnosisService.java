package com.citiustech.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.entities.Diagnosis;

public interface DiagnosisService {

	void addDiagnosis(Diagnosis request);

	Optional<List<Diagnosis>> getAllDiagnosis();

	Optional<Diagnosis> getDiagnosisDescriptionByCode(String code);

}
