package com.fjcasasaltas.training.jee.jpa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SYS_PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
public class SysPerson implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 2531719002050872877L;

	@Column(name = "ID")
	@GeneratedValue
	@Id
	private Long id;

	@Column(name = "START_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "sysPerson")
	private SysPersonData sysPersonData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public SysPersonData getSysPersonData() {
		return sysPersonData;
	}

	public void setSysPersonData(SysPersonData sysPersonData) {
		this.sysPersonData = sysPersonData;
	}

}
