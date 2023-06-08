package com.pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pack.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	@Query("select a from User a where a.corpid=?1")
	public List<User> findById1(int id);
}
