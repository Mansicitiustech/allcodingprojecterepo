package com.citiustech.service;

import java.util.List;

import com.citiustech.entities.AllergyData;

public interface MasterAllergyService {

	void submitMasterAllergyData(AllergyData allergyData);

	AllergyData getAllergyData(int id);

	List<AllergyData> getAllAllergyData();

	List<Integer> getAllAlleryId();

	String getAllergyTypeById(int id);

	String getAllergyName(int id);

	List<String> getAllAlleryType();

	List<String> getAllergyNamesbyType(String type);

	List<AllergyData> getAllergyData1(String type);

	List<String> getAllAlleryName();

	List<AllergyData> getAllergyData2(String type);

	List<AllergyData> getAllergyData3(String type, String name);


}
