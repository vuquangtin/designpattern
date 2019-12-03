package com.designpattern.concurrent.thread;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class InterruptableRunnable implements Runnable {
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			// Heavy operation
		}
	}
}