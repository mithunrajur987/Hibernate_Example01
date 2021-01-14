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

		Address add1 = new Address();
		add1.setCity("BANGALORE");
		add1.setZipcode("560010");

		Student stu1 = new Student();
		stu1.setSname("RAVI");
		stu1.setAddress(add1);

		Student stu2 = new Student();
		stu2.setSname("KUMAR");
		stu2.setAddress(add1);

		Student stu3 = new Student();
		stu3.setSname("AMOGH");
		stu3.setAddress(add1);

		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();

	/*
		ses.save(stu1);
		ses.save(stu2);
		ses.save(stu3);
	*/	
		// STUDENT CAN GET ADDRESS
	/*	Student stu = (Student)ses.load(Student.class, new Integer(2));
		System.out.println("student id is " + stu.getSid());
		System.out.println("student name is " + stu.getSname());
		System.out.println("student city is " + stu.getAddress().getCity());
		System.out.println("student zipcode is " + stu.getAddress().getZipcode());
	*/	
		
		// ADDRESS CANNOT GET STUDENT 
	/*	Address add1 = (Address)ses.load(Address.class, new Integer(2));
		System.out.println("address id is " + add1.getAid());
		System.out.println("address city is " + add1.getCity());
		System.out.println("address zipcode is " + add1.getZipcode());
	*/

		tx.commit();
		ses.close();
		sf.close();
	}
}
