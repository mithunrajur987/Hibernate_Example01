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
// PROGRAM TO GIVE DEMO ON ATTRIBUTE cascade="delete-orphan" OF <set> TAG
public class Demo6 {

	public static void main(String[] args) {
		
		Department dept = new Department();
		dept.setDname("HR");

		Employee emp1 = new Employee();
		emp1.setEname("AAA");
		emp1.setEmail("A@GMAIL.com");
		
		Employee emp2 = new Employee();
		emp2.setEname("BBB");
		emp2.setEmail("B@GMAIL.com");
		
		Employee emp3 = new Employee();
		emp3.setEname("CCC");
		emp3.setEmail("C@GMAIL.com");
		
		Set<Employee> s = new HashSet<>();
		s.add(emp1);
		s.add(emp2);
		s.add(emp3);
		
		//associate employees with department
		dept.setEmployees(s);
		
		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();

		
		/**save operation*/
		//WE HAVE TO EXPLICITY SAVE CHILD FIRST AND PARENT NEXT
		
	/*	ses.save(emp1);
		ses.save(emp2);
		ses.save(emp3);
		ses.save(dept);
	*/
		//DETACHING CHILD FROM PARENT WILL DELETE CHILD RECORD IN TABLE
		
		Department d = (Department)ses.load(Department.class, new Integer(1));
		Set<Employee> s1 = d.getEmployees();
		s1.clear(); // clear is a collection method
	
				
		tx.commit();
		ses.close();
		sf.close();
	}
}
