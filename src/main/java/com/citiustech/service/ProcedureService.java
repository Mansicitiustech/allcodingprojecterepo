package com.citiustech.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.entities.Diagnosis;
import com.citiustech.entities.Procedure;

public interface ProcedureService {

	void addProcedure(Procedure request);

	Optional<List<Procedure>> getAllProcedures();

	Optional<Procedure> getProcedureDescDescriptionByCode(String code);

}
