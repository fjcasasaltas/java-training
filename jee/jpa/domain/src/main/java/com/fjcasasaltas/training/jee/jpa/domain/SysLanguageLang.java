package com.fjcasasaltas.training.jee.jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_LANGUAGE_LANG")
public class SysLanguageLang implements Serializable {

	private static final long serialVersionUID = -1034912421715064326L;

	// Attributes

	@EmbeddedId
	private SysLanguageLangPK id;

	@Column(name = "NAME", length = 100, nullable = false)
	private String name;

	// Getters and setters

	public SysLanguageLangPK getId() {
		return id;
	}

	public void setId(SysLanguageLangPK id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
