package com.designpattern.concurrent.concurrency.examples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class LockExample {
	private int value;
	private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
	private Lock rLock = rwLock.readLock();
	private Lock wLock = rwLock.writeLock();

	public LockExample(int value) {
		this.value = value;
	}

	public int getValue() {
		rLock.lock();
		try {
			return this.value;
		} finally {
			rLock.unlock();
		}
	}

	public void setValue(int value) {
		wLock.lock();
		try {
			this.value = value;
		} finally {
			wLock.unlock();
		}
	}
}
