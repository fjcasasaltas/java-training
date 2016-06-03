package com.fjcasasaltas.training.jee.jpa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SYS_PERSON_DATA")
public class SysPersonData implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 7531752344958254106L;

	@Column(name = "ID")
	@Id
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private SysPerson sysPerson;

	@Column(name = "NAME", length = 50, nullable = false)
	private String name;

	@Column(name = "LAST_NAME", length = 100, nullable = false)
	private String lastName;

	@Column(name = "BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Date birthday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SysPerson getSysPerson() {
		return sysPerson;
	}

	public void setSysPerson(SysPerson sysPerson) {
		this.sysPerson = sysPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
