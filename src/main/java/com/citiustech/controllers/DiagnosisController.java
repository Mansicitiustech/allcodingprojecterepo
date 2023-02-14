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

import com.citiustech.entities.Appointment;
import com.citiustech.entities.Diagnosis;
import com.citiustech.service.DiagnosisService;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class DiagnosisController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DiagnosisController.class);
	
	@Autowired
	private DiagnosisService diagnosisService;
	
	@PostMapping(value ="/diagnosis",consumes = { MediaType.APPLICATION_JSON_VALUE }
    , produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> saveDiagnosis(@RequestBody Diagnosis request){

		diagnosisService.addDiagnosis(request);
		return ResponseEntity.status(HttpStatus.CREATED).body("Diagnosis details added successfully.");	
	}
	//to get all diagnosis
	@GetMapping(value = "/diagnosis")
	public ResponseEntity<Optional<List<Diagnosis>>> getAllDiagnosis(){
		Optional<List<Diagnosis>> diagnosisList = diagnosisService.getAllDiagnosis();
		if(!diagnosisList.isPresent())
		{
			LOGGER.debug("Diagnosis does not exists.");
			return new ResponseEntity<Optional<List<Diagnosis>>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("Found Diagnosis {}",diagnosisList);
		return new ResponseEntity<Optional<List<Diagnosis>>>(diagnosisList,HttpStatus.OK);	
	}
	
	@GetMapping(value = "/diagnosis/{code}")
	public ResponseEntity<Optional<Diagnosis>> getDiagnosisDescriptionByCode(@PathVariable String code){
		Optional<Diagnosis> diagnosisDesc = diagnosisService.getDiagnosisDescriptionByCode(code);
		if(!diagnosisDesc.isPresent())
		{
			LOGGER.debug("Diagnosis description does not exists.");
			return new ResponseEntity<Optional<Diagnosis>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("Found Diagnosis description {}",diagnosisDesc);
		return new ResponseEntity<Optional<Diagnosis>>(diagnosisDesc,HttpStatus.OK);	
	}
}
