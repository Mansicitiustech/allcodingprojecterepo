package com.citiustech.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.entities.Appointment;
import com.citiustech.entities.AppointmentTimeSlot;
import com.citiustech.repositories.AppointmentTimeSlotRepo;
import com.citiustech.service.AppointmentTimeSlotService;

@Service
public class AppointmentTimeSlotServiceImpl implements AppointmentTimeSlotService {

	@Autowired
	private AppointmentTimeSlotRepo appointmentTimeSlotRepo;

	@Override
	public void addTimeSlot(AppointmentTimeSlot request) {
		AppointmentTimeSlot newSlot = new AppointmentTimeSlot();
		newSlot.setDate(request.getDate());
		newSlot.setEmployeeId(request.getEmployeeId());
		newSlot.setEmployeeName(request.getEmployeeName());
		newSlot.setEndTime(request.getEndTime());
		newSlot.setStartTime(request.getStartTime());
		newSlot.setSlotStatus("Available");
//		newSlot.setSlotStatus(request.getSlotStatus());
		appointmentTimeSlotRepo.save(newSlot);
	}

	@Override
	public Optional<List<AppointmentTimeSlot>> getAppointmentTimeSlotByEmployeeId(int employeeId) {	
		return appointmentTimeSlotRepo.findByEmployeeIdAndSlotStatus(employeeId,"Available");
	}

	@Override
	public Optional<AppointmentTimeSlot> getBySlotId(long slotId) {
		// TODO Auto-generated method stub
		return appointmentTimeSlotRepo.findBySlotId(slotId);
	}

	@Override
	public AppointmentTimeSlot updateTimeSlot(AppointmentTimeSlot request) {
		Optional<AppointmentTimeSlot> timeSlot = appointmentTimeSlotRepo.findBySlotId(request.getSlotId());
		AppointmentTimeSlot updatedTimeSlot = new AppointmentTimeSlot();
		if(timeSlot.isPresent()) {
			updatedTimeSlot = timeSlot.get();	
			updatedTimeSlot.setSlotStatus(request.getSlotStatus());
			System.out.println("hello timeslot "+request.getSlotStatus());
		}
		return appointmentTimeSlotRepo.save(updatedTimeSlot);
	}
	
	

	@Override
	public Optional<List<AppointmentTimeSlot>> getAppointmentTimeSlotByEmployeeIdAndAppointmentDate(int employeeId,
			Date appointmentDate) {
		// TODO Auto-generated method stub
		return appointmentTimeSlotRepo.findByEmployeeIdAndDateAndSlotStatus(employeeId, appointmentDate,"Available");
	}

	@Override
	public void deleteByTimeSlotId(int slotId) {
		appointmentTimeSlotRepo.deleteById(slotId);
		
	}

	@Override
	public void cancelTimeSlot(int slotId) {
		Optional<AppointmentTimeSlot> timeSlot = appointmentTimeSlotRepo.findBySlotId(slotId);
		AppointmentTimeSlot updatedTimeSlot = new AppointmentTimeSlot();
		if(timeSlot.isPresent()) {
			updatedTimeSlot = timeSlot.get();	
			updatedTimeSlot.setSlotStatus("Cancelled");
//			System.out.println("hello timeslot ");
		}
		appointmentTimeSlotRepo.save(updatedTimeSlot);
	}

	@Override
	public Optional<List<AppointmentTimeSlot>> getAllAppointmentTimeSlotByEmployeeId(int employeeId) {
		return appointmentTimeSlotRepo.findByEmployeeId(employeeId);
	}

	@Override
	public void deleteByTimeSlotsId(long slotId) {
		Optional<AppointmentTimeSlot> ap = appointmentTimeSlotRepo.findBySlotId(slotId);
		AppointmentTimeSlot newAppointmentTimeSlot = ap.get();
		newAppointmentTimeSlot.setSlotStatus("Cancelled");
		appointmentTimeSlotRepo.save(newAppointmentTimeSlot);
	}
	
}
