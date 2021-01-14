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
public class Demo {

	public static void main(String[] args) {

		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();

		Query q = ses.getNamedQuery("empdetails").setString("nme", "JAMES");
		List li = q.list();
		
		for (Object obj : li) {
			Object[] ao = (Object[]) obj;
			System.out.println("Employee Id is " + ao[0]);
			System.out.println("Employee Name is "+ao[1]);
			System.out.println("Employee email is " + ao[2]);
		}

		tx.commit();
		ses.close();
		sf.close();
	}
}
