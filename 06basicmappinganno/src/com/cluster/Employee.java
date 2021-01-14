package com.cluster;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 *  Cluster Software Solutions.
 *  (Mob:98451-31637/39
 *  www.clusterindia.com)
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	private Integer empid;
	private String ename;
	private Date doj;
	private Date login;
	private Double salary;
	
	@Id
	@Column(name = "EMPID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	
	@Column(name = "ENAME")
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DOJ")
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGIN")
	public Date getLogin() {
		return login;
	}
	public void setLogin(Date login) {
		this.login = login;
	}
	
	@Column(name = "SALARY")
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
