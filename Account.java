package com.pack.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
@Entity
@Table(name="account1")
public class Account {
	
	
	
	private int corpid;
	
	public int getCorpid() {
		return corpid;
	}
	public void setCorpid(int corpid) {
		this.corpid = corpid;
	}

    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="demo_sql")
    @GenericGenerator(name="demo_sql",strategy="com.pack.model.Sequence",parameters= {
    		@Parameter(name=Sequence.PREFIX1,value="ICIC"),
    		@Parameter(name=Sequence.NUMBERDEFAULT1,value="%10d")
    })
    @Id
    @Column(name="accnum",length=30)
    private String accnum;	
	
    @Column(name = "accname",nullable=false)
	private String accname;
	@Column(name="branch")
	private String branch;
	@Column(name = "currency",nullable=false)
	private String currency;
	@Column(name = "availbal")
	private long availbal;
	public String getAccnum() {
		return accnum;	}
	public void setAccnum(String accnum) {
		this.accnum = accnum;
	}
	public String getAccname() {
		return accname;
	}
	public void setAccname(String accname) {
		this.accname = accname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getAvailbal() {
		return availbal;
	}
	public void setAvailbal(long availbal) {
		this.availbal = availbal;
	}
	public Account(int corpid, String accnum, String accname, String branch, String currency, long availbal) {
		super();
		this.corpid = corpid;
		this.accnum = accnum;
		this.accname = accname;
		this.branch = branch;
		this.currency = currency;
		this.availbal = availbal;
	}
	public Account() {
		super();
	}
	

		
}
