package com.citiustech.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citiustech.entities.AllergyData;
import com.citiustech.repository.MasterAllergyRepository;
import com.citiustech.service.MasterAllergyService;

@Service
public class MasterAllergyImpl implements MasterAllergyService{
	@Autowired
	MasterAllergyRepository masterAllergyRepository;

	@Override
	public void submitMasterAllergyData(AllergyData allergyData) {
		// TODO Auto-generated method stub
		masterAllergyRepository.save(allergyData);
		
	}

	@Override
	public AllergyData getAllergyData(int id) {
		// TODO Auto-generated method stub
		return masterAllergyRepository.findById(id).get();
	}

	@Override
	public List<AllergyData> getAllAllergyData() {
		// TODO Auto-generated method stub
		return masterAllergyRepository.findAll();
	}

	@Override
	public List<Integer> getAllAlleryId() {
		// TODO Auto-generated method stub
		
		 List<AllergyData> list= masterAllergyRepository.findAll();
		 List<Integer> lis= list.stream().map(s->s.getAllergy_id()).collect(Collectors.toList());
		return lis;
	}

	@Override
	public String getAllergyTypeById(int id) {
		// TODO Auto-generated method stub
		return masterAllergyRepository.findAllergyTypeById(id);
	}

	@Override
	public String getAllergyName(int id) {
		// TODO Auto-generated method stub
		return masterAllergyRepository.findAllergyNameById(id);
	}

	@Override
	public List<String> getAllAlleryType() {
		// TODO Auto-generated method stub
		List<AllergyData> list= masterAllergyRepository.findAll();
		 List<String> lis= list.stream().map(s->s.getAllergy_type()).collect(Collectors.toList());
		 return lis;
	}
	@Override
	public List<String> getAllAlleryName() {
		// TODO Auto-generated method stub
		List<AllergyData> list= masterAllergyRepository.findAll();
		 List<String> lis= list.stream().map(s->s.getAllergy_name()).collect(Collectors.toList());
		 return lis;
	}

	@Override
	public List<String> getAllergyNamesbyType(String type) {
		// TODO Auto-generated method stub
		return masterAllergyRepository.findAllergyNamesByName(type);
	}

	@Override
	public List<AllergyData> getAllergyData1(String type) {
		// TODO Auto-generated method stub
		return  masterAllergyRepository.findAllNamesByAllergy_type(type);
	}

	@Override
	public List<AllergyData> getAllergyData2(String type) {
		// TODO Auto-generated method stub
		return masterAllergyRepository.findAllIdsByAllergy_type(type);
	}

	@Override
	public List<AllergyData> getAllergyData3(String type, String name) {
		// TODO Auto-generated method stub
		return masterAllergyRepository.findAllIdsByAllergy_typeAndAllergy_name(type, name);
	}

	

}
