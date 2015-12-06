package com.fjcasasaltas.training.jaxrs.business;

import com.fjcasasaltas.training.jee.jaxrs.business.bean.CustomerBean;

public interface CustomerServiceLocal extends CustomerServiceRemote {

	void saveOrUpdate(CustomerBean customer);

	void delete(CustomerBean customer);

}
