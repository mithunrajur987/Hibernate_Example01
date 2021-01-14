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
		emp.setNme("VINAY");
		emp.setSal(4000);
		
		Configuration con = new Configuration(); // starts the hiberante system
		con.configure();// loads and parses hibernate configuration and mapping files
		Properties prop = con.getProperties(); // stores all settings as key/value pair
		
		// used to create an instance of StandardServiceRegistry
		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
		
		//StandardServiceRegistry will start all the services configured in hibernate
		// configuration file like transation service, jndi service, caching, etc
		StandardServiceRegistry sr = srb.applySettings(prop).build();
		
		// create the SessionFactory object using Configuration object
		SessionFactory sf = con.buildSessionFactory(sr);  
		
		Session ses = sf.openSession(); // start the Session
		Transaction tx = ses.getTransaction();
		tx.begin(); // begin the transaction
		ses.save(emp); // save the domain object
		tx.commit(); // commit the transaction
		ses.close(); // close the Session
		sf.close(); // close the SessionFactory
		
		System.out.println("Inserted successfully in database");

	}

}
