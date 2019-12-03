package com.designpattern.concurrent.lock;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class SynchronizedLockExample implements Runnable {

	private Resource resource;

	public SynchronizedLockExample(Resource r) {
		this.resource = r;
	}

	@Override
	public void run() {
		synchronized (resource) {
			resource.doSomething();
		}
		resource.doLogging();
	}
}
