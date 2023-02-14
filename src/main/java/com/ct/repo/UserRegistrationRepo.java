package com.ct.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.model.UserRegistration;

public interface UserRegistrationRepo  extends JpaRepository<UserRegistration,Long>{

}
