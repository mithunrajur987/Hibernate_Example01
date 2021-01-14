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
		
		Department dept = new Department();
		dept.setDname("IT");

		Employee emp1 = new Employee();
		emp1.setEname("TOM");
		emp1.setEmail("TOM@GMAIL.com");
		//ASSOCIATE DEPARTMENT WITH EMPLOYEE
		emp1.setDepartment(dept);
		
		Employee emp2 = new Employee();
		emp2.setEname("JOHN");
		emp2.setEmail("JOHN@GMAIL.com");
		//ASSOCIATE DEPARTMENT WITH EMPLOYEE
		emp2.setDepartment(dept);
		
		Employee emp3 = new Employee();
		emp3.setEname("PETER");
		emp3.setEmail("PETER@GMAIL.com");
		//ASSOCIATE DEPARTMENT WITH EMPLOYEE
		emp3.setDepartment(dept);
		
		Set<Employee> s = new HashSet<>();
		s.add(emp1);
		s.add(emp2);
		s.add(emp3);
		
		//ASSOCIATE EMPLOYEES WITH DEPARTMENT
		dept.setEmployees(s);
		
		SessionFactory sf = MyHibernateUtil.getSessionFactory();
		Session ses = sf.openSession();
		Transaction tx = ses.getTransaction();
		tx.begin();
		
	//	ses.save(dept);
		
		// DEPARTMENT CAN ACCESS EMPLOYEE 
	/*	Department d = (Department)ses.load(Department.class, new Integer(1));
		System.out.println("Department id is " + d.getDeptid());
		System.out.println("Department name is " + d.getDname());
		
		
		Set<Employee> e = d.getEmployees();
		
		for (Employee emp : e) {
			System.out.println("employee id is " + emp.getEmpid());
			System.out.println("employee name is " + emp.getEname());
			System.out.println("employee email is " + emp.getEmail());
		}
	*/
	
	
		// EMPLOYEE CAN ACCESS DEPARTMENT BECAUSE IT IS BIDRECTIONAL
	/*	Employee e = (Employee)ses.load(Employee.class, new Integer(2));
		System.out.println("Employee id is " + e.getEmpid());
		System.out.println("Employee name is " + e.getEname());
		System.out.println("Employee email is " + e.getEmail());
		
		System.out.println("Employee Department is "+e.getDepartment().getDeptid());
		System.out.println("Employee Department is "+e.getDepartment().getDname());
	*/
		
		tx.commit();
		ses.close();
		sf.close();
	}
}
