package com.fjcasasaltas.training.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloAjaxBean implements Serializable {

	private static final long serialVersionUID = 8282413804169436524L;

	private String name;
	private String lastName;

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

	public String getWelcomeMessage() {
		// check if null?
		if ("".equals(this.name) || this.name == null || "".equals(this.lastName) || this.lastName == null) {
			return "";
		} else {
			return "Ajax message : Welcome " + this.name + " " + this.lastName;
		}
	}

}
