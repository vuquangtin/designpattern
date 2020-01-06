package com.others.docs.examples;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a
 *      href="https://github.com/vuquangtin/designpattern">https://github.com/vuquangtin/designpattern</a>
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// CallbackStatePerThread callbackStatePerThread =
		// CallbackState.callbackStatePerThread.get();
		Object lock = new Object();
		int i = 0;
		synchronized (lock) {
			i++;
		}
	}

	public static int subtractExact(int x, int y) {
		int r = x - y;
		if (((x ^ y) & (x ^ r)) < 0) {
			throw new ArithmeticException("integer overflow");
		}
		return r;
	}
}

class ExampleFinalField {
	private final int finalField;

	public ExampleFinalField(int value) {
		this.finalField = value;
	}

}

class ExampleVolatileField {
	private volatile int volatileField;
}
// class ForkJoinWorkerThread extends Thread {
// final ForkJoinPool pool;
// final ForkJoinPool.WorkQueue workQueue;
// }

// class CallbackState {
// public static final ThreadLocal<CallbackStatePerThread>
// callbackStatePerThread = new ThreadLocal<CallbackStatePerThread>() {
// @Override
// protected CallbackStatePerThread initialValue() {
// return getOrCreateCallbackStatePerThread();
// }
// };
// }
