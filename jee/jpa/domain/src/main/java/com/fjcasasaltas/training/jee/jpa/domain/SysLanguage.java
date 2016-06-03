package com.fjcasasaltas.training.jee.jpa.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_LANGUAGE")
public class SysLanguage implements Serializable {

	private static final long serialVersionUID = -1034912421715064326L;

	// Attributes

	@Column(name = "ID")
	@GeneratedValue
	@Id
	private Long id;

	@Column(name = "CODE", length = 5, nullable = false)
	private String code;

	@Column(name = "DATE_MASK", length = 20, nullable = false)
	private String dateMask;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.sysLanguage1")
	private Set<SysLanguageLang> sysLanguageLangs = new HashSet<>(0);

	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDateMask() {
		return dateMask;
	}

	public void setDateMask(String dateMask) {
		this.dateMask = dateMask;
	}

	public Set<SysLanguageLang> getSysLanguageLangs() {
		return sysLanguageLangs;
	}

	public void setSysLanguageLangs(Set<SysLanguageLang> sysLanguageLangs) {
		this.sysLanguageLangs = sysLanguageLangs;
	}

}
