package com.fjcasasaltas.training.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PaymentController implements Serializable {

	private static final long serialVersionUID = 1L;

	public int getOrderQty() {
		double d = Math.random();
		int i = (int) (d * 100.0);
		return i;
	}

	public boolean isRegisteredCompleted() {
		double d = Math.random();
		int i = (int) (d * 100.0);
		return i < 50;
	}

}