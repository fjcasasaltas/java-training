package com.fjcasasaltas.training.jee.cdi.event;

import java.io.Serializable;

public class ConnectionEvent implements Serializable {

	private static final long serialVersionUID = 4035773217743946983L;

	private long timestamp;

	private String driverName;

	public ConnectionEvent() {

	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

}
