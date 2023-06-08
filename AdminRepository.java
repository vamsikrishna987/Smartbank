package com.pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

	
}
