package com.citiustech.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.entities.Appointment;
import com.citiustech.entities.AppointmentTimeSlot;
import com.citiustech.repositories.AppointmentRepository;
import com.citiustech.repositories.AppointmentTimeSlotRepo;
import com.citiustech.service.AppointmentService;


@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepo;


	@Autowired
	private AppointmentTimeSlotRepo appointmentTimeSlotRepo;
	
	@Autowired
	private AppointmentTimeSlotServiceImpl appointmentSlotImp;

	@Override
	public Appointment updateAppointment(Appointment request) {

			Appointment newAppointment = new Appointment();
			AppointmentTimeSlot updateTimeSlot = new AppointmentTimeSlot();
			
			Optional<Appointment> appointment = appointmentRepo.findById(request.getAppointmentId());
			if(appointment.isPresent()) {
				newAppointment = appointment.get();
				
				if(StringUtils.isNotEmpty(request.getRescheduleDate().toString())) {
					newAppointment.setAppointmentStatus(request.getAppointmentStatus());
					newAppointment.setReason(request.getReason());
					newAppointment.setRescheduleDate(request.getRescheduleDate());
					newAppointment.setRescheduleTimeSlot(request.getRescheduleTimeSlot());
					
					
//					Optional<AppointmentTimeSlot> checkSlot = appointmentSlotImp.getBySlotId(appointment.getTimeSlot().getSlotId());
					Optional<AppointmentTimeSlot> checkSlot = appointmentSlotImp.getBySlotId(request.getRescheduleTimeSlot());
					updateTimeSlot = checkSlot.get();
					updateTimeSlot.setSlotStatus("Not Available");
					appointmentSlotImp.updateTimeSlot(updateTimeSlot);
				}
				if(StringUtils.isNotEmpty(request.getAppointmentStatus())) {
					newAppointment.setAppointmentStatus(request.getAppointmentStatus());
				}
				
				if(request.getAppointmentStatus().equals("Cancelled")) {
					Optional<AppointmentTimeSlot> checkSlot = appointmentSlotImp.getBySlotId(request.getTimeSlot());
					updateTimeSlot = checkSlot.get();
					updateTimeSlot.setSlotStatus("Available");
//					appointmentSlotImp.updateTimeSlot(updateTimeSlot);
					appointmentTimeSlotRepo.save(updateTimeSlot);
				}
				newAppointment.setAppointmentCreatedBy(request.getAppointmentCreatedBy());
//				newAppointment.setAppointmentDate(request.getAppointmentDate());
//				
//				newAppointment.setDescription(request.getDescription());
////				newAppointment.setEmployeeId(request.getEmployeeId());
//				newAppointment.setMeetingTitle(request.getMeetingTitle());
				
			}
			
		Appointment updatedAppointment = appointmentRepo.save(newAppointment);
			return updatedAppointment;

	}


//	@Override
//	public Optional<Appointment> getAppointmentByDoctorId(int doctorId) {
//		System.out.println("get appointment by doctor id");
//		return appointmentRepo.findByDoctor(doctorId);
//	}



	@Override
	public Optional<Appointment> getAppointmentByPatientId(long id) {
		System.out.println("get appointment by Patient id");
		return appointmentRepo.findById(id);
	}


//	@Override
//	public boolean isAppointmentPresent(AppointmentTimeSlot timeSlot) {
//		// TODO Auto-generated method stub
//		return appointmentRepo.findByTimeSlot(timeSlot);
//	}
	
	@Override
	public boolean isAppointmentPresent(long timeSlot) {
		// TODO Auto-generated method stub
		return appointmentRepo.findByTimeSlot(timeSlot);
	}
	
	@Override
	public Appointment addAppointment(Appointment appointment) {

		Appointment newAppointment=  appointmentRepo.save(appointment);
		AppointmentTimeSlot updateTimeSlot = new AppointmentTimeSlot();
//		Optional<AppointmentTimeSlot> checkSlot = appointmentSlotImp.getBySlotId(appointment.getTimeSlot().getSlotId());
		Optional<AppointmentTimeSlot> checkSlot = appointmentSlotImp.getBySlotId(appointment.getTimeSlot());
		updateTimeSlot = checkSlot.get();
		updateTimeSlot.setSlotStatus("Not Available");
		appointmentSlotImp.updateTimeSlot(updateTimeSlot);
		return newAppointment;
	}
	
	@Override
	public Optional<Appointment> getAppointmentById(long id) {

		return appointmentRepo.findByAppointmentId(id);
	}

	@Override
	public Optional<List<Appointment>> getAppointmentByEmployeeId(long id) {
		// TODO Auto-generated method stub
		return appointmentRepo.findByEmployeeId(id);
	}

	@Override
	public Optional<Appointment> getById(long appointmentId) {
		// TODO Auto-generated method stub
		return Optional.of(appointmentRepo.getById(appointmentId));
	}


	@Override
	public Optional<List<Appointment>> getAllAppointments() {
		// TODO Auto-generated method stub
		return Optional.of(appointmentRepo.findAll());
	}


	@Override
	public List<Appointment> getBookedAndRescheduleAppointment() {
		return appointmentRepo.getBookedAndRescheduleAppointment();
	}


	@Override
	public List<Appointment> getAllRequestedAppointments() {
		return appointmentRepo.getRequestedAppointment();
	}


	@Override
	public Appointment updateApproveAppointment(Appointment request) {
		Appointment newAppointment = new Appointment();
		Optional<Appointment> appointment = appointmentRepo.findById(request.getAppointmentId());
		if (appointment.isPresent()) {
			newAppointment = appointment.get();
			newAppointment.setAppointmentStatus("Booked");
		}
		return appointmentRepo.save(newAppointment);
	}


	@Override
	public Appointment updateCancelAppointment(Appointment request) {
		Appointment newAppointment = new Appointment();
		Optional<Appointment> appointment = appointmentRepo.findById(request.getAppointmentId());
		if (appointment.isPresent()) {
			newAppointment = appointment.get();
			newAppointment.setAppointmentStatus("Cancelled");
		}
		return appointmentRepo.save(newAppointment);
	}


	@Override
	public Optional<List<Appointment>> getAppointmentBypatientId(long id) {
		// TODO Auto-generated method stub
//		return appointmentRepo.findByPatientIdAndAppointmentStatus(id,"Requested");
		return appointmentRepo.findByPatientId(id);
	}


	@Override
	public Optional<List<Appointment>> getRequestedAppointmentForEmployee(long id) {
		return appointmentRepo.findByEmployeeIdAndAppointmentStatus(id,"Requested");
	}	

}
