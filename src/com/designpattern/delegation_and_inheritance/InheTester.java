package com.designpattern.delegation_and_inheritance;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class InheTester {

	// To the outside world it looks like Printer actually prints.
	public static void main(String[] args) {
		InhePrinter printer = new InhePrinter();
		printer.print();
	}
}