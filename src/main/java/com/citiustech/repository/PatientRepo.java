package com.citiustech.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.citiustech.entities.AllergyData;
import com.citiustech.entities.PatientDetails;
@Repository
public interface PatientRepo extends JpaRepository<PatientDetails, Integer>{

	PatientDetails findByPatientId(int patientId);

	PatientDetails findByFirstName(String name);

	PatientDetails findByFirstNameAndLastName(String firstName, String lastName);

	PatientDetails findByEmail(String email);

	PatientDetails findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
	


	@Query(value="select * from Allergy_Data ",nativeQuery = true )
	public List<AllergyData> getAllergyData();

	PatientDetails findByFirstNameAndEmail(String firstName, String email);


	List<PatientDetails> findAllByPatientId(int id);

	
	
	



}
