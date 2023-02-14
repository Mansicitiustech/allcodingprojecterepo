package com.ct.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.model.Password;

public interface PasswordRepo extends JpaRepository<Password,Long> {

}
