package com.fjcasasaltas.training.jee.jaxrs.resource;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fjcasasaltas.training.jaxrs.business.CustomerServiceRemote;
import com.fjcasasaltas.training.jee.jaxrs.business.bean.CustomerBean;
import com.fjcasasaltas.training.jee.jaxrs.util.ServiceLocator;

@Path("/customers")
public class CustomerResource {

	private CustomerServiceRemote customerService;

	@PostConstruct
	public void init() {
		this.customerService = (CustomerServiceRemote) ServiceLocator.lookup("CustomerService");
	}
	
	@GET
	@Path("")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAll() {
		try {
			List<CustomerBean> customers = this.customerService.getAll();
			return Response.status(Status.OK).entity(customers).build();	
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response get(@PathParam(value = "id") Long id) {
		try {
			if (id == null) {
				return Response.status(Status.BAD_REQUEST).build();
			} else {
				CustomerBean customer = this.customerService.getById(id);
				return Response.status(Status.OK).entity(customer).build();	
			}
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
