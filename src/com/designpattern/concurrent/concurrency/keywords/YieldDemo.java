package com.designpattern.concurrent.concurrency.keywords;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class YieldDemo implements Runnable {

	Thread t;

	YieldDemo(String str) {

		t = new Thread(this, str);
		// this will call run() function
		t.start();
	}

	public void run() {

		for (int i = 0; i < 10000; i++) {
			// yields control to another thread every 5 iterations
			if ((i % 5000) == 0) {
				System.out.println(Thread.currentThread().getName()
						+ " yielding control...");

				/*
				 * causes the currently executing thread object to temporarily
				 * pause and allow other threads to execute
				 */
				Thread.yield();
			}
		}

		System.out.println(Thread.currentThread().getName()
				+ " has finished executing.");
	}

	public static void main(String[] args) {
		new YieldDemo("Thread 1");
		new YieldDemo("Thread 2");
		//new YieldDemo("Thread 3");
	}
}
