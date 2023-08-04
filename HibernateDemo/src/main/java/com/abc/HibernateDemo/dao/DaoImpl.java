package com.abc.HibernateDemo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abc.HibernateDemo.model.Employee;

public class DaoImpl implements DaoInterface{

	SessionFactory sf=null;
	public DaoImpl() {
		sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	

	public void addEmployee(Employee e) {
        Session session=sf.openSession();
		
		Transaction txn=session.beginTransaction();
		session.save(e);
		txn.commit();
		
		session.close();
		
		
	}



	@Override
	public void deleteEmp(int id) {
		Session session=sf.openSession();
		Transaction txn=session.beginTransaction();
		Employee e=session.get(Employee.class, id);  // get record from db
		session.delete(e);
		txn.commit();
		
		session.close();
		
	}



	@Override
	public Employee getEmployeeById(int i) {
		Session session=sf.openSession();
		
		Employee e=session.get(Employee.class, i); 
		session.close();
		return e;
	}
  /*  
	public Employee getsalaryRange(int min,max) {
		Session session=sf.openSession();
		
		Employee e=session.get(Employee.class, i); 
		session.close();
		return e;
	}

*/

	@Override
	public List<Employee> viewAllEmployee() {
		
		Session session=sf.openSession();

		
		List<Employee> el=session.createQuery("from Employee", Employee.class).getResultList();
		session.close();
		return el;
	}
	
}
