package com.fjcasasaltas.training.jaxrs.business;

import java.util.List;

import com.fjcasasaltas.training.jee.jaxrs.business.bean.CustomerBean;

public interface CustomerServiceRemote {

	List<CustomerBean> getAll();
	
	CustomerBean getById(Long id);
	
}
