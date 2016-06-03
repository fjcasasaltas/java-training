package com.fjcasasaltas.training.jee.cdi.driver;

public interface DatabaseDriver {

	void connect();
	
	String getVersion();

}
