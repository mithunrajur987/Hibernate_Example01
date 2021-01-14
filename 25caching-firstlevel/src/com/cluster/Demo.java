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
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();

		Department d1 = null;
		//LOADING DEPARTMENT FOR THE FIRST TIME HITS TO DATABASE
		d1 = (Department) ses.load(Department.class, new Integer(1));
		System.out.println("Getting values from database");
		System.out.println("Department id is "+d1.getDeptid());
		System.out.println("Department Name is "+d1.getDname());
		System.out.println("--------------------------------------------------");
		
		
		//LOADING SAME DEPARTMENT FOR THE SECOND TIME WILL NOT HIT DATABASE, INSTEAD GETS THE VALUE FROM SESSION CACHE
		d1 = (Department) ses.load(Department.class, new Integer(1));
		System.out.println("Getting values from cache");
		System.out.println("Department id is "+d1.getDeptid());
		System.out.println("Department Name is "+d1.getDname());
		System.out.println("--------------------------------------------------");
		
		
	/*	
		// evict() METHOD REMOVES A PARTICULAR OBJECT FROM THE SESSION CACHE 
		ses.evict(d1);
		
		//AS DEPARTMENT IS EVICTED FROM CACHE, LOADING DEAPRTMENT THIS TIME HITS THE DATABASE AGAIN
		d1 = (Department) ses.load(Department.class, new Integer(1));
		System.out.println("Getting values after evicting");
		System.out.println("Department id is "+d1.getDeptid());
		System.out.println("Department Name is "+d1.getDname());
		System.out.println("--------------------------------------------------");
	
	*/	
		
   		
		//LOADING ONE MORE DEPARTMENT
	/*	Department d2 = null;
	    d2 = (Department) ses.load(Department.class, new Integer(2));
	    System.out.println("Getting values from database");
		System.out.println("Department id is "+d2.getDeptid());
		System.out.println("Department Name is "+d2.getDname());
		System.out.println("--------------------------------------------------");
		
		d2 = (Department) ses.load(Department.class, new Integer(2));
		System.out.println("Getting values from cache");
		System.out.println("Department id is "+d2.getDeptid());
		System.out.println("Department Name is "+d2.getDname());
		System.out.println("--------------------------------------------------");
		
 	*/	
	
		//clear() METHOD REMOVES ALL THE OBJECTS FROM THE SESSION CACHE
	/*	ses.clear();
		
		System.out.println("After clearing session");
		d1 = (Department) ses.load(Department.class, new Integer(1));
		System.out.println("Department id is "+d1.getDeptid());
		System.out.println("Department Name is "+d1.getDname());
		System.out.println("--------------------------------------------------");
		
		d2 = (Department) ses.load(Department.class, new Integer(2));
		System.out.println("Department id is "+d2.getDeptid());
		System.out.println("Department Name is "+d2.getDname());
		System.out.println("--------------------------------------------------");
	 */   		
		tx.commit();
		ses.close();
		sf.close();
	}
}
