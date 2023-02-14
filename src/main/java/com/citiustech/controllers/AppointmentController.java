package com.citiustech.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.entities.Appointment;
import com.citiustech.exceptions.MyRandomException;
import com.citiustech.service.AppointmentService;
@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class AppointmentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);

	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping(value ="/appointment",consumes = { MediaType.APPLICATION_JSON_VALUE }
    , produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> saveEmployeeDetails(@RequestBody Appointment request){
//		if(appointmentService.isAppointmentPresent(request.getTimeSlot())) {
//			LOGGER.info("Appointment already exists {} : ", request.getTimeSlot());
//			throw new MyRandomException("Appointment details already exists.");
//		}
		appointmentService.addAppointment(request);
		return ResponseEntity.status(HttpStatus.CREATED).body("Appointment created successfully.");	
	}
	//to show all appointment list to nurse
	@GetMapping(value = "/appointment")
	public ResponseEntity<Optional<List<Appointment>>> getAllAppointment(){
		Optional<List<Appointment>> appointmentList = appointmentService.getAllAppointments();
		if(!appointmentList.isPresent())
		{
			LOGGER.debug("Appointment does not exists.");
			return new ResponseEntity<Optional<List<Appointment>>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("Found employees {}",appointmentList);
		return new ResponseEntity<Optional<List<Appointment>>>(appointmentList,HttpStatus.OK);	
	}
	
	//to get appointment by id
	@GetMapping(value = "/appointment/{id}")
	public ResponseEntity<Optional<Appointment>> getAppointmentById(@PathVariable long id){
		Optional<Appointment> appointment = appointmentService.getAppointmentById(id);
		if(!appointment.isPresent())
		{
			LOGGER.debug("Appointment does not exists.");
			return new ResponseEntity<Optional<Appointment>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("Found appointment {}",appointment);
		return new ResponseEntity<Optional<Appointment>>(appointment,HttpStatus.OK);	
	}
	
	//to get  Booked/Rescheduled appointment for particular doctor
	@GetMapping(value = "/appointment/employee/{id}")
	public ResponseEntity<Optional<List<Appointment>>> getAppointmentForEmployee(@PathVariable long id){
		Optional<List<Appointment>> appointmentList = appointmentService.getAppointmentByEmployeeId(id);
		if(!appointmentList.isPresent())
		{
			LOGGER.debug("Appointment does not exists.");
			return new ResponseEntity<Optional<List<Appointment>>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("Found appointmentList {}",appointmentList);
		return new ResponseEntity<Optional<List<Appointment>>>(appointmentList,HttpStatus.OK);	
	}
	

	//to get Requested appointment for particular doctor
	@GetMapping(value = "/appointment/employee/requested/{id}")
	public ResponseEntity<Optional<List<Appointment>>> getRequestedAppointmentForEmployee(@PathVariable long id){
		Optional<List<Appointment>> appointmentList = appointmentService.getRequestedAppointmentForEmployee(id);
		if(!appointmentList.isPresent())
		{
			LOGGER.debug("Appointment does not exists.");
			return new ResponseEntity<Optional<List<Appointment>>>(HttpStatus.NO_CONTENT);
		}
		LOGGER.debug("Found appointmentList {}",appointmentList);
		return new ResponseEntity<Optional<List<Appointment>>>(appointmentList,HttpStatus.OK);	
	}
	
	//to reshcedule or update the appointment
	@PatchMapping(value ="/appointment")
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment request){
		
		Optional<Appointment> appointment = appointmentService.getById(request.getAppointmentId());
		if(!appointment.isPresent()) {
			LOGGER.debug("Appointment with id does not exists.",request.getAppointmentId() );
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}
		Appointment updatedAppointment =	appointmentService.updateAppointment(request);
		return new ResponseEntity<Appointment>(updatedAppointment,HttpStatus.OK);	
	}
	
	//get all Booked/rescheduled/requested appointments
		@GetMapping("getBookedAndRescheduleAppointment")
		public List<Appointment> getBookedAndRescheduleAppointment() {

			return appointmentService.getBookedAndRescheduleAppointment();
		}
		
		//get all requested appointments
		@GetMapping("getAllRequestedAppointments")
		public List<Appointment> getAllRequestedAppointments() {

			return appointmentService.getAllRequestedAppointments();
		}
		
		//update requested to Booked Appointment
		@PatchMapping(value = "/approveToBookedAppointment")
		public ResponseEntity<Appointment> updateApproveAppointment(@RequestBody Appointment request) {

			Optional<Appointment> appointment = appointmentService.getById(request.getAppointmentId());
			if (!appointment.isPresent()) {
				LOGGER.debug("Appointment with id does not exists.", request.getAppointmentId());
				return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
			}
			Appointment updatedAppointment = appointmentService.updateApproveAppointment(request);
			return new ResponseEntity<Appointment>(updatedAppointment, HttpStatus.OK);
		}
		
		//update requested to Cancelled Appointment
		@PatchMapping(value = "/cancelAppointment")
		public ResponseEntity<Appointment> updateCancelAppointment(@RequestBody Appointment request) {

			Optional<Appointment> appointment = appointmentService.getById(request.getAppointmentId());
			if (!appointment.isPresent()) {
				LOGGER.debug("Appointment with id does not exists.", request.getAppointmentId());
				return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
			}
			Appointment updatedAppointment = appointmentService.updateCancelAppointment(request);
			return new ResponseEntity<Appointment>(updatedAppointment, HttpStatus.OK);
		}
		//to get appointment for particular patient
		@GetMapping(value = "/appointment/patient/{id}")
		public ResponseEntity<Optional<List<Appointment>>> getAppointmentForPatient(@PathVariable long id){
			Optional<List<Appointment>> appointmentList = appointmentService.getAppointmentBypatientId(id);
			if(!appointmentList.isPresent())
			{
				LOGGER.debug("Appointment does not exists.");
				return new ResponseEntity<Optional<List<Appointment>>>(HttpStatus.NO_CONTENT);
			}
			LOGGER.debug("Found appointmentList {}",appointmentList);
			return new ResponseEntity<Optional<List<Appointment>>>(appointmentList,HttpStatus.OK);	
		}
	
	
	

}
