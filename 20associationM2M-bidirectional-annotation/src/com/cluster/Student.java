package com.cluster;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *  Cluster Software Solutions.
 *  (Mob:98451-31637/39
 *  www.clusterindia.com)
 */
@Entity
@Table(name = "STUDENT")
public class Student {

	private int sid;
	private String sname;
	private Set<Course> courses;

	@Id
	@Column(name = "SID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Column(name = "SNAME")
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENTCOURSE", joinColumns = { @JoinColumn(name = "SID") }, inverseJoinColumns = { @JoinColumn(name = "CID") })
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}
