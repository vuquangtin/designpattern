package com.designpattern.concurrent.monitor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class SimpleMonitor {
	private final Lock lock = new ReentrantLock();

	public void testA() {
		lock.lock();

		try {
			// Some code
		} finally {
			lock.unlock();
		}
	}

	public int testB() {
		lock.lock();

		try {
			return 1;
		} finally {
			lock.unlock();
		}
	}
}
