package com.designpatterns.behavioral.interpreter.expression;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */

public class OneExpresssion extends Expression {
	public String one() {
		return "I";
	}

	public String four() {
		return "IV";
	}

	public String five() {
		return "V";
	}

	public String nine() {
		return "IX";
	}

	public int multiplier() {
		return 1;
	}
}