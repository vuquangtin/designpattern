package com.designpattern.keywords.notifyandwait;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class NotSynchonizedThreadA {
	public static void main(String[] args) {
		NotSynchonizedThreadB b = new NotSynchonizedThreadB();
		b.start();

		System.out.println("Total is: " + b.total);

	}
}

class NotSynchonizedThreadB extends Thread {
	int total;

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			total += i;
		}
	}
}