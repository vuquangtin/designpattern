package com.designpattern.eventhandling;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class SynchronousDemo {

	private SynchronousListener mListener; // listener field

	// setting the listener
	public void registerOnGeekEventListener(SynchronousListener mListener) {
		this.mListener = mListener;
	}

	// my synchronous task
	public void doGeekStuff() {

		// perform any operation
		System.out.println("Performing callback before synchronous Task");

		// check if listener is registered.
		if (this.mListener != null) {

			// invoke the callback method of class A
			mListener.onSynchronousEvent();
		}
	}

	// Driver Function
	public static void main(String[] args) {
		SynchronousDemo obj = new SynchronousDemo();
		SynchronousListener mListener = new ImplSynchronousEventListener();
		obj.registerOnGeekEventListener(mListener);
		obj.doGeekStuff();
	}
}