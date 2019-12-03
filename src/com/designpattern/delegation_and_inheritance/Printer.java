package com.designpattern.delegation_and_inheritance;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Printer {
	// the "delegator"
	RealPrinter p = new RealPrinter();

	// create the delegate
	void print() {
		p.print(); // delegation
	}
}