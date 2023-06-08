package com.pack;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.pack.repository.UserRepository;
import com.pack.model.Admin;
import com.pack.model.User;
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
 class UserTest {

	
  @Autowired
  private UserRepository repository;
  
	User ad=new User();
	
  
  
  @BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	
	}
	
	@Test
	void save()
	{
	                             
		ad.setUserName("Testuser");
		ad.setPassword("harsha");;
		ad.setAddress("Kadiri");
		ad.setPhone(830949921);
		ad.setRoles("user");
		ad.setCorpid(1);
		User a=repository.save(ad);
		assertNotEquals(0,ad.getLoginid());
	}

  @Test
   void testListAdmins()
  {
	  List<User> ad=(List<User>)repository.findAll();
	  assertNotEquals(0,ad.size());
}
  
  @Test
   void testListAdmins1()
  {
	  Optional<User> ad1=repository.findById(1);
	  assertNotEquals(0,ad1.get());
}
}