package com.cluster;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.cluster.Employee;

/**
 *  Cluster Software Solutions.
 *  (Mob:98451-31637/39
 *  www.clusterindia.com)
 */
public class Demo {

	public static void main(String[] args) {

		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();

		Employee e = new Employee();
		e.setEname("BOND");
		Example ex = Example.create(e);
		
		Criteria c = ses.createCriteria(Employee.class);
		c.add(ex);
		List li = c.list();
		
		for (Object obj : li) {
			Employee emp = (Employee) obj;
			System.out.println("Employee Id is " + emp.getEmpid());
			System.out.println("Employee Name is " + emp.getEname());
			System.out.println("Employee email is " + emp.getEmail());
			System.out.println("Employee department is " + emp.getDepartment().getDname());
			System.out.println("-------------------------------------------");
		}
		
		
		tx.commit();
		ses.close();
		sf.close();
	}
}
