package com.abc.model;

import java.util.Scanner;

public class AarogyaMember {
     private int memberID;
	 private String name;
     private int age;
     private String gender;
     private long AadharNum;
     private long contactNum;
     private String city;
     private String address;
     private String admissionDt;
     private String guardName;
     private String guardAddress;
     private long guardcontactNumber;
     private String recovermembers;
 	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getAadharNum() {
		return AadharNum;
	}
	public void setAadharNum(long aadharNum) {
		AadharNum = aadharNum;
	}
	public long getContactNum() {
		return contactNum;
	}
	public void setContactNum(long contactNum) {
		this.contactNum = contactNum;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdmissionDt() {
		return admissionDt;
	}
	public void setAdmissionDt(String admissionDt) {
		this.admissionDt = admissionDt;
	}
	public String getGuardName() {
		return guardName;
	}
	public void setGuardName(String guardName) {
		this.guardName = guardName;
	}
	public String getGuardAddress() {
		return guardAddress;
	}
	public void setGuardAddress(String guardAddress) {
		this.guardAddress = guardAddress;
	}
	public long getGuardcontactNumber() {
		return guardcontactNumber;
	}
	public void setGuardcontactNumber(long guardcontactNumber) {
		this.guardcontactNumber = guardcontactNumber;
	}
}
