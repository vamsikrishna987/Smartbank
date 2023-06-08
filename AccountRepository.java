package com.pack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pack.model.Account;

public interface AccountRepository extends JpaRepository<Account,String>{


@Query("select a from Account a where a.corpid like %?1%")
public List<Account> findAll(int id);

@Query("select a from Account a where a.corpid=?1")
public List<Account> findById(int id);

}
