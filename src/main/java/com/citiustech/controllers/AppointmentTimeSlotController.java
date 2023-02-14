package com.citiustech.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.citiustech.entities.AppointmentTimeSlot;
import com.citiustech.service.AppointmentTimeSlotService;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class AppointmentTimeSlotController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentTimeSlotController.class);

	@Autowired
	private AppointmentTimeSlotService appointmentTimeSlotService;

	
	@PostMapping(value ="/time-slot",consumes = { MediaType.APPLICATION_JSON_VALUE }
    , produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> addTimeSlot(@RequestBody AppointmentTimeSlot request){
		
		appointmentTimeSlotService.addTimeSlot(request);
		LOGGER.info("Created : ");
		return ResponseEntity.status(HttpStatus.CREATED).body("New slot added successfully.");	
		
	}
	
	// for Appointment book - to show only available timeslot 
	@GetMapping(value ="/time-slot/{employeeId}")
	public ResponseEntity<Optional<List<AppointmentTimeSlot>>> getAvailableTimeSlotByEmployeeId(@PathVariable int employeeId){
		Optional<List<AppointmentTimeSlot>> timeSlots=appointmentTimeSlotService.getAppointmentTimeSlotByEmployeeId(employeeId);
		if(!timeSlots.isPresent())
		{
			LOGGER.debug("Time slot for {} does not exists.", employeeId);
			return new ResponseEntity<Optional<List<AppointmentTimeSlot>>>(HttpStatus.NOT_FOUND);
		}
		else {
			LOGGER.info("Found : " ,timeSlots);
			return new ResponseEntity<Optional<List<AppointmentTimeSlot>>>(timeSlots,HttpStatus.OK);	
		}
	}
	
	// for doctor timeslot list
	@GetMapping(value ="/alltime-slot/{employeeId}")
	public ResponseEntity<Optional<List<AppointmentTimeSlot>>> getAllTimeSlotByEmployeeId(@PathVariable int employeeId){
		Optional<List<AppointmentTimeSlot>> timeSlots=appointmentTimeSlotService.getAllAppointmentTimeSlotByEmployeeId(employeeId);
		if(!timeSlots.isPresent())
		{
			LOGGER.debug("Time slot for {} does not exists.", employeeId);
			return new ResponseEntity<Optional<List<AppointmentTimeSlot>>>(HttpStatus.NOT_FOUND);
		}
		else {
			LOGGER.info("Found : " ,timeSlots);
			return new ResponseEntity<Optional<List<AppointmentTimeSlot>>>(timeSlots,HttpStatus.OK);	
		}
	}
	
	// Get all time slot with physician id
//
//		@GetMapping(value = "/time/{employeeId}/{appointmentDate}")
//		public ResponseEntity<Optional<List<AppointmentTimeSlot>>> getById(@PathVariable int employeeId, @PathVariable Date appointmentDate) {
//			Optional<List<AppointmentTimeSlot>> timeSlots = appointmentTimeSlotService.getAppointmentTimeSlotByEmployeeIdAndAppointmentDate(employeeId,appointmentDate);
//			if (!timeSlots.isPresent()) {
//				LOGGER.debug("Time slot for {} does not exists.", appointmentDate);
//				return new ResponseEntity<Optional<List<AppointmentTimeSlot>>>(HttpStatus.NOT_FOUND);
//			} else {
//				LOGGER.info("Found : ", timeSlots);
//				return new ResponseEntity<Optional<List<AppointmentTimeSlot>>>(timeSlots, HttpStatus.OK);
//			}
//		}
	
	@PatchMapping(value ="/time-slot")
	public ResponseEntity<AppointmentTimeSlot> updateTimeSlot(@RequestBody AppointmentTimeSlot request){
		
		Optional<AppointmentTimeSlot> slotOptional = appointmentTimeSlotService.getBySlotId(request.getSlotId());
		if(!slotOptional.isPresent()) {
			LOGGER.debug("Slot with id does not exists.",request.getSlotId());
			return new ResponseEntity<AppointmentTimeSlot>(HttpStatus.NOT_FOUND);
		}
		AppointmentTimeSlot updatedSlot =	appointmentTimeSlotService.updateTimeSlot(request);
		return new ResponseEntity<AppointmentTimeSlot>(updatedSlot,HttpStatus.OK);	
	}
	
	@PatchMapping(value ="/time-slot/delete/{slotId}" )
	public void deleteByTimeSlotId(@PathVariable int slotId){
		Optional<AppointmentTimeSlot> slotOptional = appointmentTimeSlotService.getBySlotId(slotId);
		if(!slotOptional.isPresent()) {
			LOGGER.debug("Slot with id does not exists.",slotId);
			appointmentTimeSlotService.cancelTimeSlot(slotId);
		}
	}
	
	@DeleteMapping(value="/time-slot/delete/{slotId}")
	public String deleteByTimeSlotsId(@PathVariable long slotId){
//		appointmentTimeSlotService.deleteByTimeSlotsId(slotId);	
		try {
			appointmentTimeSlotService.deleteByTimeSlotsId(slotId);
			return "Appointment Approved";
		} catch (Exception e) {
			e.toString();
			return "No Appointment found -" + slotId;
		}
	}
}
