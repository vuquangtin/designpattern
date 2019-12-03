package com.designpatterns.creational.singleton.init;
/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class ThreadSafeSingleton {
	private static volatile ThreadSafeSingleton instance;

	private ThreadSafeSingleton() {

	}

	public static synchronized ThreadSafeSingleton getInstance() {
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
}