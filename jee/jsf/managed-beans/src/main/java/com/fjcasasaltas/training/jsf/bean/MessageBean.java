package com.fjcasasaltas.training.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "message")
@SessionScoped
public class MessageBean {

	private String sayWelcome = "Welcome to JSF 2.0";

	public String getSayWelcome() {
		return sayWelcome;
	}

	public void setSayWelcome(String sayWelcome) {
		this.sayWelcome = sayWelcome;
	}
	
}
