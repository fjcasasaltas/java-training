package com.fjcasasaltas.training.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PageController implements Serializable {

	private static final long serialVersionUID = 1L;

	public String toPage4() {
		return "page4";
	}
	
}
