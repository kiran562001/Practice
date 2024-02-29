package com.cjc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "Account_Details")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Account_No")
	private int acNo;
	@Column(name = "Account_Name")
	private String acName;
	@Column(name = "Account_Address")
	private String acAddress;
	@Column(name = "Mobile_No")
	private long mobileNO;
	@Column(name = "Adhar_No")
	private long adharNo;
	@Column(name = "Pan_No")
	private String panNO;
	@Column(name = "Account_Gender")
	private String gender;
	@Column(name = "Account_Balance")
	private double balance;
	@Column(name = "Account_Age")
	private int age;

	public int getAcNo() {
		return acNo;
	}

	public String getAcName() {
		return acName;
	}

	public void setAcName(String acName) {
		this.acName = acName;
	}

	public String getAcAddress() {
		return acAddress;
	}

	public void setAcAddress(String acAddress) {
		this.acAddress = acAddress;
	}

	public long getMobileNO() {
		return mobileNO;
	}

	public void setMobileNO(long mobileNO) {
		this.mobileNO = mobileNO;
	}

	public long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}

	public String getPanNO() {
		return panNO;
	}

	public void setPanNO(String panNO) {
		this.panNO = panNO;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
