package com.abc.dao;

import java.sql.*;
import java.util.*;

import com.abc.model.AarogyaMember;

public class AarogyadaoImpl implements Aarogyadao {
	Connection con = null;

	public AarogyadaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Aarogyaapp", "root", "0106");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public long choices() {
		System.out.println("Enter 1 for Admin and 2 for User");
		Scanner s = new Scanner(System.in);
		int o = s.nextInt();
		if (o == 2) {
			System.out.println("Press 1 to view list of all available members");
			System.out.println("Press 2 to search member by Contact Number");
			System.out.println("Press 3 to search member from a particular city");
			System.out.println("Press 4 to search member from a particular age group");
		} else if (o == 1) {
			System.out.println("Press 5 for adding new member");
			System.out.println("Press 6 to mark recovery of a member");
			System.out.println("Press 7 to delete data of a member");
		}
		System.out.println("Press 0 to exit");
		long option = s.nextLong();
		return option;
	}

	@Override
	public List<AarogyaMember> viewallMembers() {
		ArrayList<AarogyaMember> al = new ArrayList();
		AarogyaMember mem = new AarogyaMember();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from Aarogyamember");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mem.setName(rs.getString(1));
				mem.setAge(rs.getInt(2));
				mem.setGender(rs.getString(3));
				mem.setAadharNum(rs.getInt(4));
				mem.setContactNum(rs.getInt(5));
				mem.setCity(rs.getString(6));
				mem.setAddress(rs.getString(7));
				mem.setAdmissionDt(rs.getString(8));
				mem.setGuardName(rs.getString(9));
				mem.setGuardAddress(rs.getString(10));
				mem.setGuardcontactNumber(11);
				al.add(mem);
			}
		}

		catch (Exception e) {
			System.out.println(e);
		}
		return al;
	}

	@Override
	public AarogyaMember searchByContact(long contact) {
		AarogyaMember mem = new AarogyaMember();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from Aarogyamember where contactNum = ?");
			stmt.setLong(1, contact);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mem.setName(rs.getString(1));
				mem.setAge(rs.getInt(2));
				mem.setGender(rs.getString(3));
				mem.setAadharNum(rs.getInt(4));
				mem.setContactNum(rs.getInt(5));
				mem.setCity(rs.getString(6));
				mem.setAddress(rs.getString(7));
				mem.setAdmissionDt(rs.getString(8));
				mem.setGuardName(rs.getString(9));
				mem.setGuardAddress(rs.getString(10));
				mem.setGuardcontactNumber(11);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mem;
	}

	@Override
	public AarogyaMember searchByCity(String city) {
		AarogyaMember mem = new AarogyaMember();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from Aarogyamember where city = ?");
			stmt.setString(1, city);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mem.setName(rs.getString(1));
				mem.setAge(rs.getInt(2));
				mem.setGender(rs.getString(3));
				mem.setAadharNum(rs.getInt(4));
				mem.setContactNum(rs.getInt(5));
				mem.setCity(rs.getString(6));
				mem.setAddress(rs.getString(7));
				mem.setAdmissionDt(rs.getString(8));
				mem.setGuardName(rs.getString(9));
				mem.setGuardAddress(rs.getString(10));
				mem.setGuardcontactNumber(11);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return mem;
	}

	@Override
	public List<AarogyaMember> searchByAgeGroup(int Age1, int Age2) {
		ArrayList<AarogyaMember> al = new ArrayList();
		AarogyaMember mem = new AarogyaMember();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from aarogyamember where Age>=? and Age<=?");
			stmt.setInt(1, Age1);
			stmt.setInt(2, Age2);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				mem.setName(rs.getString(1));
				mem.setAge(rs.getInt(2));
				mem.setGender(rs.getString(3));
				mem.setAadharNum(rs.getInt(4));
				mem.setContactNum(rs.getInt(5));
				mem.setCity(rs.getString(6));
				mem.setAddress(rs.getString(7));
				mem.setAdmissionDt(rs.getString(8));
				mem.setGuardName(rs.getString(9));
				mem.setGuardAddress(rs.getString(10));
				mem.setGuardcontactNumber(11);
				al.add(mem);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return al;
	}

	@Override
	public boolean addMember(AarogyaMember Member) {
		AarogyaMember mem = new AarogyaMember();
		boolean b = false;
		try {
			PreparedStatement stmt = con.prepareStatement(
					"insert into Aarogyamember(name,age,gender,AadharNum,contactNum,city,address,admissionDt,guardName,guardAddress,guardcontactNumber) values(?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, Member.getName());
			stmt.setInt(2, Member.getAge());
			stmt.setString(3, Member.getGender());
			stmt.setLong(4, Member.getAadharNum());
			stmt.setLong(5, Member.getContactNum());
			stmt.setString(6, Member.getCity());
			stmt.setString(7, Member.getAddress());
			stmt.setString(8, Member.getAdmissionDt());
			stmt.setString(9, Member.getGuardName());
			stmt.setString(10, Member.getGuardAddress());
			stmt.setLong(11, Member.getGuardcontactNumber());
			if (stmt.executeUpdate() > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	@Override
	public boolean deleteMember(long contactNum) {
		boolean b = false;
		try {
			PreparedStatement stmt = con.prepareStatement("delete from Aarogyamember where contactNum=?");
			stmt.setLong(1, contactNum);
			if (stmt.executeUpdate() > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}

	@Override
	public boolean MarkRecover(long contactNum) {
		AarogyaMember mem = new AarogyaMember();
		boolean b = false;
		try {
			PreparedStatement stmt = con
					.prepareStatement("UPDATE Aarogyamember SET recovery_status = ? WHERE contactNum = ?");
			stmt.setString(1, "recover");
			stmt.setLong(2, contactNum);
			if (stmt.executeUpdate() > 0) {
				b = true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return b;
	}
}
