package com.citiustech.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.entities.Procedure;

public interface ProcedureRepository extends JpaRepository<Procedure, Long>{

	Optional<Procedure> findByProcedureCode(String code);

}
