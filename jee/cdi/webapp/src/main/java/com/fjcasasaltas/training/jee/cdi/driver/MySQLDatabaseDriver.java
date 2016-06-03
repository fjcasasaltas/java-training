package com.fjcasasaltas.training.jee.cdi.driver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.fjcasasaltas.training.jee.cdi.event.ConnectionEvent;
import com.fjcasasaltas.training.jee.cdi.qualifier.Logged;
import com.fjcasasaltas.training.jee.cdi.qualifier.MySQL;

@Default
@MySQL
public class MySQLDatabaseDriver implements DatabaseDriver {

	@Inject
	private Event<ConnectionEvent> event;
	
	@PostConstruct
	public void postConstruct() {
		System.out.println(MySQLDatabaseDriver.class.getName() + " - postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println(MySQLDatabaseDriver.class.getName() + " - preDestroy");
	}
	
	@Logged
	@Override
	public void connect() {
		ConnectionEvent connectionEvent = new ConnectionEvent();
		connectionEvent.setDriverName("MySQL");
		connectionEvent.setTimestamp(System.currentTimeMillis());
		event.fire(connectionEvent);
	}
	
	@Logged
	@Override
	public String getVersion() {
		return "MySQL 5.10.3";
	}

}
