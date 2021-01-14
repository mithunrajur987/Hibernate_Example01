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
		
		// CODE TO INSERT A RECORD INTO DATABASE
	/*	Employee emp = new Employee();
		emp.setNme("MALLU");
		emp.setSal(5000);
		tx.begin();
		ses.save(emp);
		tx.commit();
	 */
		// CODE TO READ A RECORD FROM DATABASE
	/*	tx.begin();
		Employee emp1 = (Employee)ses.load(Employee.class, new Integer(3));
		System.out.println("employee id is " + emp1.getEid());
		System.out.println("employee name is " + emp1.getNme());
		System.out.println("employee salary is " + emp1.getSal());
		tx.commit();
	*/	
		// CODE TO UPDATE A RECORD IN DATABASE
	/*	tx.begin();
		Employee emp1 = (Employee)ses.load(Employee.class, new Integer(3));
		emp1.setNme("AMOGH KUMAR");
		emp1.setSal(33333);
		ses.update(emp1);
		tx.commit();
	*/	
	
	/*	// CODE TO DELETE A RECORD IN DATABASE
		tx.begin();
		Employee emp1 = (Employee)ses.load(Employee.class, new Integer(4));
		ses.delete(emp1);
		tx.commit();
	*/	
		
		ses.close();
		sf.close();
		
	}
}
