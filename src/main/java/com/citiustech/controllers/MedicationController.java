package com.citiustech.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.entities.Diagnosis;
import com.citiustech.entities.Medication;
import com.citiustech.service.MedicationService;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class MedicationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MedicationController.class);
	
	@Autowired
	private MedicationService medicationService;
	
	@PostMapping(value ="/medication",consumes = { MediaType.APPLICATION_JSON_VALUE }
    , produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> saveMedication(@RequestBody Medication request){

		medicationService.saveMedication(request);
		return ResponseEntity.status(HttpStatus.CREATED).body("Medication details added successfully.");	
	}
	//to get all medication
	@GetMapping(value = "/medication")
	public ResponseEntity<Optional<List<Medication>>> getAllMedication(){
		Optional<List<Medication>> medicineList = medicationService.getAllMedicines();
		if(!medicineList.isPresent())
		{
			LOGGER.debug("Medication does not exists.");
			return new ResponseEntity<Optional<List<Medication>>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("Found medicineList {}",medicineList);
		return new ResponseEntity<Optional<List<Medication>>>(medicineList,HttpStatus.OK);	
	}
	
	@GetMapping(value = "/medication/{drugName}")
	public ResponseEntity<Optional<List<Medication>>> getDrugDetailsByDrugName(@PathVariable String drugName){
		Optional<List<Medication>> drugDetails = medicationService.getDrugDetailsByDrugName(drugName);
		if(!drugDetails.isPresent())
		{
			LOGGER.debug("Medication description does not exists.");
			return new ResponseEntity<Optional<List<Medication>>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("Found Diagnosis description {}",drugDetails);
		return new ResponseEntity<Optional<List<Medication>>>(drugDetails,HttpStatus.OK);	
	}

}
