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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.entities.Appointment;
import com.citiustech.entities.PatientVisit;
import com.citiustech.exceptions.MyRandomException;
import com.citiustech.service.PatientVisitService;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class PatientVisitController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientVisitController.class);
	
	@Autowired
	private PatientVisitService visitService;
	
	@PostMapping(value ="/patient-visit",consumes = { MediaType.APPLICATION_JSON_VALUE }
    , produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> savePatientVisit(@RequestBody PatientVisit request){
		Optional<PatientVisit> visitDetails= visitService.getVisitByAppointment(request.getAppointment());
		if(visitDetails.isPresent()) {
			LOGGER.info("Patient visit already exists {} : ", request.getPatientVisitId());
			throw new MyRandomException("Patient visit details already exists.");
		}
//		if(visitService.isPatientVisitExists(request.getPatientVisitId(), request.getAppointment().getAppointmentId())) {
//			LOGGER.info("Patient visit already exists {} : ", request.getPatientVisitId());
//			throw new MyRandomException("Patient visit details already exists.");
//		}
		
		visitService.addPatientVisit(request);
		return ResponseEntity.status(HttpStatus.CREATED).body("Patient visit details added successfully.");	
	}
	
	@GetMapping(value = "/patient-visit")
	public ResponseEntity<Optional<List<PatientVisit>>> getAllPatientVisitList(){
		Optional<List<PatientVisit>> visitList = visitService.getAllPatientVisitList();
		if(!visitList.isPresent())
		{
			LOGGER.debug("Visit details does not exists.");
			return new ResponseEntity<Optional<List<PatientVisit>>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("Found visit {}",visitList);
		return new ResponseEntity<Optional<List<PatientVisit>>>(visitList,HttpStatus.OK);	
	}
	
	@GetMapping(value = "/patient-visit/{patientId}")
	public ResponseEntity<Optional<List<PatientVisit>>> getPatientVisitDetails(@PathVariable long patientId){
		Optional<List<PatientVisit>> visitList = visitService.getPatientVisitDetails(patientId);
		if(!visitList.isPresent())
		{
			LOGGER.debug("Visit details does not exists.");
			return new ResponseEntity<Optional<List<PatientVisit>>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("Found visit {}",visitList);
		return new ResponseEntity<Optional<List<PatientVisit>>>(visitList,HttpStatus.OK);	
	}
	
	@PatchMapping(value = "/patient-visit/visit")
	public ResponseEntity<PatientVisit> updatePatientVisit(@RequestBody PatientVisit request){
		Optional<PatientVisit> visitDetails= visitService.getVisitByAppointment(request.getAppointment());
		if(!visitDetails.isPresent()) {
			LOGGER.info("Patient visit does not exists {} : ", request.getPatientVisitId());
			throw new MyRandomException("Patient visit details does not exists.");
		}
		PatientVisit updatedVisit = visitService.updatePatientVisitDetails(request);
		return new ResponseEntity<PatientVisit>(updatedVisit,HttpStatus.OK);	
	}

}
