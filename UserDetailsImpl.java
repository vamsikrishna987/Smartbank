package com.pack.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.pack.model.Login;

public class UserDetailsImpl implements UserDetails {

	 
	static final Logger logger=LogManager.getLogger(UserDetailsImpl.class);
	static final String ERROR="error";
	private String userName;
	private String password;
	private boolean isActive;
	private List<GrantedAuthority> authorities;

	public UserDetailsImpl(Login user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.isActive = user.isActive();
		this.authorities = Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	public UserDetailsImpl() {}

	
	  @Override public Collection<? extends GrantedAuthority> getAuthorities() {
	  logger.info(authorities); return authorities; }
	  
	  @Override public String getPassword() { logger.info(password);
	  return password; }
	  
	  @Override public String getUsername() { logger.info(userName);
	  return userName; }
	  
	  @Override public boolean isAccountNonExpired() { return true; }
	  
	  @Override public boolean isAccountNonLocked() { return true; }
	  
	  @Override public boolean isCredentialsNonExpired() { return true; }
	  
	  @Override public boolean isEnabled() { return isActive; }
	 
}