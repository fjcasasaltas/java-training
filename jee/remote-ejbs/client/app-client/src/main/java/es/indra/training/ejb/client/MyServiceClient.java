package es.indra.training.ejb.client;

import es.indra.training.ejb.MyServiceRemote;
import es.indra.training.locator.ServiceLocator;

public class MyServiceClient {

	public static void main(String[] args) throws Exception {

		// Lookup service
		final MyServiceRemote service = (MyServiceRemote) ServiceLocator.lookup("MyService");

		// Execute service method
		System.out.println(service.suma(1, 3));

	}

}
