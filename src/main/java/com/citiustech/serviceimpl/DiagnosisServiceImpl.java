package com.citiustech.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.entities.Diagnosis;
import com.citiustech.repositories.DiagnosisRepository;
import com.citiustech.service.DiagnosisService;

@Service
public class DiagnosisServiceImpl implements DiagnosisService{
	
	@Autowired
	private DiagnosisRepository diagnosisRepo;
	

	@Override
	public void addDiagnosis(Diagnosis request) {
		diagnosisRepo.save(request);		
	}


	@Override
	public Optional<List<Diagnosis>> getAllDiagnosis() {
		return Optional.of(diagnosisRepo.findAll());
	}


	@Override
	public Optional<Diagnosis> getDiagnosisDescriptionByCode(String code) {
		return diagnosisRepo.findByDiagnosisCode(code);
	}

}
