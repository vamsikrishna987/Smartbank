package com.pack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.model.Login;

public interface LoginRepository extends JpaRepository<Login,Integer>{
	Optional<Login> findByUserName(String userName);
	
	
}
