package com.cluster;

import java.util.HashSet;
import java.util.Set;

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

		Person per = new Person();
		per.setPname("RAVI");

		Phone ph1 = new Phone();
		ph1.setPnumber("9845012345");
		// ASSOCIATE PERSON WITH PHONE
		ph1.setPerson(per);

		Phone ph2 = new Phone();
		ph2.setPnumber("9448012345");
		// ASSOCIATE PERSON WITH PHONE
		ph2.setPerson(per);

		Set<Phone> s = new HashSet<>();
		s.add(ph1);
		s.add(ph2);

		// ASSOCIATE PHONE WITH PERSON
		per.setPhones(s);

		Session ses = null;
		Transaction tx = null;
		SessionFactory sf = null;
		try {
			sf = MyHibernateUtil.getSessionFactory();
			ses = sf.openSession();
			tx = ses.getTransaction();

			tx.begin();  // BEGIN OF TRANSACTION

			ses.save(per);

			tx.commit();  // END OF TRANSACTION
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("value not inserted....");
			tx.rollback(); // END OF TRANSACTION
		}

		finally {
			if (ses != null) {
				ses.close();
			}
			
			if (sf != null) {
				sf.close();
			}
		}
	}
}
