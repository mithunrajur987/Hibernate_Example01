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
// PROGRAM TO GIVE DEMO ON ATTRIBUTE cascade="none" OF <set> TAG
public class Demo2 {

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
		//WE HAVE TO EXPLICITY SAVE PARENT AND CHILD
	/*	ses.save(dept);
		ses.save(emp1);
		ses.save(emp2);
		ses.save(emp3);
	*/		
		
		/**delete operation*/
		//WE HAVE TO EXPLICITY DELETE PARENT AND CHILD
		//DELETETING PARENT DELETES ONLY PARENT AND LEAVES ORPHANS IN CHILD
	/*	Department d = (Department)ses.load(Department.class, new Integer(1));
		ses.delete(d);
	*/	

		// IT DELETES ONLY CHILD AND NOT THE PARENT
	/*	Employee e = (Employee)ses.load(Employee.class, new Integer(1));
		ses.delete(e);
	 */		
		tx.commit();
		ses.close();
		sf.close();
	}
}
