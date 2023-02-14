package com.ct.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.model.City;



public interface CityRepo extends JpaRepository<City,Integer> {

}
