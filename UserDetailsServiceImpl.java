package com.pack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pack.model.Login;
import com.pack.repository.LoginRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private LoginRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<Login> user = userRepository.findByUserName(userName);
	
		return user.map(UserDetailsImpl::new).get();
	}

}