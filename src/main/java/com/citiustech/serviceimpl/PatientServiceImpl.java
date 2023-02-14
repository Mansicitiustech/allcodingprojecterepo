package com.citiustech.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.entities.Allergy;
import com.citiustech.entities.AllergyData;
import com.citiustech.entities.EmergencyContactDetails;
import com.citiustech.entities.PatientDetails;
import com.citiustech.repository.PatientRepo;
import com.citiustech.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientRepo patientRepo;
	

	List<Allergy> lists=new ArrayList<>();
	@Override
	public void submitPatientDetails(PatientDetails patientDetails) {
		// TODO Auto-generated method stub
		
		patientRepo.save(patientDetails);
	}

	@Override
	public List<PatientDetails> getalldata() {
		// TODO Auto-generated method stub
		List<PatientDetails> list= patientRepo.findAll();
		return list;
	}

	@Override
	public PatientDetails findPatientDetailsByPatientId(int patientId) {
		// TODO Auto-generated method stub
		PatientDetails patientDetails= patientRepo.findByPatientId(patientId);
		System.out.println(patientDetails.getEmail());
		 return patientDetails;
	}

	@Override
	public PatientDetails getPatientDetailsByName(String name) {
		// TODO Auto-generated method stub
		PatientDetails patientDetails=patientRepo.findByFirstName(name);
		return patientDetails;
	}

	@Override
	public PatientDetails getByFirstNameAndLastName(String firstName, String lastName) {
		// TODO Auto-generated method stub
		
		PatientDetails patientDetails= patientRepo
				.findByFirstNameAndLastName(firstName,lastName);
			
				System.out.println(patientDetails.getFirstName());
				return patientDetails;
	}
	

	

	@Override
	public PatientDetails getPatientDataByEmail(String email) {
		// TODO Auto-generated method stub
		return patientRepo.findByEmail(email);
	}

	@Override
	public void updatePatient(PatientDetails patient) {
		// TODO Auto-generated method stub
		
			patientRepo.save(patient);
	}

	@Override
	public PatientDetails updatePatientByFirstNameLastNameAndEmail(String firstName, String lastName, String email) {
		// TODO Auto-generated method stub
		return patientRepo.findByFirstNameAndLastNameAndEmail(firstName, lastName,email);
	}

	@Override
	public void updatePatientDetailsById(PatientDetails patient, int patientId) {
		// TODO Auto-generated method stub
		Optional<PatientDetails> patientDetails= patientRepo.findById(patientId);
		PatientDetails newPatientDetails=patientDetails.get();
		newPatientDetails.setFirstName(patient.getFirstName());
		newPatientDetails.setLastName(patient.getLastName());
		newPatientDetails.setAddress(patient.getAddress());
		newPatientDetails.setEmail(patient.getEmail());
		newPatientDetails.setEthnicity(patient.getEthnicity());
		newPatientDetails.setGender(patient.getGender());
		newPatientDetails.setMobileNo(patient.getMobileNo());
		newPatientDetails.setDateOfBirth(patient.getDateOfBirth());
		newPatientDetails.setRace(patient.getRace());
		newPatientDetails.setFirstName(patient.getFirstName());
		newPatientDetails.setLanguage(patient.getLanguage());
		
		
		newPatientDetails.getEmergencyContactDetails().setFirstName(patient.getEmergencyContactDetails().getFirstName());
		newPatientDetails.getEmergencyContactDetails().setLastName(patient.getEmergencyContactDetails().getLastName());
		newPatientDetails.getEmergencyContactDetails().setMobileNo(patient.getEmergencyContactDetails().getMobileNo());
		newPatientDetails.getEmergencyContactDetails().setAddress(patient.getEmergencyContactDetails().getAddress());
		newPatientDetails.getEmergencyContactDetails().setRalationship(patient.getEmergencyContactDetails().getRalationship());
		newPatientDetails.getEmergencyContactDetails().setAccess(patient.getEmergencyContactDetails().getAccess());
		
		
		
//		EmergencyContactDetails emergencyContactDetails=new EmergencyContactDetails();
//		
//		emergencyContactDetails.setFirstName(patient.getEmergencyContactDetails().getFirstName());
//		emergencyContactDetails.setLastName(patient.getEmergencyContactDetails().getLastName());
//		emergencyContactDetails.setAddress(patient.getEmergencyContactDetails().getAddress());
//		emergencyContactDetails.setEmail(patient.getEmergencyContactDetails().getEmail());
//		emergencyContactDetails.setMobileNo(patient.getEmergencyContactDetails().getMobileNo());
//		emergencyContactDetails.setRelationship(patient.getEmergencyContactDetails().getRelationship());
//		emergencyContactDetails.setAccess(patient.getEmergencyContactDetails().getAccess());
//
//		newPatientDetails.setEmergencyContactDetails(emergencyContactDetails);
		
		patientRepo.save(newPatientDetails);

	}

	@Override
	public List<AllergyData> getAllAllergyData() {
		// TODO Auto-generated method stub
		return patientRepo.getAllergyData();
	}

	@Override
	public PatientDetails getlistOfAllergies(String firstName, String email) {
		// TODO Auto-generated method stub
		
		PatientDetails list=patientRepo.findByFirstNameAndEmail(firstName,email);

		return list;
	}

	@Override
	public List<PatientDetails> getpatients() {
		// TODO Auto-generated method stub
		return patientRepo.findAll();
	}

	@Override
	public List<PatientDetails> findPatientsByPatientId(int id) {
		// TODO Auto-generated method stub
		return patientRepo.findAllByPatientId(id);
		
	}

	@Override
	public void setAllergyForPatient(List<Allergy> allergy,int id) {
		// TODO Auto-generated method stub
		PatientDetails patientDetails=patientRepo.findById(id).get();
		patientDetails.setAllergy(allergy);
		patientRepo.save(patientDetails);
		
		
		
	}

	

	

	
	
	

	
	
	

	
}
