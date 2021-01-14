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

		Address add1 = new Address();
		add1.setCity("BANGALORE");
		add1.setZipcode("560010");

		Student stu1 = new Student();
		stu1.setSname("VINAY");
		//ASSOCIATE ADDRESS WITH STUDENT
		stu1.setAddress(add1);

		Student stu2 = new Student();
		stu2.setSname("GIRISH");
		//ASSOCIATE ADDRESS WITH STUDENT
		stu2.setAddress(add1);

		Student stu3 = new Student();
		stu3.setSname("AMOGH");
		//ASSOCIATE ADDRESS WITH STUDENT
		stu3.setAddress(add1);
		
		Set<Student> s = new HashSet<>();
		s.add(stu1);
		s.add(stu2);
		s.add(stu3);
		
		//ASSOCIATE STUDENTS WITH ADDRESS
		add1.setStudents(s);
		
		
		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();
		
	//	ses.save(add1);
		
		
		// ADDRESS CAN GET STUDENT
	/*	Address add = (Address)ses.load(Address.class, new Integer(1));
		System.out.println("address id is " + add.getAid());
		System.out.println("address city is " + add.getCity());
		System.out.println("address zipcode is " + add.getZipcode());
		
		Set<Student> x = add.getStudents();
		for (Student student : x) {
			System.out.println("Student Name "+student.getSname());
		}
	*/
		
		// STUDENT CAN GET ADDRESS BECAUSE IT IS BIDIRECTIONAL
	/*	Student stu = (Student)ses.load(Student.class, new Integer(2));
		System.out.println("student id is " + stu.getSid());
		System.out.println("student name is " + stu.getSname());
		
		System.out.println("student city is " + stu.getAddress().getCity());
		System.out.println("student zipcode is " + stu.getAddress().getZipcode());
	*/			
		
		tx.commit();
		ses.close();
		sf.close();
	}
}
