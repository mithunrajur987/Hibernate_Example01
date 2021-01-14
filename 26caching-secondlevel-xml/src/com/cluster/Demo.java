package com.cluster;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *  Cluster Software Solutions.
 *  (Mob:98451-31637/39
 *  www.clusterindia.com)
 */
public class Demo {

	public static void main(String[] args) {

		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses1 = sf.openSession();
		Transaction tx1 = ses1.getTransaction();
		tx1.begin();
		
		//LOADING DEPARTMENT FOR THE FIRST TIME HITS TO DATABASE
		Department d1 = null;
		d1 = (Department) ses1.load(Department.class, new Integer(1));
		System.out.println("Getting values from database");
		System.out.println("Department id is "+d1.getDeptid());
		System.out.println("Department Name is "+d1.getDname());
		System.out.println("--------------------------------------------------");
		
		
		//LOADING SAME DEPARTMENT FOR THE SECOND TIME WILL NOT HIT DATABASE, INSTEAD GETS THE VALUE FROM SESSION CACHE
		d1 = (Department) ses1.load(Department.class, new Integer(1));
		System.out.println("Getting values from first level cache");
		System.out.println("Department id is "+d1.getDeptid());
		System.out.println("Department Name is "+d1.getDname());
		System.out.println("--------------------------------------------------");
		
		tx1.commit();
		ses1.close();
		
		Session ses2 = sf.openSession();
		Transaction tx2 = ses2.getTransaction();
		tx2.begin();
		
		// LOADING SAME DEPARTMENT FOR THE SECOND TIME WITH A NEW SESSION OBJECT WILL NOT HIT DATABASE, 
		// INSTEAD GETS THE VALUE FROM SESSIONFACTORY CACHE
		Department d2 = (Department) ses2.load(Department.class, new Integer(1));
		System.out.println("Getting values from second level cache");
		System.out.println("Department id is "+d2.getDeptid());
		System.out.println("Department Name is "+d2.getDname());
		System.out.println("--------------------------------------------------");
		
		tx2.commit();
		ses2.close();
		
		sf.close();
	}
}
