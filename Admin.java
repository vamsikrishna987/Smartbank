package com.pack.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="corporate1")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="corpid")
	private int corpid;
	
	@Column(name = "userName",nullable=false)
	private String userName;
	
	@Column(name = "address",nullable=false)
	private String address;
	
	@Column(name = "phone")
	private long phone;
	
	@Column(name="roles")
	private String roles;
	
	@Column(name="password")
	private String password;

	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="corpid",referencedColumnName = "corpid")
	private List<User>  user;
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
	public int getCorpid() {
		return corpid;
	}
	public void setCorpid(int corpid) {
		this.corpid = corpid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="corpid",referencedColumnName = "corpid")
	private List<Account> account;
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	public Admin(String userName, String address, long phone, String roles, String password) {
		
		
		this.userName = userName;
		this.address = address;
		this.phone = phone;
		this.roles = roles;
		this.password = password;
		}
	public Admin() {
		super();
		
	}
  
		


}
