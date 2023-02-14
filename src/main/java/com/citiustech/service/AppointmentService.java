package com.citiustech.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.entities.Appointment;
import com.citiustech.entities.AppointmentTimeSlot;

public interface AppointmentService {
	public Appointment addAppointment(Appointment appointment);

	public Optional<List<Appointment>> getAllAppointments();

	public Optional<Appointment> getAppointmentById(long id);

	public Optional<Appointment> getAppointmentByPatientId(long id);

//	public boolean isAppointmentPresent(AppointmentTimeSlot timeSlot);
	public boolean isAppointmentPresent(long timeSlot);

	public Optional<List<Appointment>> getAppointmentByEmployeeId(long id);

	public Optional<Appointment> getById(long appointmentId);

	public Appointment updateAppointment(Appointment request);

	public List<Appointment> getBookedAndRescheduleAppointment();

	public List<Appointment> getAllRequestedAppointments();

	public Appointment updateApproveAppointment(Appointment request);

	public Appointment updateCancelAppointment(Appointment request);

	public Optional<List<Appointment>> getAppointmentBypatientId(long id);

	public Optional<List<Appointment>> getRequestedAppointmentForEmployee(long id);

}
