package com.abc.controller;
import java.io.*;
import java.util.List;

import javax.servlet.http.*;
import com.abc.dao.*;
import com.abc.model.*;
public class controller extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String opt=request.getParameter("options");
		if(opt==null) {System.out.print("invalid request");}
		switch(opt) {
		case "add":
			add(request,response);
			break;
		case "delete":
			delete(request,response);
			break;
		case "view":
			view(request,response);
			break;
		case "searchbyage":
			searchbyage(request,response);
			break;
		case "searchbycity":
			searchbycity(request,response);
			break;
		case "searchbycontact":
			searchbycontact(request,response);
			break;
		}	
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		Aarogyadao dao=new AarogyadaoImpl();
		AarogyaMember mem=new AarogyaMember();
		mem.setName(request.getParameter("name"));
		mem.setAge(Integer.parseInt(request.getParameter("age")));  
		mem.setGender(request.getParameter("gender"));
		mem.setAadharNum(Integer.parseInt(request.getParameter("aadhar")));
		mem.setContactNum(Integer.parseInt(request.getParameter("contact")));
		mem.setCity(request.getParameter("city"));
		mem.setAddress(request.getParameter("address"));
		mem.setAdmissionDt(request.getParameter("date"));
		mem.setGuardName(request.getParameter("gname"));
		mem.setGuardAddress(request.getParameter("gaddress"));
		mem.setGuardcontactNumber(Integer.parseInt(request.getParameter("gcontact")));	
		boolean b=dao.addMember(mem);
		if(b) {
            out.print("<h1>success</h1>");
        }
        else {
            out.print("<h1>Fail</h1>");
        }
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		Aarogyadao dao=new AarogyadaoImpl();
		long c_num=Long.parseLong(request.getParameter("contact"));
		boolean b=dao.deleteMember(c_num);
		if(b) {
			out.print("deleted successfully");}
		else {out.print("enter correct information");}
	}
	
	private void view(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		Aarogyadao dao=new AarogyadaoImpl();
		List<AarogyaMember> al=dao.viewallMembers();
		for(int i=0;i<al.size();i++) {
			out.print("Member"+(i+1));
			out.print("Member Name"+al.get(i).getName());
			out.print("Member age"+al.get(i).getAge());
			out.print("Member gender"+al.get(i).getGender());
			out.print("Member Aadhar Number"+al.get(i).getAadharNum());
			out.print("Member Contact Number"+al.get(i).getContactNum());
			out.print("Member city"+al.get(i).getCity());
			out.print("Member Address"+al.get(i).getAddress());
			out.print("Member Admission Date"+al.get(i).getAdmissionDt());
			out.print("Member Guard Name"+al.get(i).getGuardName());
			out.print("Member Guard Address"+al.get(i).getGuardAddress());
			out.print("Member Guard Contact Number"+al.get(i).getGuardcontactNumber());
		}
	}
	private void searchbyage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		Aarogyadao dao=new AarogyadaoImpl();
		int age1=Integer.parseInt(request.getParameter("min"));
		int age2=Integer.parseInt(request.getParameter("max"));
		List<AarogyaMember> al=dao.searchByAgeGroup(age1, age2);
		for(int i=0;i<al.size();i++) {
			out.print("Member"+(i+1));
			out.print("Member Name"+al.get(i).getName());
			out.print("Member age"+al.get(i).getAge());
			out.print("Member gender"+al.get(i).getGender());
			out.print("Member Aadhar Number"+al.get(i).getAadharNum());
			out.print("Member Contact Number"+al.get(i).getContactNum());
			out.print("Member city"+al.get(i).getCity());
			out.print("Member Address"+al.get(i).getAddress());
			out.print("Member Admission Date"+al.get(i).getAdmissionDt());
			out.print("Member Guard Name"+al.get(i).getGuardName());
			out.print("Member Guard Address"+al.get(i).getGuardAddress());
			out.print("Member Guard Contact Number"+al.get(i).getGuardcontactNumber());
		}
		
	}

	private void searchbycity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		Aarogyadao dao=new AarogyadaoImpl();
		String city=request.getParameter("city");
		AarogyaMember m1=dao.searchByCity(city);
		if(m1==null) {
			out.print("no record found");
		}
		else
		{
			out.print("Member Name"+m1.getName());
			out.print("Member age"+m1.getAge());
			out.print("Member gender"+m1.getGender());
			out.print("Member Aadhar Number"+m1.getAadharNum());
			out.print("Member Contact Number"+m1.getContactNum());
			out.print("Member city"+m1.getCity());
			out.print("Member Address"+m1.getAddress());
			out.print("Member Admission Date"+m1.getAdmissionDt());
			out.print("Member Guard Name"+m1.getGuardName());
			out.print("Member Guard Address"+m1.getGuardAddress());
			out.print("Member Guard Contact Number"+m1.getGuardcontactNumber());
		}
		
	}

	private void searchbycontact(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out=response.getWriter();
		Aarogyadao dao=new AarogyadaoImpl();
		long c_num=Long.parseLong(request.getParameter("contact"));
		AarogyaMember m1=dao.searchByContact(c_num);
		if(m1==null) {
			out.print("no record found");
		}
		else
		{
			out.print("Member Name"+m1.getName());
			out.print("Member age"+m1.getAge());
			out.print("Member gender"+m1.getGender());
			out.print("Member Aadhar Number"+m1.getAadharNum());
			out.print("Member Contact Number"+m1.getContactNum());
			out.print("Member city"+m1.getCity());
			out.print("Member Address"+m1.getAddress());
			out.print("Member Admission Date"+m1.getAdmissionDt());
			out.print("Member Guard Name"+m1.getGuardName());
			out.print("Member Guard Address"+m1.getGuardAddress());
			out.print("Member Guard Contact Number"+m1.getGuardcontactNumber());
		}
	}
}
