package com.ct.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ct.model.User;

public interface UserRepo extends JpaRepository<User,Long> {
public Optional<User> findUserByEmail(String email);
}
