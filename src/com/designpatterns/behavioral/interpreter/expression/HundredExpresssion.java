package com.designpatterns.behavioral.interpreter.expression;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
class HundredExpresssion extends Expression {
	public String one() {
		return "C";
	}

	public String four() {
		return "CD";
	}

	public String five() {
		return "D";
	}

	public String nine() {
		return "CM";
	}

	public int multiplier() {
		return 100;
	}
}
