package com.ct.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.model.Country;
import com.ct.model.State;

public interface StateRepo extends JpaRepository<State,Integer> {

}
