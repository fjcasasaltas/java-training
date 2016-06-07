package com.fjcasasaltas.training.threads.synchronization.demo2;

public class ChangeMaker extends Process {

	@Override
	public void run() {
		System.out.println(String.format("Starting %s process...", this.getProcessName()));
		int i = 0;
		do {
			i++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (i < 5);
		System.out.println(String.format("Process %s finished", this.getProcessName()));
		running = false;
	}

}
