package com.designpatterns.behavioral.interpreter.expression;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
class TenExpresssion extends Expression {
	public String one() {
		return "X";
	}

	public String four() {
		return "XL";
	}

	public String five() {
		return "L";
	}

	public String nine() {
		return "XC";
	}

	public int multiplier() {
		return 10;
	}
}
