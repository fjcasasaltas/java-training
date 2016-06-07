package com.fjcasasaltas.training.threads.synchronization.demo1;

public abstract class Process extends Thread {

	// By default, JVM uses a cache to store attribute value for each thread
	protected static boolean running = true;

	public String getProcessName() {
		return this.getClass().getSimpleName();
	}

}