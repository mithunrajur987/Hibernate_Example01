package com.cluster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *  Cluster Software Solutions.
 *  (Mob:98451-31637/39
 *  www.clusterindia.com)
 */
@Entity
@Table(name = "PHONE")
public class Phone {
	private int phid;
	private String pnumber;
	private Person person;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PHID")
	public int getPhid() {
		return this.phid;
	}

	public void setPhid(int phid) {
		this.phid = phid;
	}

	@Column(name = "PNUMBER")
	public String getPnumber() {
		return this.pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	@ManyToOne
	@JoinColumn(name = "PID")
	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
