package com.cluster;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 *  Cluster Software Solutions.
 *  (Mob:98451-31637/39
 *  www.clusterindia.com)
 */
public class MyHibernateUtil {
	
	private static final SessionFactory sf = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
		try {
			Configuration con = new Configuration();
			con.configure();
			Properties prop = con.getProperties();
			StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
			StandardServiceRegistry sr = srb.applySettings(prop).build();
			SessionFactory fct = con.buildSessionFactory(sr);
			return fct;
			
		} catch (Exception ex) {
			System.err.println("SessionFactory creation failed" + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sf;
	}
	

}
