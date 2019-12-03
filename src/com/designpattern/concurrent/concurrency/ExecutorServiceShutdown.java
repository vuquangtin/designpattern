package com.designpattern.concurrent.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ExecutorServiceShutdown {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("interrupted");
						break;
					}
				}
			}
		});

		executor.shutdown();
		if (!executor.awaitTermination(100, TimeUnit.MICROSECONDS)) {
			System.out
					.println("Still waiting after 100ms: calling System.exit(0)...");
			System.exit(0);
		}
		System.out.println("Exiting normally...");
	}
}
