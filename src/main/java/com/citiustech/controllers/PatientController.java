package com.citiustech.controllers;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.citiustech.entities.Allergy;
import com.citiustech.entities.AllergyData;
import com.citiustech.entities.PatientDetails;
import com.citiustech.service.PatientService;
@CrossOrigin("*")
@RestController
@RequestMapping("patientDetails")
public class PatientController {
	@Autowired
	PatientService ps;
	@Autowired
	RestTemplate rt;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);

	@PostMapping("patient")
	public ResponseEntity<?> submitDetails(@RequestBody PatientDetails patientDetails) {

		
		LOGGER.info("Patient first name {} : ",patientDetails.getFirstName() );
		LOGGER.info("Patient last name {} : ",patientDetails.getLastName() );

		ps.submitPatientDetails(patientDetails);
		return ResponseEntity.status(HttpStatus.ACCEPTED).
				body("patient data registerd successfully");
	}

	@GetMapping("patients")
	public ResponseEntity<?> getalldetails() {
		List<PatientDetails> list = ps.getalldata();
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("there is no data found");
		} else {
			return ResponseEntity.of(Optional.of(list));
		}

	}

	@GetMapping("patient/{patientId}")
	public PatientDetails findPatientDetailsById(@PathVariable("patientId") int patientId) {
		PatientDetails patientDetails = ps.findPatientDetailsByPatientId(patientId);
		
		LOGGER.info("Patient address {} : ",patientDetails.getAddress() );
		LOGGER.info("Patient patient id {} : ",patientDetails.getPatientId() );

		return patientDetails;

	}
	@GetMapping("patient")
	public PatientDetails findFirstPatient()
	{
		List<PatientDetails> list=ps.getpatients();
		 Collections.reverse(list);
		return list.stream().findFirst().get();
	}
	@GetMapping("patient/{name}")
	public PatientDetails findPatientDetailsByName(@PathVariable("name") String name)
	{
		PatientDetails patientDetails=ps.getPatientDetailsByName(name);
		return patientDetails;
	}

	@GetMapping("patient/{firstName}/{lastName}")
	public PatientDetails findPatientDetailsByFirstNameAndLastName(@PathVariable("firstName")
	String firstName,@PathVariable("lastName") String lastName)
	{
		
		PatientDetails patientDetails=ps.getByFirstNameAndLastName(firstName,lastName);
		return patientDetails;
	}
	
	
	
	@GetMapping("patient/{email}")
	public PatientDetails getdataByEmail(@PathVariable("email") String email)
	{
		PatientDetails patientDetails=ps.getPatientDataByEmail(email);
		return patientDetails;
	}
	
	//update patient by directly passing object bcz it connect id so 
	//accordingly it will update
	@PutMapping("patient")
	public void updatePatientById(@RequestBody PatientDetails patient)
	{
		ps.updatePatient(patient);
		
	}
	@GetMapping("patient/{firstName}/{lastName}/{email}")
	public int updatePatientByFirstNameLastNameAndEmail(@PathVariable("firstName")
	String firstName,@PathVariable("lastName") String lastName,@PathVariable("email")String email)
	{
		 PatientDetails patientDetails= ps.updatePatientByFirstNameLastNameAndEmail(firstName,lastName,email);
		return patientDetails.getPatientId();
	}
	
	//update using patientId
	@PutMapping("patient/{patientId}")
	public void updatePatientById(@RequestBody PatientDetails patient,@PathVariable("patientId") int patientId)
	{
		ps.updatePatientDetailsById(patient,patientId);
	}
	@GetMapping("AllergyData")
	public List<AllergyData> getAllAllergyData()
	{
		List<AllergyData> list= ps.getAllAllergyData();
		return list;
	}
	
	@GetMapping("allergies/{firstName}/{email}")
	public List<Allergy> getPatientByFirstNameAndEmail(@PathVariable("firstName")
	String firstName,@PathVariable("email")String email)
	{
		 PatientDetails patientDetails= ps.getlistOfAllergies(firstName,email);
		 
		 List<Allergy> list =patientDetails.getAllergy();
		 return list;
		
	}
	//for dto
	@GetMapping("registration")
	public PatientDetails getPatientRegistrationData()
	{
		
		return new PatientDetails();
	}
	@GetMapping("checkPatientDetailsById/{id}")
	public boolean getPatientDetailsStatusById(@PathVariable("id") int id)
	{
//		PatientDetails patientDetails=ps.findPatientsByPatientId(id);
		if(ps.findPatientsByPatientId(id).isEmpty())
		{
			System.out.println("null");
			return true;
		}
		else
			//return ResponseEntity.of(Optional.of(ps.findPatientsByPatientId(id).stream().findFirst()));
			return false;

	}
	@GetMapping("PatientById/{id}")
	public PatientDetails getPatientDetailsById(@PathVariable("id") int id)
	{
		if(ps.findPatientsByPatientId(id).isEmpty())
		{
			return null;
		}
		else
		{
			return  ps.findPatientsByPatientId(id).stream().findFirst().get();
		}
	}
	@PutMapping("storeAllergy/{id}")
	public void setAllergyForPatient(@RequestBody List<Allergy> allergy,@PathVariable("id") int id)
	{
		ps.setAllergyForPatient(allergy,id);
	}
	
	
}
