package com.ct.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ct.model.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails,Integer>{
	public Optional<UserDetails> findUserByEmail(String email);
}
