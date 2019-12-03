package com.designpatterns.creational.abstractfactory.windows;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
// ConcreteProductA2
public class MacOSXWindow implements Window {
	public void setTitle(String text) {
		// Mac OSX specific behaviour
		System.out.println("MacOSXWindow:" + text);
	}

	public void repaint() {
		// Mac OSX specific behaviour
	}
}