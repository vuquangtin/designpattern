package com.designpattern.concurrent.concurrency.issuesandsyn;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class MemoryConsistencyErrorExample {
	private static boolean sayHello = false;

	public static void main(String[] args) throws InterruptedException {

		Thread thread = new Thread(() -> {
			while (!sayHello) {

			}

			System.out.println("Hello World!");

			while (sayHello) {

			}

			System.out.println("Good Bye!");
		});

		thread.start();

		Thread.sleep(1000);
		System.out.println("Say Hello..");
		sayHello = true;

		Thread.sleep(1000);
		System.out.println("Say Bye..");
		sayHello = false;
	}
}