package com.fjcasasaltas.training.jee.jaxrs.business.bean;

import java.io.Serializable;
import java.util.Date;

public class CustomerBean implements Serializable {

	private static final long serialVersionUID = -4663062016735505262L;

	private Long id;
	private String name;
	private String lastName;
	private Date birthday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
