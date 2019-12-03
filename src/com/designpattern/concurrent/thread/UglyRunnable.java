package com.designpattern.concurrent.thread;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class UglyRunnable implements Runnable {
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			// Heavy operation
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Other operation
		}
	}
}
