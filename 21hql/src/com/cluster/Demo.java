package com.cluster;

import java.util.List;

import org.hibernate.Query;
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

		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();

	/*	
		*//**FROM CLAUSE*//*
		//FROM clause loads all Employee persistent objects
		Query q = ses.createQuery("from Employee");
		List li = q.list();

		for (Object obj : li) {
			Employee e = (Employee) obj;
			System.out.println("Employee Id is " + e.getEmpid());
			System.out.println("Employee Name is " + e.getEname());
			System.out.println("Employee email is " + e.getEmail());
			System.out.println("Employee department name is " + e.getDepartment().getDname());
			System.out.println("-------------------------------------------");
		}
		
	*/
	
		
	/*		
		*//**SELECT CLAUSE*//*
		 //SELECT clause is used to select required properties from the persistent object
		Query q = ses.createQuery("select e.empid, e.ename,e.email from Employee e");
		List li = q.list();
		
		for (Object obj : li) {
			Object[] ao = (Object[]) obj;
			System.out.println("Employee Id is " + ao[0]);
			System.out.println("Employee Name is "+ao[1]);
			System.out.println("Employee Email is "+ao[2]);
			System.out.println("-------------------------------------------");
		}
	*/
	
		
	/*	
		*//**ORDER BY CLAUSE*//*
		// ORDER BY clause is used to sort the result
		Query q = ses.createQuery("select e.ename,e.email from Employee e order by e.ename desc");//default is ascending
		List li = q.list();
		

		for (Object obj : li) {
			Object[] ao = (Object[]) obj;
			System.out.println("Employee Name is " + ao[0]);
			System.out.println("Employee email is "+ao[1]);
			System.out.println("-------------------------------------------");
		}
	*/
		
		
	/*	
		*//** WHERE CLAUSE*//*
		// WHERE clause is used for selecting rows by giving conditions.
		Query q = ses.createQuery("select e.empid, e.ename,e.email from Employee e where e.ename = 'BOND'");
		List li = q.list();
		

		for (Object obj : li) {
			Object[] ao = (Object[]) obj;
			System.out.println("Employee Id is " + ao[0]);
			System.out.println("Employee Name is "+ao[1]);
			System.out.println("Employee Email is "+ao[2]);
		}
	*/
		
		
	/*		
		// USING NAMED PARAMETERS
		Query q = ses.createQuery("select e.empid, e.ename,e.email from Employee e where e.ename = :nme");
		q.setParameter("nme", "BOND");
		List li = q.list();
		
		for (Object obj : li) {
			Object[] ao = (Object[]) obj;
			System.out.println("Employee Id is " + ao[0]);
			System.out.println("Employee Name is "+ao[1]);
			System.out.println("Employee email is " + ao[2]);
		}
	*/
		
		
	/*	
		// EQUI JOIN
		Query q = ses.createQuery("select e.empid, e.ename, d.dname from Employee e  join e.department d");
		List li = q.list();

		for (Object obj : li) {
			Object[] ao = (Object[]) obj;
			System.out.println("Employee Id is " + ao[0]);
			System.out.println("Employee Name is " + ao[1]);
			System.out.println("Department name is " + ao[2]);
			System.out.println("-------------------------------------------");
		}
	*/	
		
	/*	
		// hibernate pagination
		Query q = ses.createQuery("select e.empid, e.ename,e.email from Employee e");
		//q.setFirstResult(2); //provide the first row to retrieve
		//q.setMaxResults(4); //provide the maximum number of rows to retrieve
		List li = q.list();
		

		for (Object obj : li) {
			Object[] ao = (Object[]) obj;
			System.out.println("Employee Id is " + ao[0]);
			System.out.println("Employee Name is "+ao[1]);
			System.out.println("Employee email is " + ao[2]);
			System.out.println("-------------------------------------------");
		}
	*/
		
	/*	
		*//**UPDATE OPERATION IN HQL*//*
		Query q = ses.createQuery("update Employee e set e.email = :em  where e.empid = :eid");
		q.setParameter("em", "JAMES@CLUSTERINDIA.COM");
		q.setParameter("eid", 5);
		q.executeUpdate();
		
		int result = q.executeUpdate();
		System.out.println("No of rows affected: " + result);
	*/	
		
	/*		
		*//**DELETE OPERATION IN HQL*//*
		Query q = ses.createQuery("delete from Employee e where e.empid = :eid");
		q.setParameter("eid", 2);
		q.executeUpdate();
		
		System.out.println("Deletion Completed");
	*/	
		
		tx.commit();
		ses.close();
		sf.close();
	}
}
