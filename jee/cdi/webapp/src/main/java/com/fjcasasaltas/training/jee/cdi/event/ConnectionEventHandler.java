package com.fjcasasaltas.training.jee.cdi.event;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;

@SessionScoped
public class ConnectionEventHandler implements Serializable {

	private static final long serialVersionUID = -6068583835781967435L;

	public void onConnectionEvent(@Observes ConnectionEvent event) {
		System.out.println("Received connection event: [driver=" + event.getDriverName() + ", timestamp=" + event.getTimestamp() + "]");
	}
	
}
