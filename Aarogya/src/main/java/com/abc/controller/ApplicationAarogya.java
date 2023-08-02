package com.abc.controller;
import java.util.*;

import javax.servlet.http.HttpServlet;

import com.abc.dao.*;
import com.abc.model.AarogyaMember;
public class ApplicationAarogya extends HttpServlet {
	
	public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	Aarogyadao dao=new AarogyadaoImpl();
	while(true)
	{
	long opt=dao.choices();
	if(opt==1) {
		List<AarogyaMember> al=dao.viewallMembers();
		for(int i=0;i<al.size();i++) {
			System.out.println("Member"+(i+1));
			System.out.println("Member Name"+al.get(i).getName());
			System.out.println("Member age"+al.get(i).getAge());
			System.out.println("Member gender"+al.get(i).getGender());
			System.out.println("Member Aadhar Number"+al.get(i).getAadharNum());
			System.out.println("Member Contact Number"+al.get(i).getContactNum());
			System.out.println("Member city"+al.get(i).getCity());
			System.out.println("Member Address"+al.get(i).getAddress());
			System.out.println("Member Admission Date"+al.get(i).getAdmissionDt());
			System.out.println("Member Guard Name"+al.get(i).getGuardName());
			System.out.println("Member Guard Address"+al.get(i).getGuardAddress());
			System.out.println("Member Guard Contact Number"+al.get(i).getGuardcontactNumber());
		}
	}
	else if(opt==2) {
		System.out.println("Enter Member contact to search:");
		long contactnum=s.nextLong();
		AarogyaMember m1=dao.searchByContact(contactnum);
		if(m1==null) {
			System.out.println("no record found");
		}
		else
		{
			System.out.println("Member Name"+m1.getName());
			System.out.println("Member age"+m1.getAge());
			System.out.println("Member gender"+m1.getGender());
			System.out.println("Member Aadhar Number"+m1.getAadharNum());
			System.out.println("Member Contact Number"+m1.getContactNum());
			System.out.println("Member city"+m1.getCity());
			System.out.println("Member Address"+m1.getAddress());
			System.out.println("Member Admission Date"+m1.getAdmissionDt());
			System.out.println("Member Guard Name"+m1.getGuardName());
			System.out.println("Member Guard Address"+m1.getGuardAddress());
			System.out.println("Member Guard Contact Number"+m1.getGuardcontactNumber());
		}
	}
	else if(opt==3) {
		System.out.println("Enter city to search:");
		String city=s.next();
		AarogyaMember m1=dao.searchByCity(city);
		if(m1==null) {
			System.out.println("no record found");
		}
		else
		{
			System.out.println("Member Name"+m1.getName());
			System.out.println("Member age"+m1.getAge());
			System.out.println("Member gender"+m1.getGender());
			System.out.println("Member Aadhar Number"+m1.getAadharNum());
			System.out.println("Member Contact Number"+m1.getContactNum());
			System.out.println("Member city"+m1.getCity());
			System.out.println("Member Address"+m1.getAddress());
			System.out.println("Member Admission Date"+m1.getAdmissionDt());
			System.out.println("Member Guard Name"+m1.getGuardName());
			System.out.println("Member Guard Address"+m1.getGuardAddress());
			System.out.println("Member Guard Contact Number"+m1.getGuardcontactNumber());
		}
		
	}
	else if(opt==4) {
		System.out.println("Enter Age1:");
		int age1=s.nextInt();
		System.out.println("Enter Age2");
		int age2=s.nextInt();
		List<AarogyaMember> al=dao.searchByAgeGroup(age1, age2);
		for(int i=0;i<al.size();i++) {
			System.out.println("Member"+(i+1));
			System.out.println("Member Name"+al.get(i).getName());
			System.out.println("Member age"+al.get(i).getAge());
			System.out.println("Member gender"+al.get(i).getGender());
			System.out.println("Member Aadhar Number"+al.get(i).getAadharNum());
			System.out.println("Member Contact Number"+al.get(i).getContactNum());
			System.out.println("Member city"+al.get(i).getCity());
			System.out.println("Member Address"+al.get(i).getAddress());
			System.out.println("Member Admission Date"+al.get(i).getAdmissionDt());
			System.out.println("Member Guard Name"+al.get(i).getGuardName());
			System.out.println("Member Guard Address"+al.get(i).getGuardAddress());
			System.out.println("Member Guard Contact Number"+al.get(i).getGuardcontactNumber());
		}
	}
	else if(opt==5) {
		AarogyaMember mem=new AarogyaMember();
		
		boolean b=dao.addMember(mem);
		if(b) {
			System.out.println("Member added succesfully");
			}
		else {System.out.println("fail");}
	}
	else if(opt==6) {
		System.out.println("Enter Member contactNum");
        long contact=s.nextLong();
		boolean b1=dao.MarkRecover(contact);
		if(b1) {
	        System.out.println("Member ID marked as Recovered");
	    }
	    else {
	        System.out.println("fail");
	    }
	}
	else if(opt==7) {
		System.out.println("Enter MemberID to delete:");
		int id=s.nextInt();
		boolean b=dao.deleteMember(id);
		if(b) {
			System.out.println("Member record deleted succesfully");
			}
		else {System.out.println("fail");}
	}
	else
	{
		break;
	}
	}
}}	

