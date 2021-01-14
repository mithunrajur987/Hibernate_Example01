package com.cluster;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *  Cluster Software Solutions.
 *  (Mob:98451-31637/39
 *  www.clusterindia.com)
 */
// program to give demo on load() method
public class Demo {

	public static void main(String[] args) {

		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();

		Department d = null;
		
	/*	
		// retrieving Department which is present in database using load() method 
		d = (Department) ses.load(Department.class, new Integer(1)); // proxy object is created with only identifier 
		System.out.println("Department id is " + d.getDeptid());
	//	System.out.println("Department Name is " + d.getDname()); // proxy object is initialized with other values
	*/	
	
	/*	
		// retrieving Department which is not present in database using load() method
		d = (Department) ses.load(Department.class, new Integer(10));
		System.out.println("Department id is " + d.getDeptid());
	//	System.out.println("Department Name is " + d.getDname());
	*/	
		
	/*	
		// retrieving Department which is present in database using get() method
		d = (Department) ses.get(Department.class, new Integer(1));
		System.out.println("Department id is " + d.getDeptid());
	//	System.out.println("Department Name is " + d.getDname());
	*/	
	
		
	/*
		// retrieving Department which is not present in database using get() method
		d = (Department) ses.get(Department.class, new Integer(10));
		System.out.println("Department is " + d);
	//	System.out.println("Department id is " + d.getDeptid());
	//	System.out.println("Department Name is " + d.getDname());
	*/


		tx.commit();
		ses.close();
		sf.close();
	}
}
