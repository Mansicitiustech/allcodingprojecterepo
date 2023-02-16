package com.citiustech.service;

import java.util.List;

import com.citiustech.entities.Allergy;
import com.citiustech.entities.AllergyData;
import com.citiustech.entities.PatientDetails;

public interface PatientService {

	void submitPatientDetails(PatientDetails patientDetails);

	List<PatientDetails> getalldata();

	PatientDetails findPatientDetailsByPatientId(int patientId);

	PatientDetails getPatientDetailsByName(String name);

	PatientDetails getByFirstNameAndLastName(String firstName, String lastName);


	PatientDetails getPatientDataByEmail(String email);

	void updatePatient(PatientDetails patient);

	PatientDetails updatePatientByFirstNameLastNameAndEmail(String firstName, String lastName, String email);

	void updatePatientDetailsById(PatientDetails patient, int patientId);

	List<AllergyData> getAllAllergyData();

	PatientDetails getlistOfAllergies(String firstName, String email);

	List<PatientDetails> getpatients();

	List<PatientDetails> findPatientsByPatientId(int id);

	void setAllergyForPatient(List<Allergy> allergy,int id);


	


//	void updatePatientByFirstNameLastNameAndEmail(String firstName, String lastName, String email);
	
}
