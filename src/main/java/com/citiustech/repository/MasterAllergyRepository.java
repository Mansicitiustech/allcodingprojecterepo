package com.citiustech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.citiustech.entities.AllergyData;

@Repository
public interface MasterAllergyRepository extends JpaRepository<AllergyData, Integer>{
	@Query("select u.allergy_type from AllergyData u where u.allergy_id=:id")	
	String findAllergyTypeById(int id);
	
	@Query("select u.allergy_name from AllergyData u where u.allergy_id=:id")
	String findAllergyNameById(int id);
	
	@Query("select u.allergy_name from AllergyData u where u.allergy_type=:type")	
	List<String> findAllergyNamesByName(String type);
	@Query("select u from AllergyData u where u.allergy_type=:type")
	AllergyData findAllByAllergy_type(String type);
	@Query("select u from AllergyData u where u.allergy_type like :type ")
	List<AllergyData> findAllNamesByAllergy_type(String type);
	@Query("select u from AllergyData u where u.allergy_type like :type ")
	List<AllergyData> findAllIdsByAllergy_type(String type);
	
	@Query("select u from AllergyData u where u.allergy_type like :type And u.allergy_name like :name")
	List<AllergyData> findAllIdsByAllergy_typeAndAllergy_name(String type,String name);
	


	

}
