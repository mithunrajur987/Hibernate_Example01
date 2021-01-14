package com.cluster;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *  Cluster Software Solutions.
 *  (Mob:98451-31637/39
 *  www.clusterindia.com)
 */
public class Demo {
	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setNme("RAVI");
		emp.setSal(1000);
		
		Configuration con = new Configuration();
		con.configure();
		Properties prop = con.getProperties();
		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
		StandardServiceRegistry sr = srb.applySettings(prop).build();
		
		SessionFactory sf = con.buildSessionFactory(sr);
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();
		ses.save(emp);
		tx.commit();
		ses.close();
		sf.close();
		System.out.println("Inserted successfully");

	}
}
