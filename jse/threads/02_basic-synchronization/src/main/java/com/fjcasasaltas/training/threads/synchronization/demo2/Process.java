package com.fjcasasaltas.training.threads.synchronization.demo2;

public abstract class Process extends Thread {

	// Using 'volatile' keywork, attribute value will not be cached by JVM
	protected static volatile boolean running = true;

	public String getProcessName() {
		return this.getClass().getSimpleName();
	}

}