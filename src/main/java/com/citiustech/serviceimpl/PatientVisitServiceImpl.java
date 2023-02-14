package com.citiustech.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.entities.Appointment;
import com.citiustech.entities.PatientVisit;
import com.citiustech.repositories.PatientVisitRepository;
import com.citiustech.service.PatientVisitService;

@Service
public class PatientVisitServiceImpl implements PatientVisitService{
	
	@Autowired
	private PatientVisitRepository visitRepo;

	@Override
	public boolean isPatientVisitExists(long patientVisitId, long appointmentId) {
		Optional<PatientVisit> visit = visitRepo.findByPatientVisitIdAndAppointment_AppointmentId(patientVisitId, appointmentId);
		return visit.isPresent();
	}

	@Override
	public void addPatientVisit(PatientVisit request) {
		visitRepo.save(request);
	}

	@Override
	public Optional<List<PatientVisit>> getAllPatientVisitList() {
		return Optional.of(visitRepo.findAll());
	}

	@Override
	public Optional<List<PatientVisit>> getPatientVisitDetails(long patientId) {
		// TODO Auto-generated method stub
		return visitRepo.findByPatientId(patientId);
	}

	@Override
	public PatientVisit updatePatientVisitDetails(PatientVisit request) {
		// TODO Auto-generated method stub
		Optional<PatientVisit> visit = visitRepo.findByPatientVisitId(request.getPatientVisitId());
		PatientVisit updateVisit = new PatientVisit();
		PatientVisit updatedDetail = new PatientVisit();
		if(visit.isPresent()) {
			updateVisit = visit.get();
			updatedDetail = visitRepo.save(request);
		}
		return updatedDetail;
		
	}

	@Override
	public Optional<PatientVisit> getVisitByAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return visitRepo.findByAppointment(appointment);
	}

}
