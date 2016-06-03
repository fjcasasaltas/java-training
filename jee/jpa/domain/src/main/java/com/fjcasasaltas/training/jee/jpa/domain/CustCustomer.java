package com.fjcasasaltas.training.jee.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CUST_CUSTOMER")
@PrimaryKeyJoinColumn
public class CustCustomer extends SysPerson {

	private static final long serialVersionUID = -1034912421715064326L;
	
}
