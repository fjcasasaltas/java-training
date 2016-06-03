package com.fjcasasaltas.training.jee.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "SEC_USER")
@PrimaryKeyJoinColumn
public class SecUser extends SysPerson {

	/** The serialVersionUID. */
	private static final long serialVersionUID = -2874584910774475256L;

	@Column(name = "LOGIN", length = 15, nullable = false)
	private String login;

	@Column(name = "PASSWORD", length = 15, nullable = false)
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
