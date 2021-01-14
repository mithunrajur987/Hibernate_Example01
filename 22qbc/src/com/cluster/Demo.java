package com.cluster;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

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

		
	/*	
		Criteria c = ses.createCriteria(Employee.class);
		List li = c.list();
		
		for (Object obj : li) {
			Employee e = (Employee) obj;
			System.out.println("Employee Id is " + e.getEmpid());
			System.out.println("Employee Name is " + e.getEname());
			System.out.println("Employee email is " + e.getEmail());
			System.out.println("Employee department is " + e.getDepartment().getDname());
			System.out.println("-------------------------------------------");
		}
	*/
		
	
	/*	
		Criteria c = ses.createCriteria(Employee.class);
		Criterion crn =  Restrictions.gt("empid", 3);
		c.add(crn);
		List li = c.list();
		
		for (Object obj : li) {
			Employee e = (Employee) obj;
			System.out.println("Employee Id is " + e.getEmpid());
			System.out.println("Employee Name is " + e.getEname());
			System.out.println("Employee email is " + e.getEmail());
			System.out.println("Employee department is " + e.getDepartment().getDname());
			System.out.println("-------------------------------------------");
		}
	*/
		
		
	/*	
		Criteria c = ses.createCriteria(Employee.class);
		Criterion crn =  Restrictions.like("ename", "J%");
		c.add(crn);
		List li = c.list();
		
		for (Object obj : li) {
			Employee e = (Employee) obj;
			System.out.println("Employee Id is " + e.getEmpid());
			System.out.println("Employee Name is " + e.getEname());
			System.out.println("Employee email is " + e.getEmail());
			System.out.println("Employee department is " + e.getDepartment().getDname());
			System.out.println("-------------------------------------------");
		}
	*/
		
	/*	
		Criteria c = ses.createCriteria(Employee.class);
		Criterion crn1 = Restrictions.like("ename", "J%");
		Criterion crn2 = Restrictions.eq("empid", 1);
		
		LogicalExpression le = Restrictions.and(crn1, crn2);
		c.add(le);
		
		List li = c.list();
		
		for (Object obj : li) {
			Employee e = (Employee) obj;
			System.out.println("Employee Id is " + e.getEmpid());
			System.out.println("Employee Name is " + e.getEname());
			System.out.println("Employee email is " + e.getEmail());
			System.out.println("Employee department is " + e.getDepartment().getDname());
			System.out.println("-------------------------------------------");
		}
	*/
		
	/*
		*//**ORDERING*//*	
		Criteria c = ses.createCriteria(Employee.class);
		c.addOrder(Order.desc("ename"));
		List li = c.list();
		
		
		for (Object obj : li) {
			Employee e = (Employee) obj;
			System.out.println("Employee Id is " + e.getEmpid());
			System.out.println("Employee Name is " + e.getEname());
			System.out.println("Employee email is " + e.getEmail());
			System.out.println("Employee department is " + e.getDepartment().getDname());
			System.out.println("-------------------------------------------");
		}
	*/	
		
		tx.commit();
		ses.close();
		sf.close();
	}
}
