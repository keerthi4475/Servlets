package com.abc.controller;
import java.io.*;
import javax.servlet.http.*;
import com.abc.dao.*;
import com.abc.model.*;
public class addMembercontroller extends HttpServlet{
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
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
		dao.addMember(mem);
	}
}
