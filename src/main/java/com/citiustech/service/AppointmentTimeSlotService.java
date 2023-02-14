package com.citiustech.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.citiustech.entities.AppointmentTimeSlot;

public interface AppointmentTimeSlotService {

	public void addTimeSlot(AppointmentTimeSlot request);

	public Optional<List<AppointmentTimeSlot>> getAppointmentTimeSlotByEmployeeId(int employeeId);

	public Optional<AppointmentTimeSlot> getBySlotId(long slotId);

	public AppointmentTimeSlot updateTimeSlot(AppointmentTimeSlot request);

	public Optional<List<AppointmentTimeSlot>> getAppointmentTimeSlotByEmployeeIdAndAppointmentDate(int employeeId, Date appointmentDate);

	public void deleteByTimeSlotId(int slotId);

	

	public void cancelTimeSlot(int slotId);

	public Optional<List<AppointmentTimeSlot>> getAllAppointmentTimeSlotByEmployeeId(int employeeId);

	public void deleteByTimeSlotsId(long slotId);
}
