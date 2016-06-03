package com.fjcasasaltas.training.jee.jpa.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SysLanguageLangPK implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1468505584224846912L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID")
	private SysLanguage sysLanguage1;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSLATION_ID")
	private SysLanguage sysLanguage2;

	public SysLanguage getSysLanguage1() {
		return sysLanguage1;
	}

	public void setSysLanguage1(SysLanguage sysLanguage1) {
		this.sysLanguage1 = sysLanguage1;
	}

	public SysLanguage getSysLanguage2() {
		return sysLanguage2;
	}

	public void setSysLanguage2(SysLanguage sysLanguage2) {
		this.sysLanguage2 = sysLanguage2;
	}

}
