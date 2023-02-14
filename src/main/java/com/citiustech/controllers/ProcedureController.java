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
import com.citiustech.entities.Procedure;
import com.citiustech.service.ProcedureService;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class ProcedureController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcedureController.class);
	
	@Autowired
	private ProcedureService procedureService;
	
	@PostMapping(value ="/procedure",consumes = { MediaType.APPLICATION_JSON_VALUE }
    , produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> saveProcedure(@RequestBody Procedure request){

		procedureService.addProcedure(request);
		return ResponseEntity.status(HttpStatus.CREATED).body("Procedure details added successfully.");	
	}
	//to get all diagnosis
	@GetMapping(value = "/procedure")
	public ResponseEntity<Optional<List<Procedure>>> getAllProcedures(){
		Optional<List<Procedure>> procedureList = procedureService.getAllProcedures();
		if(!procedureList.isPresent())
		{
			LOGGER.debug("Procedure does not exists.");
			return new ResponseEntity<Optional<List<Procedure>>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.info("Found Procedure {}",procedureList);
		return new ResponseEntity<Optional<List<Procedure>>>(procedureList,HttpStatus.OK);	
	}
	
	@GetMapping(value = "/procedure/{code}")
	public ResponseEntity<Optional<Procedure>> getProcedureDescriptionByCode(@PathVariable String code){
		Optional<Procedure> procedureDesc = procedureService.getProcedureDescDescriptionByCode(code);
		if(!procedureDesc.isPresent())
		{
			LOGGER.debug("Procedure description does not exists.");
			return new ResponseEntity<Optional<Procedure>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("Found Diagnosis description {}",procedureDesc);
		return new ResponseEntity<Optional<Procedure>>(procedureDesc,HttpStatus.OK);	
	}

}
