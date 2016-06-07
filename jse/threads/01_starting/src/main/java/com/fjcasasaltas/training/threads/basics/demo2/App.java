package com.fjcasasaltas.training.threads.basics.demo2;

public class App {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new Processor());
		thread1.start();
		Thread thread2 = new Thread(new Processor());
		thread2.start();
		
	}

}
