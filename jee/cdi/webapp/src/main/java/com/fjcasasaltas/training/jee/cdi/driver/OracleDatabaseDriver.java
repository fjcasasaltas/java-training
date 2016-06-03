package com.fjcasasaltas.training.jee.cdi.driver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.fjcasasaltas.training.jee.cdi.event.ConnectionEvent;
import com.fjcasasaltas.training.jee.cdi.qualifier.Logged;
import com.fjcasasaltas.training.jee.cdi.qualifier.Oracle;

@Logged
@Oracle
@RequestScoped
public class OracleDatabaseDriver implements DatabaseDriver {

	@Inject
	private Event<ConnectionEvent> event;
	
	@PostConstruct
	public void postConstruct() {
		System.out.println(OracleDatabaseDriver.class.getName() + " - postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println(OracleDatabaseDriver.class.getName() + " - preDestroy");
	}
	
	@Override
	public void connect() {
		ConnectionEvent connectionEvent = new ConnectionEvent();
		connectionEvent.setDriverName("MySQL");
		connectionEvent.setTimestamp(System.currentTimeMillis());
		event.fire(connectionEvent);
	}
	
	@Override
	public String getVersion() {
		return "Oracle 11g - 11.0.1.2";
	}

}
