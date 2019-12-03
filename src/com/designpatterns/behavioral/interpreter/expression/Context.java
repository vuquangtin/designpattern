package com.designpatterns.behavioral.interpreter.expression;

/**
 * Design Patterns
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 *
 */
public class Context {
	public String input;
	public int output;

	public Context() {
	}

	public Context(String input) {
		this.input = input;
	}
}