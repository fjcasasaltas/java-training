package es.indra.training.locator;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {

	private static Map<String, String> map = new HashMap<String, String>();
	static {
		map.put("MyService", "ejb:app-ear/app-ejb//MyService!es.indra.training.ejb.MyServiceRemote");
	}

	public static Object lookup(String name) {
		
		Context ctx = null;
		try {
			
			// Configure the JNDI properties
			final Properties jndiProperties = new Properties();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

			// Create the initial context
			ctx = new InitialContext(jndiProperties);

		} catch (NamingException e) {
			return null;
		}

		Object o = null;
		try {
			String jndiName = map.get(name);
			o = ctx.lookup(jndiName);
		} catch (NamingException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				ctx.close();	
			} catch (Exception e) {
				//
			}
		}

		return o;

	}

}
