package com.citiustech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.entities.Appointment;
import com.citiustech.entities.AppointmentTimeSlot;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	boolean findByTimeSlot(AppointmentTimeSlot timeSlot);
	boolean findByTimeSlot(long timeSlot);
//    @Query("select u from Appointment u where u.employeeDetails= :doctorId ")
//	Optional<Appointment> findByDoctor(int doctorId);

	Optional<Appointment> findByAppointmentId(long id);
	
	@Query("select u from Appointment u where u.appointmentStatus IN ('Booked','Rescheduled') AND employeeId = :employeeId")
	Optional<List<Appointment>> findByEmployeeId(long employeeId);
	
	@Query("select u from Appointment u where u.appointmentStatus in ('Booked','Rescheduled','Requested')")
	List<Appointment> getBookedAndRescheduleAppointment();

	@Query("select u from Appointment u where u.appointmentStatus in ('Requested')")
	List<Appointment> getRequestedAppointment();
	
	@Query("select u from Appointment u where u.appointmentStatus IN ('Booked','Rescheduled','Requested') AND patientId = :patientId")
	Optional<List<Appointment>> findByPatientId(long patientId);
	
	Optional<List<Appointment>> findByPatientIdAndAppointmentStatus(long id, String string);
	
	Optional<List<Appointment>> findByEmployeeIdAndAppointmentStatus(long id, String string);
  
}
