package com.abc.HibernateDemo;

import java.util.List;
import java.util.Scanner;

import com.abc.HibernateDemo.dao.DaoImpl;
import com.abc.HibernateDemo.dao.DaoInterface;
import com.abc.HibernateDemo.model.Employee;

public class App 
{
	
	
	Scanner s=new Scanner(System.in);
    DaoInterface dao=new DaoImpl();
    public void addEmployee() {
        Employee e=new Employee();
        System.out.println("Enter Id");
        int id=s.nextInt();
        e.setId(id);
        System.out.println("Enter Name");
        String nam=s.next();
        e.setEname(nam);
        System.out.println("Enter City");
        String city=s.next();
        e.setCity(city);
        System.out.println("Enter Email");
        String email=s.next();
        e.setEmail(email);
        System.out.println("Enter salary");
        double sal=s.nextDouble();
        e.setSalary(sal);
        dao.addEmployee(e);
    }
    public void deleteEmp()
    {
    	System.out.println("Enter id");
    	dao.deleteEmp(s.nextInt());
    }
    public void getEmployeeById()
    {
    	System.out.println("Enter id");
    	int id=s.nextInt();
    	Employee e=dao.getEmployeeById(id);
    	System.out.println("Employee id : "+e.getId());
    	System.out.println("Employee Name : "+e.getEname());
    	System.out.println("Employee City : "+e.getCity());
    	System.out.println("Employee Salary : "+e.getSalary());
    	System.out.println("Emloyee Email : "+e.getEmail());
    }
    public void viewAllEmployee()
    {
    	List<Employee> list=dao.viewAllEmployee();
    	for(Employee each:list)
    	{
    		System.out.println("Employee id : "+each.getId());
        	System.out.println("Employee Name : "+each.getEname());
        	System.out.println("Employee City : "+each.getCity());
        	System.out.println("Employee Salary : "+each.getSalary());
        	System.out.println("Emloyee Email : "+each.getEmail());
    	}
    }
    public static void main( String[] args )
    {
    	
         App obj=new App();
         
         while(true)
         {
         	System.out.println("1. Add Emp");
         	System.out.println("2. Delete Emp");
         	System.out.println("3. View all Emp");
         	System.out.println("4. View Emp by ID");
         	System.out.println("5. Exit");
         	int option=obj.s.nextInt();
         	if(option==1) {
         		obj.addEmployee();}
         	if(option==2) {
         		obj.deleteEmp();}
         	if(option==3) {
         		obj.viewAllEmployee();}
         	if(option==4) {
         		obj.getEmployeeById();}
         }
     }
 }
        /* Employee e=new Employee();
		e.setId(102);
		e.setEname("ram....");
		e.setCity("Hyd");
		e.setEmail("ramesh@gmail.com");
		e.setSalary(100000);
        
		dao.addEmployee(e); */
		
         //dao.deleteEmp(101);
        // Employee e=dao.getEmployeeById(102);
         //System.out.println("EID: "+e.getId());
         //System.out.println("EName: "+e.getEname());
        
  
