package com.fjcasasaltas.training.threads.basics.demo1;

public class App {

	public static void main(String[] args) {
		
		Processor process1 = new Processor();
		process1.start();
		Processor process2 = new Processor();
		process2.start();
		
	}

}
