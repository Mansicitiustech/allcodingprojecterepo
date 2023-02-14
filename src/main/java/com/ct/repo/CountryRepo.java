package com.ct.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.model.Country;

public interface CountryRepo extends JpaRepository<Country,Integer>{

}
