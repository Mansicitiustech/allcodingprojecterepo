package com.citiustech.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.entities.AllergyData;
import com.citiustech.service.MasterAllergyService;

@RestController
@RequestMapping("masterAllergy")
@CrossOrigin("*")
public class MasterAllergy {
	@Autowired
	MasterAllergyService masterAllergyService;
	
	
	@PostMapping("allergyData")
	public String submitMasterAllergyData(@RequestBody AllergyData allergyData)
	{
		masterAllergyService.submitMasterAllergyData(allergyData);
		return "Allergy Data successfully Submited";
	}
	@GetMapping("allergyType/{id}")
	public List<String> getAllergyType(@PathVariable("id") int id)
	{
		AllergyData allergyData=masterAllergyService.getAllergyData(id);
		List<String> list=new ArrayList<>();
		list.add(allergyData.getAllergy_type());
		return list;
	}
	@GetMapping("allergyName/{id}")
	public List<String> getAllergyName(@PathVariable("id") int id)
	{
		AllergyData allergyData=masterAllergyService.getAllergyData(id);
		List<String> list=new ArrayList<>();
		list.add(allergyData.getAllergy_name());
		return list;
	}
	@GetMapping("allergyData")
	public List<AllergyData> getAllAllergyData()
	{
		List<AllergyData> list= masterAllergyService.getAllAllergyData();
		return list;
		
	}
	@GetMapping("allergyDataId")
	public List<Integer> getAllAllergyId()
	{
		return masterAllergyService.getAllAlleryId();
	}
	
	@GetMapping("allergyDataType")
	public List<String> getAllAllergyType()
	{
		return masterAllergyService.getAllAlleryType().stream().distinct().collect(Collectors.toList());
	}
	@GetMapping("allergyAllName")
	public List<String> getAllAllergyName()
	{
		return masterAllergyService.getAllAlleryName().stream().distinct().collect(Collectors.toList());
	}
	@GetMapping("allergyDataType/{id}")
	public String getNameById(@PathVariable("id") int id )
	{
		String type=masterAllergyService.getAllergyTypeById(id);
		return type;
	}
	@GetMapping("allergyNamesByType/{type}")
	public List<String> getAllergyNameByType(@PathVariable("type") String type)
	{
		List<AllergyData> list=masterAllergyService.getAllergyData1(type);
		List<String> ls= list.stream().map(r->r.getAllergy_name()).distinct().collect(Collectors.toList());
		
		return ls;
	}
	@GetMapping("allergyIdsByType/{type}")
	public List<Integer> getAllergyIdsByType(@PathVariable("type") String type)
	{
		List<AllergyData> list=masterAllergyService.getAllergyData2(type);
		List<Integer> ls= list.stream().map(r->r.getAllergy_id()).collect(Collectors.toList());
		
		return ls;
	}
	
	@GetMapping("allergyIdsByTypeAndName/{type}/{name}")
	public List<Integer> getAllergyIdsByType(@PathVariable("type") String type,@PathVariable("name") String name)
	{
		List<AllergyData> list=masterAllergyService.getAllergyData3(type,name);
		List<Integer> ls= list.stream().map(r->r.getAllergy_id()).collect(Collectors.toList());
		
		return ls;
	}
}
