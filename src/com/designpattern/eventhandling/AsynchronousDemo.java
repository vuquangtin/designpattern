package com.designpattern.eventhandling;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class AsynchronousDemo {

	private AsynchronousEventListener mListener; // listener field

	// setting the listener
	public void registerOnAsynchronousEventListener(
			AsynchronousEventListener mListener) {
		this.mListener = mListener;
	}

	// My Asynchronous task
	public void doGeekStuff() {

		// An Async task always executes in new thread
		new Thread(new Runnable() {
			public void run() {

				// perform any operation
				System.out.println("Performing operation in Asynchronous Task");

				// check if listener is registered.
				if (mListener != null) {

					// invoke the callback method of class A
					mListener.onAsynchronousEvent();
				}
			}
		}).start();
	}

	// Driver Program
	public static void main(String[] args) {

		AsynchronousDemo obj = new AsynchronousDemo();
		AsynchronousEventListener mListener = new ImplAsynchronousEventListener();
		obj.registerOnAsynchronousEventListener(mListener);
		obj.doGeekStuff();
	}
}