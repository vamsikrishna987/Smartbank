package com.pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user1")
public class User {
	
	private int corpid;
	
	public int getCorpid() {
		return corpid;
	}
	public void setCorpid(int corpid) {
		this.corpid = corpid;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="loginid")
	private int loginid;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name = "address",nullable=false)
	private String address;
	
	@Column(name = "phone")
	private long phone;
	
	@Column(name="roles")
	private String roles;
	
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public int getLoginid() {
		return loginid;
	}
	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	public User() {
		super();
	
	}
	public User(int corpid, int loginid, String userName, String password, String address, long phone, String roles) {
		super();
		this.corpid = corpid;
		this.loginid = loginid;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.roles = roles;
	}
	
	
}
