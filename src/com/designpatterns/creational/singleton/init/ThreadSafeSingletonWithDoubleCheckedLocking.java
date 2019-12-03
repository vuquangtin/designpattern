package com.designpatterns.creational.singleton.init;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ThreadSafeSingletonWithDoubleCheckedLocking {
	private static volatile ThreadSafeSingletonWithDoubleCheckedLocking instance;

	private ThreadSafeSingletonWithDoubleCheckedLocking() {

	}

	public static ThreadSafeSingletonWithDoubleCheckedLocking getInstanceUsingDoubleLocking() {
		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingletonWithDoubleCheckedLocking();
				}
			}
		}
		return instance;
	}
}