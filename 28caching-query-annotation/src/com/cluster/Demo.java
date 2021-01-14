package com.cluster;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *  Cluster Software Solutions.
 *  (Mob:98451-31637/39
 *  www.clusterindia.com)
 */
@SuppressWarnings("rawtypes")
public class Demo {

	public static void main(String[] args) {

		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();

		// HQL Query is used for the first time
		Query q1 = ses.createQuery("select e.empid, e.ename,e.email from Employee e where e.ename = 'JAMES'");

		// Enable caching of this query result set.
		q1.setCacheable(true);
		List li = q1.list();

		for (Object obj : li) {
			Object[] ao = (Object[]) obj;
			System.out.println("Employee Id is " + ao[0]);
			System.out.println("Employee Name is " + ao[1]);
			System.out.println("Employee Email is " + ao[2]);
		}

		System.out.println("-----------------------------------------");

		// HQL Query is used for the second time
		Query q2 = ses.createQuery("select e.empid, e.ename,e.email from Employee e where e.ename = 'JAMES'");
		q2.setCacheable(true);
		li = q2.list();
		System.out.println("Getting values from query cache");
		for (Object obj : li) {
			Object[] ao = (Object[]) obj;
			System.out.println("Employee Id is " + ao[0]);
			System.out.println("Employee Name is " + ao[1]);
			System.out.println("Employee Email is " + ao[2]);
		}

		tx.commit();
		ses.close();
		sf.close();
	}
}
