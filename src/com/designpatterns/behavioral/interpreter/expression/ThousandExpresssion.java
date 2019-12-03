package com.designpatterns.behavioral.interpreter.expression;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
class ThousandExpresssion extends Expression {
	public String one() {
		return "M";
	}

	public String four() {
		return " ";
	}

	public String five() {
		return " ";
	}

	public String nine() {
		return " ";
	}

	public int multiplier() {
		return 1000;
	}
}