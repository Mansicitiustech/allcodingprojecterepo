package com.citiustech.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.entities.Diagnosis;
import com.citiustech.entities.Procedure;
import com.citiustech.repositories.ProcedureRepository;
import com.citiustech.service.ProcedureService;

@Service
public class ProcedureServiceImpl implements ProcedureService{
	
	@Autowired
	private ProcedureRepository procedureRepo;

	@Override
	public void addProcedure(Procedure request) {
		procedureRepo.save(request);
		
	}

	@Override
	public Optional<List<Procedure>> getAllProcedures() {
		// TODO Auto-generated method stub
		return Optional.of(procedureRepo.findAll());
	}

	@Override
	public Optional<Procedure> getProcedureDescDescriptionByCode(String code) {
		// TODO Auto-generated method stub
		return procedureRepo.findByProcedureCode(code);
	}

}
