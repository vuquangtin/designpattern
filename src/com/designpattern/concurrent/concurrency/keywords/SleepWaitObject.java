package com.designpattern.concurrent.concurrency.keywords;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class SleepWaitObject implements Runnable {
	WaitObject b;

	public SleepWaitObject(WaitObject b) {
		this.b = b;
	}

	private void sleepWaitExamples() throws InterruptedException {		
		synchronized (b) {
			while (b.getSum() == 0) {
				System.out.println("Waiting for ThreadB to complete...");
				b.wait();
			}
			System.out.println("ThreadB has completed. "
					+ "Sum from that thread is: " + b.getSum());
		}

	}

	@Override
	public void run() {
		try {
			sleepWaitExamples();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
