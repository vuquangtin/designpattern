package com.designpattern.delegation_and_inheritance;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
// Printer Inheriting functionality of real printer
public class InhePrinter extends RealPrinter {

	public void print() {
		super.print(); // inside calling method of parent
	}
}
