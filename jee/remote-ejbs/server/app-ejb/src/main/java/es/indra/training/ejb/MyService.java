package es.indra.training.ejb;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless(name = "MyService")
@Local(MyServiceLocal.class)
@Remote(MyServiceRemote.class)
public class MyService implements MyServiceLocal {

	@Override
	public int suma(int a, int b) {
		return a + b;
	}

	@Override
	public int resta(int a, int b) {
		return a - b;
	}

}
