package com.cluster;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		Date lt = new Date(); // login time
		Date dj = null; // date of joining
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dj = sdf.parse("24/06/2014"); 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Employee emp = new Employee();
		emp.setEname("RAVI");
		emp.setDoj(dj);
		emp.setLogin(lt);
		emp.setSalary(1000.00);
		
		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();
		ses.save(emp);
		tx.commit();
		ses.close();
		sf.close();
	}
}
