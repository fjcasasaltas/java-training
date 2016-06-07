package com.fjcasasaltas.training.threads.synchronization.demo2;

public class App {

	public static void main(String[] args) {

		Process p1 = new ChangeMaker();
		Process p2 = new ChangeListener();

		p1.start();
		p2.start();

	}

}
