package com.fjcasasaltas.training.threads.synchronization.demo3;

public class App {

	private int counter = 0;
	
	public void doWork() {
		
		Thread t1 = new Thread( new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					counter++;
				}
			}
		});
		
		Thread t2 = new Thread( new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					counter++;
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(String.format("Counter = %d", counter));
		
	}
	
	public static void main(String[] args) {

		App app = new App();
		app.doWork();

	}

}
