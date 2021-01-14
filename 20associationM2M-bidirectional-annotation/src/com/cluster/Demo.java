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

		Course c1 = new Course();
		c1.setCname("JAVA");

		Course c2 = new Course();
		c2.setCname("SERVLET");
		
		Course c3 = new Course();
		c3.setCname("JSP");

		Student s1 = new Student();
		s1.setSname("RAVI");

		Student s2 = new Student();
		s2.setSname("KUMAR");

		Set<Course> sc = new HashSet<>();
		sc.add(c1);
		sc.add(c2);
		sc.add(c3);
		

		Set<Student> ss = new HashSet<>();
		ss.add(s1);
		ss.add(s2);

		// ASSOCIATING STUDENT WITH COURSE
		c1.setStudents(ss);
		c2.setStudents(ss);
		c3.setStudents(ss);

		// ASSOCIATING COURSE WITH STUDENT
		s1.setCourses(sc);
		s2.setCourses(sc);

		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();
	/*	
		ses.save(s1);
		ses.save(s2);
	*/	
	
		// STUDENT CAN ACCESS COURSE
	/*	Student s = (Student)ses.load(Student.class, new Integer(1));
		System.out.println("Student id is " + s.getSid());
		System.out.println("Student name is " + s.getSname());
		
		Set <Course> z = s.getCourses();
		
		for (Course course : z) {
			System.out.println("This student has joined for following courses " + course.getCname());	
		}
		*/
		
		
		// COURSE CAN ACCESS STUDENT
	/*	Course c = (Course)ses.load(Course.class, new Integer(1));
		System.out.println("Course id is " + c.getCid());
		System.out.println("Course name is " + c.getCname());
		
		Set <Student> s = c.getStudents();
		
		for (Student stu : s) {
			System.out.println("Following students have joined for this course " + stu.getSname());	
		}
	*/
		
		
		tx.commit();
		ses.close();
		sf.close();
	}
}
