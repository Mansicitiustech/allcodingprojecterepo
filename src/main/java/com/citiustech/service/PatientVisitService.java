package com.citiustech.service;

import java.util.List;
import java.util.Optional;

import com.citiustech.entities.Appointment;
import com.citiustech.entities.PatientVisit;

public interface PatientVisitService {

	boolean isPatientVisitExists(long patientVisitId, long appointmentId);

	void addPatientVisit(PatientVisit request);

	Optional<List<PatientVisit>> getAllPatientVisitList();

	Optional<List<PatientVisit>> getPatientVisitDetails(long patientId);

	PatientVisit updatePatientVisitDetails(PatientVisit request);

	Optional<PatientVisit> getVisitByAppointment(Appointment appointment);



}
