package com.designpattern.concurrent.concurrency.examples;

import java.util.concurrent.locks.Lock;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Philosopher {
	private Lock leftFork;
	private Lock rightFork;
	private String name; // Philosopher's name

	public Philosopher(Lock leftFork, Lock rightFork, String name) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.name = name;
	}

	public void think() {
		System.out.println(name + "  is thinking...");
	}

	public void eat() {
		if (leftFork.tryLock()) {
			try {
				if (rightFork.tryLock()) {
					try {
						System.out.println(name + "  is eating...");
					} finally {
						rightFork.unlock();
					}
				}
			} finally {
				leftFork.unlock();
			}
		}
	}
}