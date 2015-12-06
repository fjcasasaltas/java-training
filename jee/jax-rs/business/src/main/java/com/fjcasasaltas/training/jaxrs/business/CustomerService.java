package com.fjcasasaltas.training.jaxrs.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.fjcasasaltas.training.jaxrs.model.Customer;
import com.fjcasasaltas.training.jee.jaxrs.business.bean.CustomerBean;

@Local(CustomerServiceLocal.class)
@Remote(CustomerServiceRemote.class)
@Stateless(name = "CustomerService")
public class CustomerService implements CustomerServiceLocal {

	@PersistenceContext(unitName = "EXAMPLE")
	private EntityManager em;
	
	@Override
	public List<CustomerBean> getAll() {
		
		TypedQuery<Customer> query = this.em.createQuery("SELECT c FROM Customer c", Customer.class);
		List<Customer> resultList = query.getResultList();
		
		List<CustomerBean> customers = new ArrayList<>();
		for (Customer customer : resultList) {
			CustomerBean customerBean = new CustomerBean();
			this.map(customer, customerBean);
			customers.add(customerBean);
		}
		
		return customers;
		
	}
	
	@Override
	public CustomerBean getById(Long id) {
		Customer customer = this.em.find(Customer.class, id);
		if (customer != null) {
			CustomerBean customerBean = new CustomerBean();
			this.map(customer, customerBean);
			return customerBean;
		}
		return null;
	}

	@Override
	public void saveOrUpdate(CustomerBean customerBean) {
		final Long id = customerBean.getId();
		Customer customer = this.em.find(Customer.class, id);
		if (customer == null) {
			customer = new Customer();
		}
		this.map(customerBean, customer);
		this.em.persist(customer);
	}

	@Override
	public void delete(CustomerBean customerBean) {
		final Long id = customerBean.getId();
		Customer customer = this.em.find(Customer.class, id);
		if (customer != null) {
			this.em.remove(customer);
		}
	}

	protected void map(Customer customer, CustomerBean customerBean) {
		customerBean.setId(customer.getId());
		customerBean.setName(customer.getName());
		customerBean.setLastName(customer.getLastName());
		customerBean.setBirthday(customer.getBirthday());
	}
	
	protected void map(CustomerBean customerBean, Customer customer) {
		customer.setId(customerBean.getId());
		customer.setName(customerBean.getName());
		customer.setLastName(customerBean.getLastName());
		customer.setBirthday(customerBean.getBirthday());
	}

}
