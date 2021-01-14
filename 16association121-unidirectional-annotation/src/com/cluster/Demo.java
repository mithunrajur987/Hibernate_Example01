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

		Passport p = new Passport();
		p.setPnumber("A1234567");

		Citizen c = new Citizen();
		c.setCname("RAVI");
		// ASSOCIATE PASSPORT WITH CITIZEN
		c.setPassport(p);

		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();
	//	ses.save(c);
		
		// CITIZEN CAN ACCESS PASSPORT
	/*	Citizen cz = (Citizen)ses.load(Citizen.class, new Integer(1));
		System.out.println("Citizen id is " + cz.getCid());
		System.out.println("Citizen name is " + cz.getCname());
		
		System.out.println("Citizen passport number is " + cz.getPassport().getPnumber());
	*/	
		
		// PASSPORT CANNOT ACCESS CITIZEN
	/*	Passport pt = (Passport)ses.load(Passport.class, new Integer(1));
		System.out.println("Passport id is " + pt.getPid());
		System.out.println("Passport number is " + pt.getPnumber());
	*/		
		tx.commit();
		ses.close();
		sf.close();
	}
}
