package com.fjcasasaltas.training.threads.synchronization.demo1;

public class ChangeListener extends Process {

	@Override
	public void run() {
		System.out.println(String.format("Starting %s process...", this.getProcessName()));
		boolean r = running;
		while (r) {
			if (r != running) {
				r = running;
			}
		}
		System.out.println(String.format("Process %s finished", this.getProcessName()));
	}

}
