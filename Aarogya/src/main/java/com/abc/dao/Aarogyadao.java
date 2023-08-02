package com.abc.dao;

import java.util.*;

import com.abc.model.AarogyaMember;

public interface Aarogyadao{
	 public long choices();
	 //user
	 public AarogyaMember searchByContact(long contactnum);
	 public AarogyaMember searchByCity(String city);
	 public List<AarogyaMember> searchByAgeGroup(int Age1, int Age2);
	 //admin
	 public boolean addMember(AarogyaMember Member);
	 public boolean deleteMember(long contactnum);
	 public boolean MarkRecover(long contactnum);
	 public List<AarogyaMember> viewallMembers();
}
