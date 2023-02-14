package com.citiustech.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citiustech.entities.Appointment;
import com.citiustech.entities.PatientVisit;

public interface PatientVisitRepository extends JpaRepository<PatientVisit, Long>{

	Optional<PatientVisit> findByPatientVisitIdAndAppointment(long patientVisitId, Appointment appointment);

	Optional<List<PatientVisit>> findByPatientId(long patientId);

	Optional<PatientVisit> findByPatientVisitIdAndAppointment_AppointmentId(long patientVisitId, long appointmentId);

	Optional<PatientVisit> findByAppointment(Appointment appointment);

	Optional<PatientVisit> findByPatientVisitId(long patientVisitId);

}
